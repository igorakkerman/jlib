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

/**
 * Accessor of a {@link Value}.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public interface Accessor<Value> {

    /**
     * Returns the accessed {@link Value}.
     *
     * @return accessed {@link Value}
     *
     * @throws NotAccessibleException
     *         if no {@link Value} can be accessed
     */
    Value get()
    throws NotAccessibleException;

    /**
     * Returns whether a {@link Value} can be accessed.
     *
     * @return {@code true} if a {@link Value} can be accessed;
     *         {@code false} otherwise
     */
    boolean canGet();
}
