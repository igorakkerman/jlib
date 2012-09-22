package org.jlib.core.operator;

import org.jlib.core.valueholder.ValueHolder;

/**
 * {@link ValueHolder} operating on the held Value using an
 * {@link OptionalValueOperator}.
 * 
 * @param <Value>
 *        type of the held value
 * 
 * @author Igor Akkerman
 */
interface OperatedValueHolder<Value>
extends ValueHolder<Value> {

    /**
     * Operates on the held Value using the specified
     * {@link OptionalValueOperator}.
     * 
     * @param operator
     *        {@link OptionalValueOperator} operating on the held Value
     * 
     * @author Igor Akkerman
     */
    public void operate(final OptionalValueOperator<Value> operator);
}