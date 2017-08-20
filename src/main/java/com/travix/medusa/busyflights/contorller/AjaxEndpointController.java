package com.travix.medusa.busyflights.contorller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.common.ErrorResponse;
import com.travix.medusa.busyflights.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Controller for the ajax request.
 *
 * @author Anna_Kovacshazi
 */
@RestController
public class AjaxEndpointController {
    private final Logger logger = LoggerFactory.getLogger(AjaxEndpointController.class);
    private static final String REQUEST_MAPPING = "/ajax-endpoint";

    @Inject
    private final FlightService flightService;

    public AjaxEndpointController(FlightService flightService) {
        this.flightService = Objects.requireNonNull(flightService);
    }

    @PostMapping(value = REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> loadResponse(@Valid @RequestBody BusyFlightsRequest request, Errors errors) {
        if (errors.hasErrors()) {
            ErrorResponse response = new ErrorResponse();
            response.setMsg(errors.getAllErrors()
                    .stream()
                    .map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(","))
            );
            return ResponseEntity.badRequest().body(Arrays.asList(response));
        }
        return ResponseEntity.ok(flightService.getFlights(request));
    }
}
