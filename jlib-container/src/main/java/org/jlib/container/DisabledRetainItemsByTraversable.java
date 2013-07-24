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
import org.jlib.core.traverser.Traversable;


final class DisabledRetainItemsByTraversable<Item>
extends DisabledContainer<Item>
implements RetainItemsByTraversable<Item> {

    /** sole {@link DisabledRetainItemsByTraversable} instance */
    private static final RetainItemsByTraversable<?> INSTANCE = new DisabledRetainItemsByTraversable<>();

    /**
     * Returns the sole {@link DisabledRetainItemsByTraversable} instance.
     *
     * @return sole {@link DisabledRetainItemsByTraversable} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledRetainItemsByTraversable<Item> getInstance() {
        return (DisabledRetainItemsByTraversable<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledRetainItemsByTraversable}.
     */
    private DisabledRetainItemsByTraversable() {
        super();
    }

    @Override
    public void retainItems(final Traversable<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void retain(final ContainsItemsByArray<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void retain(final Item... items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}
