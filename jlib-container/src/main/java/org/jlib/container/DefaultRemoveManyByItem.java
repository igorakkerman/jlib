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

import org.jlib.core.traverser.Traversable;

import static org.jlib.core.traverser.TraversableUtility.traversable;

public class DefaultRemoveManyByItem<Item>
implements RemoveManyByItem<Item> {

    private final Traversable<Item> containedItems;

    private final RemoveSingleByItem<Item> removableContainedItems;

    public <RemoveSingleTraversable extends Traversable<Item> & RemoveSingleByItem<Item>> /*
        */ DefaultRemoveManyByItem(final RemoveSingleTraversable containedItems) {

        super();

        this.containedItems = containedItems;
        removableContainedItems = containedItems;
    }

    @Override
    public <ContainsTraversable extends Traversable<Item> & ContainsSingle<Item>> /*
        */ void remove(final ContainsTraversable removedItems)
    throws InvalidContainerArgumentException, InvalidContainerStateException {

        for (final Item containedItem : iterable(containedItems))
            if (removedItems.contains(containedItem))
                removableContainedItems.remove(containedItem);
    }
}
