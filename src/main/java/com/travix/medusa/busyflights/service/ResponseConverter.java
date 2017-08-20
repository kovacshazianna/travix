package com.travix.medusa.busyflights.service;

import java.util.function.Function;

/**
 * Creates response based on the given request.
 *
 * @author Anna_Kovacshazi
 */
public interface ResponseCreator<REQUEST, RESPONSE> extends Function<REQUEST, RESPONSE> {
}
