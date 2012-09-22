package org.jlib.core.operator;

/**
 * Operator operating on an optional Value.
 * 
 * @param <Value>
 *        type of the value to operate on
 * 
 * @author Igor Akkerman
 */
public interface OptionalValueOperator<Value> {

    /**
     * Performs the operation on the specified Value.
     * 
     * @param value
     *        Value to operate on
     */
    public void operate(Value value);

    /**
     * Performs the operation if no Value is registered.
     */
    public void operateUnset();
}
