package org.jlib.container.sequence;

/**
 * {@link Sequence} allowing its tail Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface TailRemoveSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the last Item of this {@link TailRemoveSequence}.
     */
    public void removeLastItem();
}
