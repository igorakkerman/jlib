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

public class DefaultRetain<Item>
implements Retain<Item> {

    private final RemoveSingleByItem<Item> removeSingle;

    private final Iterable<Item> iterable;

    public <RemoveIterable extends RemoveSingleByItem<Item> & Iterable<Item>> /*
        */ DefaultRetain(final RemoveIterable removeIterable) {

        super();

        this.removeSingle = removeIterable;
        this.iterable = removeIterable;
    }

    @Override
    public void retain(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        items.accept(new ItemsSupplierVisitor<Item, VoidObject>() {

            private VoidObject iterativeRemoveItems(final ItemsSupplier<Item> retainedItems) {
                for (final Item containedItem : iterable)
                    if (!retainedItems.contains(containedItem))
                        removeSingle.remove(containedItem);

                return VOID;
            }

            @Override
            public VoidObject visitPerferTraverse(final ItemsSupplier<Item> retainedItems) {

                nextRetainedItem:
                for (final Item containedItem : iterable) {
                    for (final Item retainedItem : iterable)
                        if (containedItem.equals(retainedItem))
                            continue nextRetainedItem;

                    removeSingle.remove(containedItem);
                }

                    return VOID;
            }

            @Override
            public VoidObject visitPreferContainsSingle(final ItemsSupplier<Item> retainedItems) {
                return iterativeRemoveItems(retainedItems);
            }

            @Override
            public VoidObject visitPreferContainsMany(final ItemsSupplier<Item> retainedItems) {
                return iterativeRemoveItems(retainedItems);
            }
        });
    }
}
