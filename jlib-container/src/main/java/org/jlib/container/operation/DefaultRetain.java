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

import static org.jlib.core.iterator.TraversableUtility.iterable;

public class DefaultRetain<Item>
implements Retain<Item> {

    private final RemoveSingleByItem<Item> removableContainedItems;

    private final Iterable<Item> containedItems;

    public <RemoveTraversable extends Iterable<Item> & RemoveSingleByItem<Item>> /*
        */ DefaultRetain(final RemoveTraversable containedItems) {

        super();

        this.containedItems = containedItems;
        removableContainedItems = containedItems;
    }

    @Override
    @SuppressWarnings("TypeMayBeWeakened")
    public <ContainsTraversable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void retain(final ContainsTraversable retainedItems)
    throws InvalidContainerArgumentException, InvalidContainerStateException {

        for (final Item containedItem : iterable(containedItems))
            if (! retainedItems.contains(containedItem))
                removableContainedItems.remove(containedItem);
    }
}
