package org.jlib.core.valueholder;

/**
 * Holder of a Value that is accessible.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public interface AccessibleValueHolder<Value>
extends ValueHolder<Value> {

    /**
     * Returns the registered Value.
     * 
     * @return registered Value
     */
    @Override
    public Value getValue();
}
