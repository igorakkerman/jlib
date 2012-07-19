package org.jlib.container.sequence.index.array.storage;

import org.jlib.core.IllegalJlibArgumentException;

import org.jlib.container.sequence.IllegalSequenceStateException;

/**
 * {@link IllegalSequenceStateException} thrown when an illegal
 * {@link LinearIndexStorage} capacity is specified.
 * 
 * @author Igor Akkerman
 */
public class LinearIndexStorageException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -1514836335986845986L;

    /** referenced {@link LinearIndexStorage} */
    private final LinearIndexStorage<?> linearIndexStorage;

    /**
     * Creates a new {@link LinearIndexStorageException}.
     * 
     * @param linearIndexStorage
     *        referenced {@link LinearIndexStorage}
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param messageArguments
     *        array of {@link Object} message arguments
     */
    public LinearIndexStorageException(final LinearIndexStorage<?> linearIndexStorage, final String messagePattern,
                                       final Object... messageArguments) {
        super(messagePattern, linearIndexStorage, messageArguments);

        this.linearIndexStorage = linearIndexStorage;
    }

    /**
     * Returns the referenced {@link LinearIndexStorage}.
     * 
     * @return referenced {@link LinearIndexStorage}
     */
    public LinearIndexStorage<?> getLinearIndexStorage() {
        return linearIndexStorage;
    }
}
