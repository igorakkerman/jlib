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

package org.jlib.container.operation;

import org.jlib.core.language.ItemOperation;

/**
 * {@link IterableContainer} allowing Items to be removed.
 *
 * @param <Item>
 *        type of items held in the {@link IterableContainer}
 *
 * @author Igor Akkerman
 */
public interface RemoveManyByItem<Item>
extends ItemOperation<Item> {

    /**
     * Removes all Items from this object for which the specified {@link ContainsSingle}'s
     * {@link ContainsSingle#containsItem(Object)} method returns {@code true}.
     *
     * @param items
     *        {@link IterableContainer} containing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public <ContainsIterable extends org.jlib.core.iterator.Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(ContainsIterable items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;
}
