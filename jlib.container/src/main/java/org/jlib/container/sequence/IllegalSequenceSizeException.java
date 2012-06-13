package org.jlib.container.sequence;

import org.jlib.core.IllegalJlibArgumentException;

/**
 * {@link IllegalJlibArgumentException} thrown when trying to create a
 * {@link Sequence} with an invalid size.
 * 
 * @author Igor Akkerman
 */
public class IllegalSequenceSizeException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -23142560184875814L;

    /** illegal size */
    private final int size;

    /**
     * Creates a new {@link IllegalSequenceSizeException}.
     * 
     * @param size
     *        integer specifying the illegal size
     * 
     * @param messagePattern
     *        String specifying the error message pattern
     * 
     * @param messageArguments
     *        array of {@link Object} error message arguments
     */
    public IllegalSequenceSizeException(final int size, final String messagePattern, final Object... messageArguments) {
        super(messagePattern, messageArguments);

        this.size = size;
    }

    /**
     * Returns the illegal size.
     * 
     * @return integer specifying the illegal size
     */
    public int getSize() {
        return size;
    }
}
