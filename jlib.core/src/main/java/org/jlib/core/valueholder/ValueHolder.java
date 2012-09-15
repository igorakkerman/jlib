package org.jlib.core.valueholder;

import org.jlib.core.ValueNotAccessibleException;

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
     * Returns the registered Value.
     * 
     * @return registered Value
     * 
     * @throws ValueNotAccessibleException
     *         if no Value has been registered
     */
    public Value getValue()
    throws ValueNotAccessibleException;
}
