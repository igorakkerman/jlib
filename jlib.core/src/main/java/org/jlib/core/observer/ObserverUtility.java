package org.jlib.core.observer;

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;

/**
 * 
 * 
 * @author Igor Akkerman
 */
public final class ObserverUtility {

    /** no visible constructor */
    private ObserverUtility() {}

    /**
     * Replaces an Item by the specified Item.
     * 
     * @param <Item>
     *        type of the replaced item
     * 
     * @param replaceable
     *        {@link Replaceable} containing the Item to replace
     * 
     * @param newItem
     *        new Item replacing the former Item
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the operation
     * 
     * @throws IllegalJlibArgumentException
     *         if {@code newItem} causes an error
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public <Item> void replace(final Replaceable<Item> replaceable, final Item newItem,
                               @SuppressWarnings({ "unchecked", /* "varargs" */}) final ItemObserver<Item>... observers) {
        try {
            for (final ItemObserver<Item> observer : observers)
                observer.handleBefore(newItem, replaceable);

            replaceable.replace(newItem);

            for (final ItemObserver<Item> observer : observers)
                observer.handleAfterSuccess(newItem, replaceable);
        }
        catch (IllegalJlibArgumentException | IllegalJlibStateException exception) {
            for (final ItemObserver<Item> observer : observers)
                observer.handleAfterFailure(newItem, replaceable);
        }
    }
}
