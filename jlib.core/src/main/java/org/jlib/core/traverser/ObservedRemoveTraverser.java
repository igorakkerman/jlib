package org.jlib.core.traverser;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

/**
 * {@link RemoveTraverser} allowing its remove operation to be attended by
 * {@link ValueObserver} instances.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveTraverser<Item>
extends RemoveTraverser<Item> {

    /**
     * Removes the last Item returned by this {@link ObservedRemoveTraverser}.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws NoItemToRemoveException
     *         if not called immediately after a call to {@link #getNextItem()}
     *         or an appropriate method
     * 
     * @throws IllegalTraversibleStateException
     *         if an error is caused by a delegate used to remove the Item
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    public void remove(@SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalTraversibleStateException, ValueObserverException;
}
