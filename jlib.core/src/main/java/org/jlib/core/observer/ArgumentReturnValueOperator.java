package org.jlib.core.observer;

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
     * @throws OperatorException
     *         if the operation cannot be completed normally and this should be
     *         handled consequently
     * 
     * @throws RuntimeException
     *         if the operation cannot be completed normally and this should
     *         <em>not</em> be handled consequently
     */
    public ReturnValue operate(final ArgumentValue argumentValue)
    throws OperatorException, RuntimeException;
}
