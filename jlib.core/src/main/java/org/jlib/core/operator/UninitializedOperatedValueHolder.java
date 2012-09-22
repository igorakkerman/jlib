package org.jlib.core.operator;

import org.jlib.core.valueholder.UninitializedValueHolder;

/**
 * {@link UninitializedValueHolder} calling the
 * {@link OptionalValueOperator#operateUnset()} method from
 * {@link #operate(OptionalValueOperator)}.
 * 
 * @param <Value>
 *        type of the held value
 * 
 * @author Igor Akkerman
 */
abstract class UninitializedOperatedValueHolder<Value>
extends UninitializedValueHolder<Value>
implements OperatedValueHolder<Value> {

    /**
     * Creates a new
     * {@link UninitializedOperatedValueHolder} .
     */
    public UninitializedOperatedValueHolder() {
        super();
    }

    @Override
    public final void operate(final OptionalValueOperator<Value> operator) {
        operator.operateUnset();
    }
}