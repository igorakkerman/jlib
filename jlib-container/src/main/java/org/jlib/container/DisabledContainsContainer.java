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

final class DisabledContainsContainer<Item>
extends AbstractDisabledContainer<Item>
implements ContainsContainer<Item> {

    /** sole {@link DisabledContainsContainer} instance */
    private static final DisabledContainsContainer<?> INSTANCE = new DisabledContainsContainer<Object>();

    /**
     * Returns the sole {@link DisabledContainsContainer} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledContainsContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledContainsContainer<Item> getInstance() {
        return (DisabledContainsContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledContainsContainer}.
     */
    private DisabledContainsContainer() {
        super();
    }

    @Override
    public boolean contains(final Item item)
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public boolean contains(final TraversableContainer<? extends Item> items)
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
}
