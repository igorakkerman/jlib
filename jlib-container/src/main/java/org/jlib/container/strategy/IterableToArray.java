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

package org.jlib.container.strategy;

import org.jlib.core.language.AbstractObject;

import org.jlib.container.GetCount;
import org.jlib.container.ToArray;

public final class IterableToArray<Item, DelegateContainer extends GetCount<Item> & Iterable<Item>>
extends AbstractObject
implements ToArray<Item> {

    private final DelegateContainer delegateContainer;

    public IterableToArray(final DelegateContainer delegateContainer) {
        super();

        this.delegateContainer = delegateContainer;
    }

    @Override
    public Item[] toArray() {

        @SuppressWarnings("unchecked")
        final Item[] targetArray = (Item[]) new Object[delegateContainer.getCount()];

        int index = 0;

        for (final Item item : delegateContainer)
            targetArray[index++] = item;

        return targetArray;
    }
}
