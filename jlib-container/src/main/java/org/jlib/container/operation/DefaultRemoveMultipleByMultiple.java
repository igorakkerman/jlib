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

public class DefaultRemoveMultipleByMultiple<Item>
implements RemoveMultipleByValue<Item> {

    private final Iterable<Item> containedItems;

    private final RemoveSingleByValue<Item> removableContainedItems;

    public <RemoveSingleIterable extends Iterable<Item> & RemoveSingleByValue<Item>> /*
        */ DefaultRemoveMultipleByMultiple(final RemoveSingleIterable containedItems) {

        this.containedItems = containedItems;
        removableContainedItems = containedItems;
    }

    @Override
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(final ContainsIterable removedItems)
    throws InvalidContainerArgumentException, InvalidContainerStateException {

        for (final Item containedItem : containedItems)
            if (removedItems.contains(containedItem))
                removableContainedItems.remove(containedItem);
    }
}
