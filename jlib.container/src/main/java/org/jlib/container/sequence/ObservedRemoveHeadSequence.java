package org.jlib.container.sequence;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

/**
 * {@link Sequence} allowing its Items to be traversed using a
 * {@link RemoveSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveHeadSequence<Item>
extends RemoveHeadSequence<Item> {

    /**
     * Removes the first Item of this {@link RemoveHeadSequence}.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void removeFirstItem(final ValueObserver<Item>... observers)
    throws ValueObserverException;
}
