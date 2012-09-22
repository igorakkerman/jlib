package org.jlib.core.operator;

import org.jlib.core.valueholder.InitializedValueHolder;

/**
 * {@link InitializedValueHolder} and {@link OperatedValueHolder}.
 * 
 * @param <Value>
 *        type of the value used by the {@link OptionalValueOperator}
 * 
 * @author Igor Akkerman
 */
class InitializedOperatedValueHolder<Value>
extends InitializedValueHolder<Value>
implements OperatedValueHolder<Value> {

    /**
     * Creates a new {@link InitializedOperatedValueHolder}.
     * 
     * @param initialValue
     *        initial Value
     */
    public InitializedOperatedValueHolder(final Value initialValue) {
        super(initialValue);
    }

    @Override
    public final void operate(final OptionalValueOperator<Value> operator) {
        operator.operate(getValue());
    }
}