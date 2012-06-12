package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;

/**
 * {@link IllegalSequenceStateException} thrown when an illegal delegate array
 * capacity is requested.
 * 
 * @author Igor Akkerman
 */
public class InvalidDelegateArrayCapacityException
extends IllegalSequenceArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6549974214028548807L;

    /** invalid capacity */
    private final int capacity;

    /**
     * Creates a new {@link InvalidDelegateArrayCapacityException}.
     * 
     * @param sequence
     *        targeted {@link ArraySequence}
     * 
     * @param capacity
     *        integer specifying the invalid capacity
     * 
     * @param messagePattern
     *        String specifying the error message pattern
     * 
     * @param messageArguments
     *        array of {@link Object} message arguments
     */
    public InvalidDelegateArrayCapacityException(final ArraySequence<?> sequence, final int capacity,
                                                 final String messagePattern, final Object... messageArguments) {
        super(sequence, messagePattern, capacity, messageArguments);

        this.capacity = capacity;
    }

    /**
     * Returns the invalid capacity.
     * 
     * @return integer specifying the invalid capacity
     */
    public int getCapacity() {
        return capacity;
    }
}
