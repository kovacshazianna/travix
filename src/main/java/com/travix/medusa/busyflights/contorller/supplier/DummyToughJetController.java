package com.travix.medusa.busyflights.contorller.supplier;

import com.travix.medusa.busyflights.domain.common.Destination;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for the ajax request.
 * Returns some dummy response
 *
 * @author Anna_Kovacshazi
 */
@RestController
public class ToughJetController {
    private static final String REQUEST_MAPPING = "/supplier-tj";

    @PostMapping(value = REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ToughJetResponse>> loadResponse(@Valid @RequestBody ToughJetRequest request, Errors errors) {
        List<ToughJetResponse> responses = new ArrayList<>();
        if (!errors.hasErrors()) {
            responses = responses();
        }
        return ResponseEntity.ok(responses);
    }

    //DUMMY response
    private List<ToughJetResponse> responses() {
        return Arrays.asList(
            aToughJetResponse("airline 1", 50, 10, 3, Destination.LHR, Destination.AMS, "2017-08-21T10:15:30Z",  "2017-08-25T13:15:30Z"),
            aToughJetResponse("airline 3", 40, 8, 2, Destination.LHR, Destination.AMS, "2017-08-21T12:15:30Z",  "2017-08-25T15:15:30Z"),
            aToughJetResponse("airline 1", 60, 12, 5, Destination.LHR, Destination.AMS, "2017-08-21T08:15:30Z",  "2017-08-25T10:15:30Z")
        );
    }

    private ToughJetResponse aToughJetResponse(String airLine, double base, double tax, double discount, Destination dep, Destination arr,
        String isoInstatnO, String isoInstatnI) {

        ToughJetResponse response = new ToughJetResponse();
        response.setCarrier(airLine);
        response.setBasePrice(base);
        response.setTax(tax);
        response.setDiscount(discount);
        response.setDepartureAirportName(dep.name());
        response.setArrivalAirportName(arr.name());
        response.setOutboundDateTime(isoInstatnO);
        response.setInboundDateTime(isoInstatnI);
        return response;
    }

}
