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

public class OptionalModifiable<Value>
extends AbstractObject
implements Modifiable<Value> {

    public static <Value> OptionalModifiable<Value> from(final Value value) {
        return new OptionalModifiable<>(value);
    }

    public static <Value> OptionalModifiable<Value> fromNullable(@Nullable final Value value) {
        return value != null ?
               from(value) :
               new OptionalModifiable<>();
    }

    private Accessor<Value> delegateAccessor;

    private final Accessor<Value> UNINITIALIZED = new Uninitialized<Value>() {

        @Override
        public void set(final Value value) {
            delegateAccessor = new InitializedModifiable<>(value);
        }
    };

    private OptionalModifiable() {
        delegateAccessor = UNINITIALIZED;
    }

    private OptionalModifiable(final Value value) {
        delegateAccessor = new Initialized<>(value);
    }

    @Override
    public void set(final Value value) {
        delegateAccessor = new Initialized<>(value);
    }

    public void unset() {
        delegateAccessor = UNINITIALIZED;
    }

    @Override
    public boolean canGet() {
        return delegateAccessor.canGet();
    }

    @Override
    public Value get()
    throws NotAccessibleException {
        return delegateAccessor.get();
    }

    @Override
    public String toString() {
        return delegateAccessor.toString();
    }
}
