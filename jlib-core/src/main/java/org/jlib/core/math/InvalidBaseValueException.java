package org.jlib.core.math;

import org.jlib.core.exception.IllegalJlibArgumentException;

/**
 * {@link IllegalJlibArgumentException} thrown when an invalid value has been specified
 * as a base.
 */
public class InvalidBaseValueException
extends IllegalJlibArgumentException {

    private final int baseValue;

    public InvalidBaseValueException(final int baseValue) {

        // TODO: create constant for "{0}"
        super("{0} < 1", baseValue);

        this.baseValue = baseValue;
    }

    public int getBaseValue() {
        return baseValue;
    }
}
