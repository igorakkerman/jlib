package org.jlib.container.sequence;

import org.jlib.container.RemoveObserver;

/**
 * {@link Sequence} allowing its head Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface HeadRemoveSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the first Item of this {@link HeadRemoveSequence}.
     */
    public void removeFirstItem();

    /**
     * Removes the first Item of this {@link HeadRemoveSequence}.
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     */
    public void removeFirstItem(@SuppressWarnings({ "unchecked", /* "varargs" */}) final RemoveObserver<Item, ? extends HeadRemoveSequence<Item>>... removeObservers);
}
