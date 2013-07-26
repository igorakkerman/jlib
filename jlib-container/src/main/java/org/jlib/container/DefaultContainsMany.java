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

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

import org.jlib.container.itemssupplier.ItemsSupplier;
import org.jlib.container.itemssupplier.ItemsSupplierVisitor;

public class DefaultContainsMany<Item>
implements ContainsMany<Item> {

    private final ContainsSingle<Item> containsSingle;

    public DefaultContainsMany(final ContainsSingle<Item> containsSingle) {
        super();

        this.containsSingle = containsSingle;
    }

    @Override
    public boolean contains(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return items.accept(new ItemsSupplierVisitor<Item, Boolean>() {

            // single working strategy in this case
            private boolean iterativeContains(final Iterable<Item> items) {
                for (final Item item : items)
                    if (! containsSingle.contains(item))
                        return false;

                return true;
            }

            @Override
            public Boolean visitPerferTraverse(final ItemsSupplier<Item> items) {
                return iterativeContains(items);
            }

            @Override
            public Boolean visitPreferContainsSingle(final ItemsSupplier<Item> items) {
                return iterativeContains(items);
            }

            @Override
            public Boolean visitPreferContainsMany(final ItemsSupplier<Item> items) {
                return iterativeContains(items);
            }
        });
    }
}
