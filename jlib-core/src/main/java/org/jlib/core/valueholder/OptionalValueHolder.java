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

package org.jlib.core.valueholder;

import org.jlib.core.exception.ValueNotAccessibleException;

public class OptionalValueHolder<Value>
implements ModifiableValueHolder<Value> {

    private ValueHolder<Value> delegateValueHolder;

    private final ValueHolder<Value> UNINITIALIZED_VALUE_HOLDER = new UninitializedValueHolder<Value>() {

        @Override
        public void setValue(final Value value) {
            delegateValueHolder = new InitializedModifiableValueHolder<>(value);
        }
    };

    @Override
    public void setValue(Value value) {
        delegateValueHolder = new InitializedValueHolder<>(value);
    }

    public void unsetValue() {
        delegateValueHolder = UNINITIALIZED_VALUE_HOLDER;
    }

    @Override
    public boolean isValueAccessible() {
        return delegateValueHolder.isValueAccessible();
    }

    @Override
    public Value getValue()
    throws ValueNotAccessibleException {
        return delegateValueHolder.getValue();
    }
}
