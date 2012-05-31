package org.jlib.container.sequence.index;

import java.text.MessageFormat;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceRuntimeException;

/**
 * {@link SequenceRuntimeException} thrown when a requested Item is not found.
 * 
 * @author Igor Akkerman
 */
public class NoSuchSequenceItemException
extends SequenceRuntimeException {

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
        super(sequence, MessageFormat.format("{1}: {2}", item, sequence));

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
