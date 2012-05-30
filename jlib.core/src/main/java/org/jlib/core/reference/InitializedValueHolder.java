package org.jlib.core.reference;

/**
 * {@link ValueHolder} actually holding a Value.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public class InitializedValueHolder<Value>
implements ValueHolder<Value> {

    /** registered Value */
    private Value value;

    /**
     * Creates a new {@link InitializedValueHolder}.
     * 
     * @param initialValue
     *        initial Value
     */
    public InitializedValueHolder(final Value initialValue) {
        super();

        value = initialValue;
    }

    @Override
    public Value get() {
        return value;
    }

    @Override
    public void set(final Value value) {
        this.value = value;
    }
}