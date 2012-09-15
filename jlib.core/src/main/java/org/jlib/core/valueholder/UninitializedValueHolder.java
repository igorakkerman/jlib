package org.jlib.core.valueholder;

import org.jlib.core.ValueNotAccessibleException;

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
    public Value getValue()
    throws ValueNotAccessibleException {
        throw new ValueNotAccessibleException();
    }
}
