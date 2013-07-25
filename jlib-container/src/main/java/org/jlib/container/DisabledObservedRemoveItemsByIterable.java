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

final class DisabledObservedRemoveItemsByIterable<Item>
implements ObservedRemoveItemsByIterable<Item> {

    /** sole {@link DisabledObservedRemoveItemsByIterable} instance */
    private static final DisabledObservedRemoveItemsByIterable<?> INSTANCE = new DisabledObservedRemoveItemsByIterable<>();

    /**
     * Returns the sole {@link DisabledObservedRemoveItemsByIterable} instance.
     *
     * @return sole {@link DisabledObservedRemoveItemsByIterable} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledObservedRemoveItemsByIterable<Item> getInstance() {
        return (DisabledObservedRemoveItemsByIterable<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledObservedRemoveItemsByIterable}.
     */
    private DisabledObservedRemoveItemsByIterable() {
        super();
    }

    @Override
    @SafeVarargs
    public final void removeItems(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}
