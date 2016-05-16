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

package org.jlib.container.storage.capacity;

import org.jlib.container.storage.LinearIndexStorage;

/**
 * Strategy of the head or tail capacity provision in a {@link LinearIndexStorage}.
 *
 * @author Igor Akkerman
 */
public interface TailCapacityStrategy {

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified number of items at its tail. The
     * indices of the stored items are modified, if necessary.
     *
     * @param tailCapacity
     *        required tail capacity
     *
     * @throws InvalidCapacityException
     *         if {@code headOrTailCapacity < 0}
     */
    void ensureTailCapacity(int tailCapacity)
        throws InvalidCapacityException;
}
