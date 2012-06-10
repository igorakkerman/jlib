package org.jlib.core.valueholder;

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
     * @throws ValueNotAccessibleException
     *         if no Value has been registered
     */
    public Value get()
    throws ValueNotAccessibleException;
}
