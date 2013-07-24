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

final class DisabledGetItemsCount<Item>
implements GetItemsCount<Item> {

    /** sole {@link DisabledGetItemsCount} instance */
    private static final DisabledGetItemsCount<?> INSTANCE = new DisabledGetItemsCount<Object>();

    /**
     * Returns the sole {@link DisabledGetItemsCount} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link DisabledGetItemsCount} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledGetItemsCount<Item> getInstance() {
        return (DisabledGetItemsCount<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledGetItemsCount}.
     */
    private DisabledGetItemsCount() {
        super();
    }

    @Override
    public int getItemsCount()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}