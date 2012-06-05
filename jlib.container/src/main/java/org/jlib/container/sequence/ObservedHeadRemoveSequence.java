package org.jlib.container.sequence;

import org.jlib.core.observer.ItemObserver;

/**
 * {@link Sequence} allowing its head Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedHeadRemoveSequence<Item>
extends HeadRemoveSequence<Item> {

    /**
     * Removes the first Item of this {@link HeadRemoveSequence}.
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the removal
     */
    // @formatter:off
    public void removeFirstItem(@SuppressWarnings({ "unchecked", /* "varargs" */}) 
                                final ItemObserver<Item>... observers);
    // @formatter:on
}
