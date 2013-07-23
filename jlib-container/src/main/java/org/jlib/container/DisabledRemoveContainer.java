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


final class DisabledRemoveContainer<Item>
extends AbstractDisabledContainer<Item>
implements RemoveContainer<Item> {

    /** sole {@link DisabledRemoveContainer} instance */
    private static final RemoveContainer<?> INSTANCE = new DisabledRemoveContainer<>();

    /**
     * Returns the sole {@link DisabledRemoveContainer} instance.
     *
     * @return sole {@link DisabledRemoveContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> RemoveContainer<Item> getInstance() {
        return (RemoveContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledRemoveContainer}.
     */
    private DisabledRemoveContainer() {
        super();
    }

    @Override
    public void retain(final Traversable<? extends Item> items)
    throws InvalidTraversableArgumentException, ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }

    @Override
    public void retain(final ReadContainer<? extends Item> items)
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
