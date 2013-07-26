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

package org.jlib.container.itemssupplier;

import java.util.Iterator;

import org.jlib.core.traverser.InvalidTraversableStateException;

import org.jlib.container.ContainsByIterable;
import org.jlib.container.ContainsSingle;

class ForwardingItemsSupplier<Item>
implements ItemsSupplier<Item> {

    private final Iterable<Item> delegateIterable;

    private final ContainsSingle<Item> delegateContainsSingle;

    private final ContainsByIterable<Item> delegateContainsByIterable;

    private final ItemsSupplierHost<Item> delegateItemItemsSupplierHost;

    ForwardingItemsSupplier(final Iterable<Item> delegateIterable, final ContainsSingle<Item> delegateContainsSingle,
                            final ContainsByIterable<Item> delegateContainsByIterable,
                            final ItemsSupplierHost<Item> delegateItemItemsSupplierHost) {

        this.delegateIterable = delegateIterable;
        this.delegateContainsSingle = delegateContainsSingle;
        this.delegateContainsByIterable = delegateContainsByIterable;
        this.delegateItemItemsSupplierHost = delegateItemItemsSupplierHost;
    }

    @Override
    public boolean contains(final Item item)
    throws InvalidTraversableStateException {
        return delegateContainsSingle.contains(item);
    }

    @Override
    public boolean contains(final Iterable<Item> iterable)
    throws InvalidTraversableStateException {
        return delegateContainsByIterable.contains(iterable);
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateIterable.iterator();
    }

    @Override
    public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
        return delegateItemItemsSupplierHost.accept(visitor);
    }
}
