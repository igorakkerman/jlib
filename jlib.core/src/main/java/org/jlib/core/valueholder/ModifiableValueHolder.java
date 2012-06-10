package org.jlib.core.valueholder;

/**
 * Modifiable {@link ValueHolder}.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public interface ModifiableValueHolder<Value>
extends ValueHolder<Value> {

    /**
     * Registers the new Value.
     * 
     * @param newValue
     *        new Value
     */
    public void set(final Value newValue);
}
