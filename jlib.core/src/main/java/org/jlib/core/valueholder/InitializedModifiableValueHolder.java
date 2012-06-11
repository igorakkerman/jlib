package org.jlib.core.valueholder;

/**
 * {@link ModifiableValueHolder} actually holding a Value.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public class InitializedModifiableValueHolder<Value>
extends InitializedValueHolder<Value>
implements ModifiableValueHolder<Value> {

    /**
     * Creates a new {@link InitializedModifiableValueHolder}.
     * 
     * @param initialValue
     *        initial Value
     */
    public InitializedModifiableValueHolder(final Value initialValue) {
        super(initialValue);
    }

    @Override
    // raising visibility from protected to public
    public void set(final Value value) {
        super.set(value);
    }
}