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

import org.jlib.object_spi.AbstractObject;

public final class CountIterableToArray<Item, DelegateContainer extends Count<Item> & Iterable<Item>>
extends AbstractObject
implements ToArray<Item> {

    private final DelegateContainer delegateIterable;

    public CountIterableToArray(final DelegateContainer delegateIterable) {

        this.delegateIterable = delegateIterable;
    }

    @Override
    public Item[] toArray() {

        @SuppressWarnings("unchecked")
        final Item[] targetArray = (Item[]) new Object[delegateIterable.count()];

        int index = 0;

        for (final Item item : delegateIterable)
            targetArray[index++] = item;

        return targetArray;
    }
}
