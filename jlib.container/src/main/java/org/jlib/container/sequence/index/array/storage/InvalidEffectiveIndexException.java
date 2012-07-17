package org.jlib.container.sequence.index.array.storage;

import org.jlib.core.IllegalJlibArgumentException;

/**
 * Exception thrown when an invalid effective index is specified.
 * 
 * @author Igor Akkerman
 */
class InvalidEffectiveIndexException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -7606042021315378835L;

    /**
     * Creates a new {@link InvalidEffectiveIndexException} .
     * 
     * @param invalidEffectiveIndex
     *        integer specifying the invalid effective index
     * 
     * @param firstValidEffectiveIndex
     *        integer specifying the first valid effective index
     * 
     * @param lastValidEffectiveIndex
     *        integer specifying the last valid effective index
     */
    public InvalidEffectiveIndexException(final int invalidEffectiveIndex, final int firstValidEffectiveIndex,
                                          final int lastValidEffectiveIndex) {
        super("effectiveIndex: {0} [{1}, {2}]", invalidEffectiveIndex, firstValidEffectiveIndex,
              lastValidEffectiveIndex);
    }
}