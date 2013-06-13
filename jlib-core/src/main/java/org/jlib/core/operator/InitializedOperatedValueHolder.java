/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

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
