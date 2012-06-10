package org.jlib.core.observer;

/**
 * Operator on one Value that can be observed using a {@link ValueObserver}.
 * 
 * @param <Value>
 *        type of the argument value
 * 
 * @author Igor Akkerman
 */
public interface ValueOperator<Value> {

    /**
     * Operates on the specified Value.
     * 
     * @param value
     *        Value for the operation
     * 
     * @throws ValueOperatorException
     *         if the operation cannot be completed normally and this should be
     *         handled consequently
     * 
     * @throws RuntimeException
     *         if the operation cannot be completed normally and this should
     *         <em>not</em> be handled consequently
     */
    public void operate(final Value value)
    throws ValueOperatorException, RuntimeException;
}
