package org.jlib.container.sequence;

import org.jlib.core.observer.ItemObserver;
import org.jlib.core.observer.ItemObserverException;

/**
 * {@link Sequence} allowing its Items to be traversed using a
 * {@link RemoveSequenceTraverser}.
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
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    // @formatter:off
    public void removeFirstItem(@SuppressWarnings({ "unchecked", /* "varargs" */}) 
                                final ItemObserver<Item>... observers)
    throws ItemObserverException;
    // @formatter:on
}
