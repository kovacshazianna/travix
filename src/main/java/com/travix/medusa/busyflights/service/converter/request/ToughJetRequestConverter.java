package com.travix.medusa.busyflights.service.converter.request;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.service.RequestConverter;

/**
 * Converts a {@link BusyFlightsRequest} into a {@link ToughJetRequest}.
 *
 * @author Anna_Kovacshazi
 */
public class ToughJetRequestConverter implements RequestConverter<BusyFlightsRequest, ToughJetRequest> {
    @Override
    public ToughJetRequest apply(BusyFlightsRequest busyFlightsRequest) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin().name());
        toughJetRequest.setTo(busyFlightsRequest.getDestination().name());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate().toString());
        toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate().toString());
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
        return toughJetRequest;
    }
}
