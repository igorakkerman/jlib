package org.jlib.core.observer;

/**
 * Observer of an operation on a Value.
 * 
 * @param <Value>
 *        type of removed value
 * 
 * @author Igor Akkerman
 */
public interface ValueObserver<Value> {

    /**
     * Performs actions before the targeted operation.
     * 
     * @param value
     *        Value removed from {@code container}
     * 
     * @param arguments
     *        optional comma separated sequence of arbitrary {@link Object}
     *        arguments
     * 
     * @throws BeforeHandlerValueObserverException
     *         if an error occurs performing the actions
     */
    public void handleBefore(final Value value, final Object... arguments)
    throws BeforeHandlerValueObserverException;

    /**
     * Performs actions after the targeted operation has been successfully
     * executed.
     * 
     * @param value
     *        Value removed from {@code container}
     * 
     * @param arguments
     *        optional comma separated sequence of arbitrary {@link Object}
     *        arguments
     * 
     * @throws AfterSuccessHandlerValueObserverException
     *         if an error occurs performing the actions
     */
    public void handleAfterSuccess(final Value value, final Object... arguments)
    throws AfterSuccessHandlerValueObserverException;

    /**
     * Performs actions before the targeted operation.
     * 
     * @param value
     *        Value removed from {@code container}
     * 
     * @param arguments
     *        optional comma separated sequence of arbitrary {@link Object}
     *        arguments
     * 
     * @throws AfterFailureHandlerValueObserverException
     *         if an error occurs performing the actions
     */
    public void handleAfterFailure(final Value value, final Object... arguments)
    throws AfterFailureHandlerValueObserverException;
}
