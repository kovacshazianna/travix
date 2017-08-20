package com.travix.medusa.busyflights.service;

import java.util.function.Function;

/**
 * Convert the response into the given response.
 *
 * @author Anna_Kovacshazi
 */
public interface ResponseConverter<R, S> extends Function<R, S> {
}
