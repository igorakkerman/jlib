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
     * Replaces the last traversed Item with the specified value.
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the replacement
     * 
     * @throws NoItemToReplaceException
     *         if not called immediately after traversing an Item
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void replace(final Item newItem, final ValueObserver<Item>... observers)
    throws NoItemToReplaceException, ValueObserverException;

    /**
     * Registers the specified {@link ValueObserver} for the replace operations
     * of this {@link ObservedReplaceTraverser}.
     * 
     * @param replaceObserver
     *        additional replace {@link ValueObserver}
     */
    public void addReplaceObserver(final ValueObserver<Item> replaceObserver);
}