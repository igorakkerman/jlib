package org.jlib.container.sequence;

import org.jlib.core.observer.ItemObserver;

/**
 * {@link Sequence} allowing its tail Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedTailRemoveSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the last Item of this {@link HeadRemoveSequence}.
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the removal
     */
    // @formatter:off
    public void removeLastItem(@SuppressWarnings({ "unchecked", /* "varargs" */}) 
                               final ItemObserver<Item>... observers);
    // @formatter:on
}
