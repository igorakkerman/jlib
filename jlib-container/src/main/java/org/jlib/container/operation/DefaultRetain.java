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

import org.jlib.container.operation.containsadapter.IterativeContainsAdapter;

public class DefaultRetain<Item>
implements Retain<Item> {

    private final RemoveSingleByValue<Item> removableContainedItems;

    private final Iterable<Item> containedItems;

    public <RemoveIterable extends Iterable<Item> & RemoveSingleByValue<Item>> /*
        */ DefaultRetain(final RemoveIterable containedItems) {

        this.containedItems = containedItems;
        removableContainedItems = containedItems;
    }

    @Override
    @SuppressWarnings("TypeMayBeWeakened")
    public void retain(final IterativeContainsAdapter<Item> retainedItems)
    throws InvalidContainerArgumentException, InvalidContainerStateException {

        for (final Item containedItem : containedItems)
            if (! retainedItems.contains(containedItem))
                removableContainedItems.remove(containedItem);
    }
}
