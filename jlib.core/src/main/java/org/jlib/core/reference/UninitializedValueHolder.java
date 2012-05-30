package org.jlib.core.reference;

/**
 * Skeletal implementation of a not initialized {@link ValueHolder}.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public abstract class UninitializedValueHolder<Value>
implements ValueHolder<Value> {

    @Override
    public Value get()
    throws NoValueSetException {
        throw new NoValueSetException();
    }
}
