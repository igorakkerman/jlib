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

package org.jlib.container;

import org.jlib.core.language.ItemOperationStrategy;

public interface ContainsMany<Item>
extends ItemOperationStrategy<Item> {

    /**
     * Verifies whether this {@link ReadContainer} containsItem the specified Object.
     *
     * @param item
     *        Item to verify
     *
     * @return {@code true} if this {@link ReadContainer} containsItem {@code object};
     *         {@code false} otherwise
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ boolean contains(ContainsIterable items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;
}
