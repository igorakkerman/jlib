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

import org.jlib.core.language.exception.InvalidArgumentException;

/**
 * {@link Accessible} initialized by the constructor.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public class Initialized<Value>
implements Accessible<Value> {

    /** registered {@link Value} */
    private Value value;

    /**
     * Creates a new {@link Initialized}.
     *
     * @param initialValue
     *        initial {@link Value}
     *
     * @throws InvalidArgumentException
     *         if {@code initialValue} is invalid
     */
    public Initialized(final Value initialValue)
    throws InvalidArgumentException {

        value = initialValue;

        assertValid(value);
    }

    @Override
    public Value get() {
        return value;
    }

    /**
     * Registers the new {@link Value}.
     *
     * @param value
     *        new {@link Value}
     *
     * @throws InvalidArgumentException
     *         if {@code value} is invalid
     */
    protected void set(final Value value)
    throws InvalidArgumentException {
        assertValid(value);

        this.value = value;
    }

    @SuppressWarnings({ "EmptyMethod", "UnusedParameters" })
    protected void assertValid(final Value value) {
        // perform optional validation in subclasses
    }
}
