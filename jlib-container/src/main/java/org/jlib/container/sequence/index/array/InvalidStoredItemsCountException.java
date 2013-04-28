package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IllegalSequenceStateException} thrown when attempting to store an
 * invalid number of Items in a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public class InvalidStoredItemsCountException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5400803962181030353L;

    /** invalid number of Items */
    private final int invalidItemsCount;

    /**
     * Creates a new {@link InvalidStoredItemsCountException}.
     * 
     * @param sequence
     *        targeted {@link Sequence}
     * 
     * @param invalidItemsCount
     *        integer specifying the invalid number of Items
     * 
     * @param errorMessagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param errorMessageArguments
     *        comma separated sequence of Object error message arguments
     */
    public InvalidStoredItemsCountException(final Sequence<?> sequence, final int invalidItemsCount,
                                            final String errorMessagePattern, final Object... errorMessageArguments) {
        super(sequence, errorMessagePattern, invalidItemsCount, errorMessageArguments);

        this.invalidItemsCount = invalidItemsCount;
    }

    /**
     * Returns the invalid number of Items.
     * 
     * @return integer specifying the invalid number of Items
     */
    public int getInvalidItemsCount() {
        return invalidItemsCount;
    }
}
