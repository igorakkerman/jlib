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
public interface ObservedHeadRemoveSequence<Item>
extends HeadRemoveSequence<Item> {

    /**
     * Removes the first Item of this {@link HeadRemoveSequence}.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    public void removeFirstItem(@SuppressWarnings({ "unchecked", /* "varargs" */}) final ValueObserver<Item>... observers)
    throws ValueObserverException;
}
