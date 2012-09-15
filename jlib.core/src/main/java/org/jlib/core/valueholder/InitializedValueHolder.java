package org.jlib.core.valueholder;

/**
 * {@link AccessibleValueHolder} initialized by the constructor.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public class InitializedValueHolder<Value>
extends AbstractAccessibleValueHolder<Value> {

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
    public Value getValue() {
        return value;
    }

    /**
     * Registers the new Value.
     * 
     * @param value
     *        new Value
     */
    protected void setValue(final Value value) {
        this.value = value;
    }
}