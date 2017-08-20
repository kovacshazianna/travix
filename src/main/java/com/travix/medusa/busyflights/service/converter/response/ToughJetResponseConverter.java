package com.travix.medusa.busyflights.service.converter.response;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.common.Destination;
import com.travix.medusa.busyflights.domain.common.Supplier;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.ResponseConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Converts a {@link ToughJetResponse} into a {@link BusyFlightsResponse}.
 *
 * @author Anna_Kovacshazi
 */
public class ToughJetResponseConverter implements ResponseConverter<ToughJetResponse, BusyFlightsResponse> {
    @Override
    public BusyFlightsResponse apply(ToughJetResponse toughJetResponse) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
        busyFlightsResponse.setSupplier(Supplier.TOUGHJET);
        busyFlightsResponse.setFair(getFare(toughJetResponse.getBasePrice(), toughJetResponse.getTax(), toughJetResponse.getDiscount()));
        busyFlightsResponse.setDepartureAirCode(destinationFrom(toughJetResponse.getDepartureAirportName()));
        busyFlightsResponse.setDestinationAirportCode(destinationFrom(toughJetResponse.getArrivalAirportName()));
        busyFlightsResponse.setDepartureDate(localDateStringFrom(toughJetResponse.getOutboundDateTime()));
        busyFlightsResponse.setArrivalDate(localDateStringFrom(toughJetResponse.getInboundDateTime()));
        return busyFlightsResponse;
    }

    private double getFare(double basePrice, double tax, double discount) {
        Double fare = basePrice + (0.01 * basePrice * discount) + tax;
        return Math.floor(fare * 100) / 100;
    }

    private Destination destinationFrom(String dest) {
        return Destination.valueOf(dest);
    }

    private String localDateStringFrom(String isoInstant) {
        DateTimeFormatter f = DateTimeFormatter.ISO_INSTANT;
        Instant instant = Instant.from(f.parse(isoInstant));
        return LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId())).toString();
    }
}
