package org.jlib.core.reference;

/**
 * Holder of a Value.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public interface ValueHolder<Value> {

    /**
     * Returns the registered index.
     * 
     * @return integer specifying the registered index
     * 
     * @throws NoValueSetException
     *         if no Value has been registered
     */
    Value get()
    throws NoValueSetException;

    /**
     * Registers the new Value.
     * 
     * @param newValue
     *        new Value
     */
    void set(final Value newValue);
}