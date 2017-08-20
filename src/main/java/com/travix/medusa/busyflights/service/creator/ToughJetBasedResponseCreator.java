package com.travix.medusa.busyflights.service.creator;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.RequestConverter;
import com.travix.medusa.busyflights.service.ResponseConverter;
import com.travix.medusa.busyflights.service.ResponseCreator;
import com.travix.medusa.busyflights.service.connecion.SupplierConnector;
import org.json.JSONObject;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

/**
 * Creates the appropriate request for the ToughJet supplier
 * and returns the response as a list of {@link BusyFlightsResponse}.
 *
 * @author Anna_Kovacshazi
 */
public class ToughJetBasedResponseCreator implements ResponseCreator<BusyFlightsRequest, List<BusyFlightsResponse>> {

    static final String URI = "http://localhost:8080/supplier-tj";

    private final RequestConverter<BusyFlightsRequest, ToughJetRequest> requestConverter;
    private final ResponseConverter<ToughJetResponse, BusyFlightsResponse> responseConverter;
    private final SupplierConnector supplierConnector;

    public ToughJetBasedResponseCreator(RequestConverter<BusyFlightsRequest, ToughJetRequest> requestConverter,
        ResponseConverter<ToughJetResponse, BusyFlightsResponse> responseConverter, SupplierConnector supplierConnector) {
        this.requestConverter = requireNonNull(requestConverter);
        this.responseConverter = requireNonNull(responseConverter);
        this.supplierConnector = requireNonNull(supplierConnector);
    }

    @Override
    public List<BusyFlightsResponse> apply(BusyFlightsRequest busyFlightsRequest) {
        ToughJetRequest toughJetRequest = requestConverter.apply(busyFlightsRequest);
        List<ToughJetResponse> responseList = (List<ToughJetResponse>) supplierConnector.send(new JSONObject(toughJetRequest), URI, ToughJetResponse.class);
        return responseList.stream().map(response -> responseConverter.apply(response)).collect(toList());
    }
}
