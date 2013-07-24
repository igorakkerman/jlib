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

final class DisabledContainsItemsByIterable<Item>
implements ContainsItemsByIterable<Item> {

    /** sole {@link DisabledContainsItemsByIterable} instance */
    private static final DisabledContainsItemsByIterable<?> INSTANCE = new DisabledContainsItemsByIterable<Object>();

    /**
     * Returns the sole {@link DisabledContainsItemsByIterable} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledContainsItemsByIterable} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledContainsItemsByIterable<Item> getInstance() {
        return (DisabledContainsItemsByIterable<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledContainsItemsByIterable}.
     */
    private DisabledContainsItemsByIterable() {
        super();
    }

    @Override
    public boolean containsItems(final Iterable<? extends Item> items)
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}
