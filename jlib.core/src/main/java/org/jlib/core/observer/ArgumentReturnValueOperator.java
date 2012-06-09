package org.jlib.core.observer;

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;

/**
 * Operator on one ArgumentValue.
 * 
 * @param <ArgumentValue>
 *        type of the argument value
 * 
 * @param <ReturnValue>
 *        type of the return value
 * 
 * @author Igor Akkerman
 */
public interface ArgumentReturnValueOperator<ArgumentValue, ReturnValue> {

    /**
     * Operates on the specified ArgumentValue.
     * 
     * @param argumentValue
     *        ArgumentValue for the operation
     * 
     * @return ReturnValue of the operation
     * 
     * @throws IllegalJlibArgumentException
     *         if {@code argumentValue} causes an error
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public ReturnValue operate(final ArgumentValue argumentValue)
    throws IllegalJlibArgumentException, IllegalJlibStateException;
}
