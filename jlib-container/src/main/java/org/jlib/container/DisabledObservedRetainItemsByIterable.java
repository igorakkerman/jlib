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

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

final class DisabledObservedRetainItemsByIterable<Item>

implements ObservedRetainItemsByIterable<Item> {

    /** sole {@link DisabledObservedRetainItemsByIterable} instance */
    private static final DisabledObservedRetainItemsByIterable<?> INSTANCE = new DisabledObservedRetainItemsByIterable<>();

    /**
     * Returns the sole {@link DisabledObservedRetainItemsByIterable} instance.
     *
     * @return sole {@link DisabledObservedRetainItemsByIterable} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledObservedRetainItemsByIterable<Item> getInstance() {
        return (DisabledObservedRetainItemsByIterable<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledObservedRetainItemsByIterable}.
     */
    private DisabledObservedRetainItemsByIterable() {
        super();
    }

    @Override
    @SafeVarargs
    public final void retainItems(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        throw new ForbiddenCastException(this);
    }
}
