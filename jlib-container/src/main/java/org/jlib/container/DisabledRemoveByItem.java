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

import org.jlib.core.traverser.InvalidTraversableArgumentException;

final class DisabledRemoveByItem<Item>
extends DisabledContainer<Item>
implements RemoveByItem<Item> {

    /** sole {@link DisabledRemoveByItem} instance */
    private static final RemoveByItem<?> INSTANCE = new DisabledRemoveByItem<>();

    /**
     * Returns the sole {@link DisabledRemoveByItem} instance.
     *
     * @return sole {@link DisabledRemoveByItem} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledRemoveByItem<Item> getInstance() {
        return (DisabledRemoveByItem<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledRemoveByItem}.
     */
    private DisabledRemoveByItem() {
        super();
    }

    @Override
    public void remove(final Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void remove(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void remove(final Item... items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}
