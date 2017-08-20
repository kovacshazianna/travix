package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.FlightService;
import com.travix.medusa.busyflights.service.ResponseCreator;
import com.travix.medusa.busyflights.service.connecion.SupplierConnector;
import com.travix.medusa.busyflights.service.converter.request.ToughJetRequestConverter;
import com.travix.medusa.busyflights.service.converter.response.ToughJetResponseConverter;
import com.travix.medusa.busyflights.service.creator.CrazyAirBasedResponseCreator;
import com.travix.medusa.busyflights.service.creator.ToughJetBasedResponseCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration file.
 *
 * @author Anna_Kovacshazi
 */
@Configuration
public class BusyFlightsConfiguration {
    @Bean
    public FlightService flightService() {
        return new FlightService(supplierList());
    }

    private List<ResponseCreator<BusyFlightsRequest, List<BusyFlightsResponse>>> supplierList() {
        return Arrays.asList(
                new CrazyAirBasedResponseCreator(),
                new ToughJetBasedResponseCreator(
                        new ToughJetRequestConverter(),
                        new ToughJetResponseConverter(),
                        new SupplierConnector()
                )
        );
    }
}
