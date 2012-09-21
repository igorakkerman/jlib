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

    /**
     * Creates a new {@link UninitializedValueHolder}.
     */
    public UninitializedValueHolder() {
        super();
    }

    @Override
    public Value getValue()
    throws ValueNotAccessibleException {
        throw new ValueNotAccessibleException();
    }
}
