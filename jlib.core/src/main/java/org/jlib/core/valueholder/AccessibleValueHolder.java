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
     * @return integer specifying the registered index
     */
    @Override
    public Value getValue();
}
