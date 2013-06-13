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
