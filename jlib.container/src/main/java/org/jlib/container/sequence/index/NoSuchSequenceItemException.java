package org.jlib.container.sequence.index;

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IllegalSequenceArgumentException} thrown when a requested Item is not
 * found.
 * 
 * @author Igor Akkerman
 */
public class NoSuchSequenceItemException
extends IllegalSequenceArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -8162511917404174346L;

    /** Item that could not be found */
    private final Object item;

    /**
     * Creates a new {@link NoSuchSequenceItemException}.
     * 
     * @param <Item>
     *        type of the item
     * 
     * @param sequence
     *        searched {@link Sequence}
     * 
     * @param item
     *        Item that could not be found
     */
    public <Item> NoSuchSequenceItemException(final Sequence<Item> sequence, final Item item) {
        super(sequence, "{1}: {2}", item);

        this.item = item;
    }

    /**
     * Returns the item of this {@link NoSuchSequenceItemException}.
     * 
     * @return {@link Object} specifying the item
     */
    public Object getItem() {
        return item;
    }
}
