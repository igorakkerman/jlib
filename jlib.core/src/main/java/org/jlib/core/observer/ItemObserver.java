package org.jlib.core.observer;

/**
 * Observer of an operation on an Item.
 * 
 * @param <Item>
 *        type of removed item
 * 
 * @author Igor Akkerman
 */
public interface ItemObserver<Item> {

    /**
     * Performs actions before the targeted operation.
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @param arguments
     *        optional comma separated sequence of arbitrary {@link Object}
     *        arguments
     * 
     * @throws ItemObserverException
     *         if an error occurs performing the actions
     */
    public void handleBefore(final Item item, final Object... arguments)
    throws ItemObserverException;

    /**
     * Performs actions after the targeted operation has been successfully
     * executed.
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @param arguments
     *        optional comma separated sequence of arbitrary {@link Object}
     *        arguments
     * 
     * @throws ItemObserverException
     *         if an error occurs performing the actions
     */
    public void handleAfterSuccess(final Item item, final Object... arguments)
    throws ItemObserverException;

    /**
     * Performs actions before the targeted operation.
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @param arguments
     *        optional comma separated sequence of arbitrary {@link Object}
     *        arguments
     * 
     * @throws ItemObserverException
     *         if an error occurs performing the actions
     */
    public void handleAfterFailure(final Item item, final Object... arguments)
    throws ItemObserverException;
}
