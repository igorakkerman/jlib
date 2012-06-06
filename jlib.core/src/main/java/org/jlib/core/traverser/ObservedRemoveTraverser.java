package org.jlib.core.traverser;

import org.jlib.core.observer.ItemObserver;
import org.jlib.core.observer.ItemObserverException;

/**
 * {@link RemoveTraverser} allowing its remove operation to be attended by
 * {@link ItemObserver} instances.
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
     *        comma separated sequence of {@link ItemObserver} items
     * 
     * @throws NoItemToRemoveException
     *         if not called immediately after a call to {@link #getNextItem()}
     *         or an appropriate method
     * 
     * @throws IllegalTraversibleStateException
     *         if an error is caused by a delegate used to remove the Item
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    public void remove(@SuppressWarnings({ "unchecked", /* "varargs" */}) ItemObserver<Item>... observers)
    throws IllegalTraversibleStateException, ItemObserverException;
}
