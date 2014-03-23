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

public class DefaultContainsMany<Item>
implements ContainsMany<Item> {

    private final ContainsSingle<Item> containedItems;

    public DefaultContainsMany(final ContainsSingle<Item> containedItems) {

        this.containedItems = containedItems;
    }

    @Override
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ boolean contains(final ContainsIterable lookupItems)
    throws InvalidContainerArgumentException, InvalidContainerStateException {

        for (final Item lookupItem : lookupItems)
            if (! containedItems.contains(lookupItem))
                return false;

        return true;
    }
}
