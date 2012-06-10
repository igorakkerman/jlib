package org.jlib.core.valueholder;

/**
 * Skeletal implementation of a not initialized {@link ModifiableValueHolder}.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public abstract class UninitializedValueHolder<Value>
implements ModifiableValueHolder<Value> {

    @Override
    public Value get()
    throws ValueNotAccessibleException {
        throw new ValueNotAccessibleException();
    }
}
