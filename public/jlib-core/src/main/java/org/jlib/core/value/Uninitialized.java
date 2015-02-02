/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

/**
 * Skeletal implementation of a not initialized {@link Modifiable}.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public abstract class Uninitialized<Value>
implements Modifiable<Value> {

    /**
     * Creates a new {@link Uninitialized}.
     */
    protected Uninitialized() {
    }

    /**
     * Always throws a {@link NotAccessibleException}.
     *
     * @return never
     *
     * @throws NotInitializedException
     *         always
     */
    @Override
    public Value get()
    throws NotInitializedException {
        throw new NotInitializedException();
    }

    /**
     * {@inheritDoc}
     *
     * This implementation always returns {@code false}.
     *
     * @return {@code false}
     */
    @Override
    public final boolean canGet() {
        return false;
    }

    @Override
    public final String toString() {
        return "<unitialized>";
    }
}
