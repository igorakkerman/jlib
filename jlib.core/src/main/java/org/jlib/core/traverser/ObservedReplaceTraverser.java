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
public interface ObservedReplaceTraverser<Item>
extends ReplaceTraverser<Item> {

    /**
     * Removes the last Item returned by this {@link RemoveTraverser} .
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @param removeObservers
     *        comma separated sequence of {@link ValueObserver} items
     * 
     * @throws NoItemToRemoveException
     *         if not called immediately after a call to {@link #getNextItem()}
     *         or an appropriate method
     * 
     * @throws IllegalTraversibleStateException
     *         if an error was caused by a delegate used to remove the item
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    public void replace(Item newItem,
                        @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... removeObservers)
    throws NoItemToRemoveException, IllegalTraversibleStateException, ValueObserverException;
}
