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

import org.jlib.core.language.AbstractObject;

public class Optional<Value>
extends AbstractObject
implements Modifiable<Value> {

    public static <Value> Optional<Value> from(final Value value) {
        return new Optional<>(value);
    }

    public static <Value> Optional<Value> fromNullable(@Nullable final Value value) {
        return value != null ?
               from(value) :
               new Optional<Value>();
    }

    private final Accessor<Value> UNINITIALIZED_VALUE_HOLDER = new Uninitialized<Value>() {

        @Override
        public void setValue(final Value value) {
            delegateAccessor = new InitializedModifiable<>(value);
        }
    };

    private Optional() {
        delegateAccessor = UNINITIALIZED_VALUE_HOLDER;
    }

    private Optional(final Value value) {
        delegateAccessor = new Initialized<>(value);
    }

    private Accessor<Value> delegateAccessor;

    @Override
    public void setValue(Value value) {
        delegateAccessor = new Initialized<>(value);
    }

    public void unsetValue() {
        delegateAccessor = UNINITIALIZED_VALUE_HOLDER;
    }

    @Override
    public boolean isValueAccessible() {
        return delegateAccessor.isValueAccessible();
    }

    @Override
    public Value getValue()
    throws ValueNotAccessibleException {
        return delegateAccessor.getValue();
    }

    @Override
    public String toString() {
        return delegateAccessor.toString();
    }
}
