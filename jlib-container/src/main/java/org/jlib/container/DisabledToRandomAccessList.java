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

final class DisabledToRandomAccessList<Item>

implements ToRandomAccessList<Item> {

    /** sole {@link DisabledToRandomAccessList} instance */
    private static final ToRandomAccessList<?> INSTANCE = new DisabledToRandomAccessList<>();

    /**
     * Returns the sole {@link DisabledTraversableOperation} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledTraversableOperation} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledToRandomAccessList<Item> getInstance() {
        return (DisabledToRandomAccessList<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledToRandomAccessList}.
     */
    private DisabledToRandomAccessList() {
        super();
    }

    @Override
    public List<Item> toRandomAccessList()
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
    public Iterator<Item> iterator() {
        throw new ForbiddenCastException(this);
    }
}
