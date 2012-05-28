package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceException;

/**
 * {@link SequenceException} thrown when a requested Item is not found.
 * 
 * @author Igor Akkerman
 */
public class NoSuchSequenceItemException
extends SequenceException {

    /** serialVersionUID */
    private static final long serialVersionUID = -8162511917404174346L;

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
        super(sequence);
    }
}
