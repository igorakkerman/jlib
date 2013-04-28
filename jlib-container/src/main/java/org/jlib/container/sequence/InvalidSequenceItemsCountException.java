package org.jlib.container.sequence;

import org.jlib.core.IllegalJlibArgumentException;

/**
 * {@link IllegalJlibArgumentException} thrown when trying to create a
 * {@link Sequence} with an invalid number of Items.
 * 
 * @author Igor Akkerman
 */
public class InvalidSequenceItemsCountException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -23142560184875814L;

    /** invalid number of Items */
    private final int itemsCount;

    /**
     * Creates a new {@link InvalidSequenceItemsCountException}.
     * 
     * @param itemsCount
     *        integer specifying the invalid number of Items
     * 
     * @param messagePattern
     *        String specifying the error message pattern
     * 
     * @param messageArguments
     *        array of {@link Object} error message arguments
     */
    public InvalidSequenceItemsCountException(final int itemsCount, final String messagePattern,
                                              final Object... messageArguments) {
        super(messagePattern, messageArguments);

        this.itemsCount = itemsCount;
    }

    /**
     * Returns the invalid number of Items.
     * 
     * @return integer specifying the invalid number of Items
     */
    public int getItemsCount() {
        return itemsCount;
    }
}
