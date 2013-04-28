package org.jlib.container.sequence.index.array.storage;

import org.jlib.core.IllegalJlibArgumentException;

/**
 * {@link IllegalJlibArgumentException} thrown when an invalid capacity
 * factor is specified.
 * 
 * @author Igor Akkerman
 */
class InvalidCapacityFactorException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 655924593848562967L;

    /**
     * Creates a new {@link InvalidCapacityFactorException}.
     * 
     * @param invalidFactorName
     *        String specifying the name of the invalid factor
     * 
     * @param invaldFactorValue
     *        integer specifying the invalid factor value
     */
    public InvalidCapacityFactorException(final String invalidFactorName, final int invaldFactorValue) {
        super("{0}: {1}", invalidFactorName, invaldFactorValue);
    }
}