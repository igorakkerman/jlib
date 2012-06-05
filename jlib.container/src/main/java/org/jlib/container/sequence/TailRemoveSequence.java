package org.jlib.container.sequence;

import org.jlib.container.RemoveObserver;

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

    /**
     * Removes the last Item of this {@link HeadRemoveSequence}.
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     */
    public void removeLastItem(@SuppressWarnings({ "unchecked", /* "varargs" */}) final RemoveObserver<Item, ? extends TailRemoveSequence<Item>>... removeObservers);
}
