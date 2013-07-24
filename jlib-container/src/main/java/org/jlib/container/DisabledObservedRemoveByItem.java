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

final class DisabledObservedRemoveByItem<Item>
extends DisabledContainer<Item>
implements ObservedRemoveByItem<Item> {

    /** sole {@link DisabledObservedRemoveByItem} instance */
    private static final ObservedRemoveByItem<?> INSTANCE = new DisabledObservedRemoveByItem<>();

    /**
     * Returns the sole {@link DisabledObservedRemoveByItem} instance.
     *
     * @return sole {@link DisabledObservedRemoveByItem} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledObservedRemoveByItem<Item> getInstance() {
        return (DisabledObservedRemoveByItem<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledObservedRemoveByItem}.
     */
    private DisabledObservedRemoveByItem() {
        super();
    }

    @Override
    @SafeVarargs
    public final void remove(final Item item, final ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           ValueObserverException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void remove(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }

    @Override
    @SafeVarargs
    public final void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }
}
