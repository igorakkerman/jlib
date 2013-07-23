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
import org.jlib.core.traverser.InvalidTraversableStateException;

final class DisabledObservedRemoveAllContainer<Item>
extends AbstractDisabledContainer<Item>
implements ObservedRemoveAllContainer<Item> {

    /** sole {@link DisabledObservedRemoveAllContainer} instance */
    private static final ObservedRemoveAllContainer<?> INSTANCE = new DisabledObservedRemoveAllContainer<>();

    /**
     * Returns the sole {@link DisabledObservedRemoveAllContainer} instance.
     *
     * @return sole {@link DisabledObservedRemoveAllContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> ObservedRemoveAllContainer<Item> getInstance() {
        return (ObservedRemoveAllContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledObservedRemoveAllContainer}.
     */
    private DisabledObservedRemoveAllContainer() {
        super();
    }

    @Override
    @SafeVarargs
    public final void removeAll(final ValueObserver<Item>... observers)
    throws InvalidTraversableStateException {
        throw new ForbiddenCastException(this);
    }
}
