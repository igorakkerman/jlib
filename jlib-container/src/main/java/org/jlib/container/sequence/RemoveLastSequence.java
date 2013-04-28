package org.jlib.container.sequence;

/**
 * {@link Sequence} allowing its last Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link RemoveLastSequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveLastSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the last Item of this {@link RemoveLastSequence}.
     * 
     * @throws IllegalSequenceStateException
     *         if some property of this {@link RemoveLastSequence} forbids its
     *         last Item to be removed
     */
    public void removeLastItem()
    throws IllegalSequenceStateException;
}
