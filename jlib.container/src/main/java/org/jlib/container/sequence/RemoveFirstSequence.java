package org.jlib.container.sequence;

/**
 * {@link Sequence} allowing its first Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link RemoveFirstSequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveFirstSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the first Item of this {@link RemoveFirstSequence}.
     * 
     * @throws IllegalSequenceStateException
     *         if some property of this {@link RemoveFirstSequence} forbids its
     *         first Item to be removed
     */
    public void removeFirstItem()
    throws IllegalSequenceStateException;
}
