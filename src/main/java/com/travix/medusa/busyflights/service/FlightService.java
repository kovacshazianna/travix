package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Service which returns a list of {@link BusyFlightsResponse}.
 *
 * @author Anna_Kovacshazi
 */
public class FlightService {
    private final Comparator<BusyFlightsResponse> COMPARATOR_BY_FARE_ASC = (o1, o2) -> {return o1.getFair().compareTo(o2.getFair());};
    private final List<ResponseCreator<BusyFlightsRequest, List<BusyFlightsResponse>>> responseCreators;

    public FlightService(List<ResponseCreator<BusyFlightsRequest, List<BusyFlightsResponse>>> responseCreators) {
        this.responseCreators = requireNonNull(responseCreators);
    }

    public List<BusyFlightsResponse> getFlights(BusyFlightsRequest request) {
        return responseCreators.stream()
                .map(creator -> creator.apply(request))
                .flatMap(list -> list.stream())
                .sorted(COMPARATOR_BY_FARE_ASC)
                .collect(Collectors.toList());
    }
}
