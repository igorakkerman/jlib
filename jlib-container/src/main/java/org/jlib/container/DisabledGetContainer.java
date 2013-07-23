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

import java.util.Collection;
import java.util.List;

final class DisabledGetContainer<Item>
implements GetContainer<Item> {

    // FIXME: remove Traversable if it is only present to use the correct Exception

    /** sole {@link DisabledGetContainer} instance */
    private static final DisabledGetContainer<?> INSTANCE = new DisabledGetContainer<Object>();

    /**
     * Returns the sole {@link DisabledGetContainer} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledGetContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledGetContainer<Item> getInstance() {
        return (DisabledGetContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledGetContainer}.
     */
    private DisabledGetContainer() {
        super();
    }

    @Override
    public int getItemsCount()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean isEmpty()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean contains(final Item item)
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean contains(final GetContainer<? extends Item> items)
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final boolean contains(final Item... items)
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
    public boolean containsEqualItems(final GetContainer<Item> otherContainer) {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean containsEqualItems(final Collection<Item> collection) {
        throw new ForbiddenCastException(this);
    }
}
