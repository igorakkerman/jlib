package org.jlib.container.sequence.index.array.storage;

import org.jlib.core.IllegalJlibArgumentException;

import org.jlib.container.sequence.IllegalSequenceStateException;

/**
 * {@link IllegalSequenceStateException} thrown when an illegal
 * {@link LinearIndexStorage} capacity is specified.
 * 
 * @author Igor Akkerman
 */
public class InvalidLinearIndexStorageCapacityException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -384887305140022756L;

    /** invalid capacity */
    private final int invalidCapacity;

    /** referenced {@link LinearIndexStorage} */
    private final LinearIndexStorage<?> linearIndexStorage;

    /**
     * Creates a new {@link InvalidLinearIndexStorageCapacityException}.
     * 
     * @param linearIndexStorage
     *        referenced {@link LinearIndexStorage}
     * 
     * @param invalidCapacity
     *        integer specifying the invalid capacity
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param messageArguments
     *        array of {@link Object} message arguments
     */
    public InvalidLinearIndexStorageCapacityException(final LinearIndexStorage<?> linearIndexStorage,
                                                      final int invalidCapacity, final String messagePattern,
                                                      final Object... messageArguments) {
        super(messagePattern, linearIndexStorage, invalidCapacity, messageArguments);

        this.linearIndexStorage = linearIndexStorage;
        this.invalidCapacity = invalidCapacity;
    }

    /**
     * Returns the invalid capacity.
     * 
     * @return integer specifying the invalid capacity
     */
    public int getInvalidCapacity() {
        return invalidCapacity;
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
