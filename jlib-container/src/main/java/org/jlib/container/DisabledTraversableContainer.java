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

import org.jlib.core.traverser.Traverser;

final class DisabledTraversableContainer<Item>
extends AbstractDisabledContainer<Item>
implements TraversableContainer<Item> {

    /** sole {@link DisabledTraversableContainer} instance */
    private static final TraversableContainer<?> INSTANCE = new DisabledTraversableContainer<Object>();

    /**
     * Returns the sole {@link DisabledTraversableContainer} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledTraversableContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledTraversableContainer<Item> getInstance() {
        return (DisabledTraversableContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledTraversableContainer}.
     */
    private DisabledTraversableContainer() {
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
    public boolean hasMatchingProperties(final TraversableContainer<Item> otherContainer) {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
        throw new ForbiddenCastException(this);
    }

    @Override
    public Iterator<Item> iterator() {
        throw new ForbiddenCastException(this);
    }

    @Override
    public Traverser<Item> createTraverser() {
        throw new ForbiddenCastException(this);
    }
}
