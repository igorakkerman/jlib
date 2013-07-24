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


final class DisabledRemove<Item>
extends DisabledContainer<Item>
implements Remove<Item> {

    /** sole {@link DisabledRemove} instance */
    private static final Remove<?> INSTANCE = new DisabledRemove<>();

    /**
     * Returns the sole {@link DisabledRemove} instance.
     *
     * @return sole {@link DisabledRemove} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledRemove<Item> getInstance() {
        return (DisabledRemove<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledRemove}.
     */
    private DisabledRemove() {
        super();
    }

    @Override
    public void retain(final Traversable<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void retain(final Contains<? extends Item> items)
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
