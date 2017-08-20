package com.travix.medusa.busyflights.service.creator;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.ResponseCreator;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Creates the appropriate request for the Crazy Air supplier and returns the response as a list of {@link BusyFlightsResponse}.
 *
 * @author Anna_Kovacshazi
 */
public class CrazyAirBasedResponseCreator implements ResponseCreator<BusyFlightsRequest, List<BusyFlightsResponse>> {
    @Override
    public List<BusyFlightsResponse> apply(BusyFlightsRequest busyFlightsRequest) {
        //TODO DO the same as in {@link ToughJetBasedResponseCreator}
        //convert busyFlightsRequest request to supplier specific request
        //post it to the endpoint
        //convert response to BusyFlightsResponse
        return Collections.emptyList();
    }
}
