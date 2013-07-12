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

package org.jlib.core.value;

import javax.annotation.Nullable;

import org.jlib.core.system.AbstractObject;

public class Optional<Value>
extends AbstractObject
implements Modifiable<Value> {

    public static <Value> Optional<Value> from(final Value value) {
        return new Optional<Value>(value);
    }

    public static <Value> Optional<Value> fromNullable(@Nullable final Value value) {
        return value != null ?
               from(value) :
               new Optional<Value>();
    }

    private final org.jlib.core.value.Value<Value> UNINITIALIZED_VALUE_HOLDER = new Uninitialized<Value>() {

        @Override
        public void setValue(final Value value) {
            delegateValue = new InitializedModifiable<>(value);
        }
    };

    private Optional() {
        this.delegateValue = UNINITIALIZED_VALUE_HOLDER;
    }

    private Optional(final Value value) {
        this.delegateValue = new Initialized<>(value);
    }

    private org.jlib.core.value.Value<Value> delegateValue;

    @Override
    public void setValue(Value value) {
        delegateValue = new Initialized<>(value);
    }

    public void unsetValue() {
        delegateValue = UNINITIALIZED_VALUE_HOLDER;
    }

    @Override
    public boolean isValueAccessible() {
        return delegateValue.isValueAccessible();
    }

    @Override
    public Value getValue()
    throws ValueNotAccessibleException {
        return delegateValue.getValue();
    }

    @Override
    public String toString() {
        return delegateValue.toString();
    }
}
