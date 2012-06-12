package org.jlib.container.sequence;

/**
 * {@link Sequence} allowing its tail Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveTailSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the last Item of this {@link RemoveTailSequence}.
     * 
     * @throws SoleItemNotRemoveableException
     *         if this {@link ObservedRemoveTailSequence} contains only one Item
     *         and may not be empty
     */
    public void removeLastItem()
    throws SoleItemNotRemoveableException;
}
