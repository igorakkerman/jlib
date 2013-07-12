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

import org.jlib.core.system.AbstractObject;

/**
 * Skeletal implementation of a not initialized {@link Modifiable}.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public abstract class Uninitialized<Value>
extends AbstractObject
implements Modifiable<Value> {

    /**
     * Creates a new {@link Uninitialized}.
     */
    protected Uninitialized() {
        super();
    }

    /**
     * Always throws a {@link ValueNotAccessibleException}.
     *
     * @return never
     *
     * @throws ValueNotSetException
     *         always
     */
    @Override
    public Value getValue()
    throws ValueNotSetException {
        throw new ValueNotSetException();
    }

    /**
     * {@inheritDoc}
     *
     * This implementation always returns {@code false}.
     *
     * @return {@code false}
     */
    @Override
    public final boolean isValueAccessible() {
        return false;
    }

    @Override
    public final String toString() {
        return "<unitialized>";
    }
}
