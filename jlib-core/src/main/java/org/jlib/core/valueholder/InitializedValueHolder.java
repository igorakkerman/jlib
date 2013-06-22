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

/**
 * {@link AccessibleValueHolder} initialized by the constructor.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public class InitializedValueHolder<Value>
extends AbstractAccessibleValueHolder<Value> {

    /** registered Value */
    private Value value;

    /**
     * Creates a new {@link InitializedValueHolder}.
     *
     * @param initialValue
     *        initial Value
     */
    public InitializedValueHolder(final Value initialValue) {
        super();

        value = initialValue;
    }

    @Override
    public Value getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     *
     * This implementation always returns {@code true}.
     *
     * @return {@code true}
     */
    @Override
    public boolean isValueAccessible() {
        return true;
    }

    /**
     * Registers the new Value.
     *
     * @param value
     *        new Value
     */
    protected void setValue(final Value value) {
        this.value = value;
    }
}
