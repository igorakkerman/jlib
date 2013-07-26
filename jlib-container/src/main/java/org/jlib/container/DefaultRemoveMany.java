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

import org.jlib.core.language.VoidObject;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

import org.jlib.container.itemssupplier.ItemsSupplier;
import org.jlib.container.itemssupplier.ItemsSupplierVisitor;

import static org.jlib.core.language.VoidObject.VOID;

public class DefaultRemoveMany<Item>
implements RemoveMany<Item> {

    private final RemoveSingleByItem<Item> removeSingle;

    private final Iterable<Item> iterable;

    public <RemoveSingleIterable extends RemoveSingleByItem<Item> & Iterable<Item>> /*
        */ DefaultRemoveMany(final RemoveSingleIterable removeSingleIterable) {

        super();

        this.removeSingle = removeSingleIterable;
        this.iterable = removeSingleIterable;
    }

    @Override
    public void remove(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        items.accept(new ItemsSupplierVisitor<Item, VoidObject>() {

            private void removeContained(final ContainsSingle<Item> removedItems) {
                for (final Item containedItem : iterable)
                    if (removedItems.contains(containedItem))
                        removeSingle.remove(containedItem);
            }

            @Override
            public VoidObject visitPerferTraverse(final ItemsSupplier<Item> removedItems) {
                for (final Item item : removedItems)
                    removeSingle.remove(item);

                return VOID;
            }

            @Override
            public VoidObject visitPreferContainsSingle(final ItemsSupplier<Item> removedItems) {
                removeContained(removedItems);

                return VOID;
            }

            @Override
            public VoidObject visitPreferContainsMany(final ItemsSupplier<Item> removedItems) {
                removeContained(removedItems);

                return VOID;
            }
        });
    }
}
