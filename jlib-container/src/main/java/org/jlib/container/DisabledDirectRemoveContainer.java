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

final class DisabledDirectRemoveContainer<Item>
extends AbstractDisabledContainer<Item>
implements DirectRemoveContainer<Item> {

    /** sole {@link DisabledDirectRemoveContainer} instance */
    private static final DirectRemoveContainer<?> INSTANCE = new DisabledDirectRemoveContainer<>();

    /**
     * Returns the sole {@link DisabledDirectRemoveContainer} instance.
     *
     * @return sole {@link DisabledDirectRemoveContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DirectRemoveContainer<Item> getInstance() {
        return (DirectRemoveContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledDirectRemoveContainer}.
     */
    private DisabledDirectRemoveContainer() {
        super();
    }

    @Override
    public void remove(final Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void remove(final ReadContainer<? extends Item> items)
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
