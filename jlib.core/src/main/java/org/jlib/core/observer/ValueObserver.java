package org.jlib.core.observer;

import org.jlib.core.operator.OperatorException;

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
     *        Value operated on
     * 
     * @throws RuntimeException
     *         if the operation cannot be completed normally
     */
    public void handleBefore(Value value)
    throws RuntimeException;

    /**
     * Performs actions after the targeted operation has been successfully
     * executed.
     * 
     * @param value
     *        Value operated on
     * 
     * @throws RuntimeException
     *         if the operation cannot be completed normally
     */
    public void handleAfterSuccess(Value value)
    throws RuntimeException;

    /**
     * Performs actions before the targeted operation.
     * 
     * @param value
     *        Value operated on
     * 
     * @param operatorException
     *        {@link OperatorException} that caused the operation to fail
     * 
     * @throws RuntimeException
     *         if the operation cannot be completed normally
     */
    public void handleAfterFailure(Value value, OperatorException operatorException)
    throws RuntimeException;
}
