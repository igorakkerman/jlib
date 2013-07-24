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

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

final class DisabledObservedRetainByTraversable<Item>
extends DisabledContainer<Item>
implements ObservedRetainByTraversable<Item> {

    /** sole {@link DisabledObservedRetainByTraversable} instance */
    private static final ObservedRetainByTraversable<?> INSTANCE = new DisabledObservedRetainByTraversable<>();

    /**
     * Returns the sole {@link DisabledObservedRetainByTraversable} instance.
     *
     * @return sole {@link DisabledObservedRetainByTraversable} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledObservedRetainByTraversable<Item> getInstance() {
        return (DisabledObservedRetainByTraversable<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledObservedRetainByTraversable}.
     */
    private DisabledObservedRetainByTraversable() {
        super();
    }

    @Override
    @SafeVarargs
    public final void retain(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }
}
