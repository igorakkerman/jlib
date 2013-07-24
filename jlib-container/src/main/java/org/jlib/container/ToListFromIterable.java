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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.jlib.core.language.AbstractObject;

public class ToListFromIterable<Item>
extends AbstractObject
implements ToList<Item> {

    private static final int DEFAULT_EXPECTED_ITEMS_COUNT = 20;

    private final Iterable<Item> iterable;

    private final int expectedItemsCount;

    public ToListFromIterable(final Collection<Item> collection) {
        this(collection, collection.size());
    }

    public ToListFromIterable(final Iterable<Item> iterable) {
        this(iterable, DEFAULT_EXPECTED_ITEMS_COUNT);
    }

    public ToListFromIterable(final Iterable<Item> iterable, int expectedItemsCount) {
        super();

        this.iterable = iterable;
        this.expectedItemsCount = expectedItemsCount;
    }

    @Override
    public List<Item> toList() {
        return appendContainedItemsToList(new ArrayList<Item>(expectedItemsCount));
    }

    @Override
    public List<Item> toSequentialList() {
        return appendContainedItemsToList(new LinkedList<Item>());
    }

    /**
     * Appends the Items of this {@link TraversableContainer} to the specified {@link List}
     * .
     *
     * @param <Lizt>
     *        type of the used {@link List}
     *
     * @param list
     *        {@link List} to which the Items are added
     *
     * @return filled {@link List} {@code list}
     */
    protected <Lizt extends List<Item>> Lizt appendContainedItemsToList(final Lizt list) {
        for (final Item item : iterable)
            list.add(item);

        return list;
    }
}
