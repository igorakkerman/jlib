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
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.TraversableIterable;

import org.jlib.container.ItemsSupplier.ContainsMany;
import org.jlib.container.ItemsSupplier.ContainsSingle;
import org.jlib.container.ItemsSupplier.ItemsSupplier;
import org.jlib.container.ItemsSupplier.ItemsSupplierVisitor;

public class DefaultContains<Item> implements Contains<Item> {

    /** sole {@link DefaultContains} instance */
    private static final DefaultContains<?> INSTANCE = new DefaultContains<>();

    /**
     * Returns the sole {@link DefaultContains} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DefaultContains} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DefaultContains<Item> getInstance() {
        return (DefaultContains<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DefaultContains}.
     */
    private DefaultContains() {
        super();
    }

    @Override
    public boolean contains(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return items.accept(new ItemsSupplierVisitor<Item, Boolean>() {
            @Override
            public Boolean visitItem(final Item item) {
                // FIXME: implement for this structure
                return null;
            }

            @Override
            public Boolean visitTraversable(final Traversable<? extends Item> items) {
                for (Item item : new TraversableIterable<>(items))
                    if (! visitItem(item))
                        return false;

                return true;
            }

            // FIXME: implement rest

            @Override
            public Boolean visitContainsSingle(final ContainsSingle<Item> items) {
                return null;
            }

            @Override
            public Boolean visitContainsMany(final ContainsMany<Item> items) {
                return null;
            }

            @Override
            public <ContainsSingleTraversable extends Traversable<Item> & ContainsSingle<Item>> Boolean visitContainsSingleTraversable(
                                                                                                                                      final ContainsSingleTraversable items) {
                return null;
            }

            @Override
            public <ContainsManyTraversable extends Traversable<Item> & ContainsMany<Item>> Boolean visitContainsManyTraversable(
                                                                                                                                final ContainsManyTraversable items) {
                return null;
            }
        });
    }
}
