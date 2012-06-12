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
public interface ObservedRemoveTailSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the last Item of this {@link RemoveHeadSequence}.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     */
    @SuppressWarnings("unchecked")
    public void removeLastItem(final ValueObserver<Item>... observers);
}
