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

import java.util.Iterator;
import java.util.List;

import org.jlib.core.traverser.Traverser;

final class DisabledJdkAwareContainer<Item>
extends AbstractDisabledContainer<Item>
implements JdkAwareContainer<Item> {

    /** sole {@link DisabledJdkAwareContainer} instance */
    private static final JdkAwareContainer<?> INSTANCE = new DisabledJdkAwareContainer<>();

    /**
     * Returns the sole {@link DisabledReadContainer} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledReadContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledJdkAwareContainer<Item> getInstance() {
        return (DisabledJdkAwareContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledJdkAwareContainer}.
     */
    private DisabledJdkAwareContainer() {
        super();
    }

    @Override
    public int getItemsCount()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public List<Item> toList()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public List<Item> toSequentialList()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public Item[] toArray()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean containsEqualItems(final Iterable<Item> collection) {
        throw new ForbiddenCastException(this);
    }

    @Override
    public Traverser<Item> createTraverser() {
        throw new ForbiddenCastException(this);
    }

    @Override
    public Iterator<Item> iterator() {
        throw new ForbiddenCastException(this);
    }
}
