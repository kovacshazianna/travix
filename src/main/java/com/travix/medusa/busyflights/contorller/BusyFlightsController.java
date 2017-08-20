package com.travix.medusa.busyflights.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main controller for the application.
 *
 * @author Anna_Kovacshazi
 */
@Controller
public class BusyFlightsController {

    private final Logger logger = LoggerFactory.getLogger(BusyFlightsController.class);
    private static final String FILE_NAME = "index";
    private static final String REQUEST_MAPPING = "/";

    @GetMapping(REQUEST_MAPPING)
    public String loadPage() {
        return FILE_NAME;
    }
}
