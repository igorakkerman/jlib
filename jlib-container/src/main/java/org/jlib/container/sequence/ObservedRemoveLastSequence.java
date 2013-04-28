package org.jlib.container.sequence;

import org.jlib.core.observer.ValueObserver;

/**
 * {@link Sequence} allowing its tail Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveLastSequence<Item>
extends RemoveLastSequence<Item> {

    /**
     * Removes the last Item of this {@link RemoveFirstSequence}.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws SoleItemNotRemoveableException
     *         if this {@link ObservedRemoveLastSequence} contains only one Item
     *         and may not be empty
     */
    @SuppressWarnings("unchecked")
    public void removeLastItem(final ValueObserver<Item>... observers)
    throws SoleItemNotRemoveableException;
}
