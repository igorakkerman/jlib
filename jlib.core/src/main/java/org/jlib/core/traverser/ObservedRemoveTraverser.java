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
     * Removes the last traversed Item.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws NoItemToRemoveException
     *         if not called immediately after traversing an Item
     * 
     * @throws IllegalTraversibleStateException
     *         if an error is caused by a delegate used to remove the Item
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... observers)
    throws NoItemToRemoveException, IllegalTraversibleStateException, ValueObserverException, RuntimeException;

    /**
     * Registers the specified {@link ValueObserver} for the remove operations
     * of this {@link ObservedRemoveTraverser}.
     * 
     * @param removeObserver
     *        additional remove {@link ValueObserver}
     */
    public void addRemoveObserver(final ValueObserver<Item> removeObserver);
}
