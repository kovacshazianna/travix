package com.travix.medusa.busyflights.service;

import java.util.function.Function;

/**
 * Convert the request into the given request.
 *
 * @author Anna_Kovacshazi
 */
public interface RequestConverter<R, S> extends Function<R, S> {
}
