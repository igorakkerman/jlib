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

import javax.annotation.Nullable;

import org.jlib.core.language.EqualsStrategy;

public class EqualItemsCount<Item>
implements EqualsStrategy<GetCount<Item>> {

    /** sole {@link EqualItemsCount} instance */
    private static final EqualItemsCount<?> INSTANCE = new EqualItemsCount<>();

    /**
     * Returns the sole {@link EqualItemsCount} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link EqualItemsCount} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> EqualItemsCount<Item> getInstance() {
        return (EqualItemsCount<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EqualItemsCount}.
     */
    private EqualItemsCount() {
        super();
    }

    @Override
    public boolean equals(final GetCount<Item> thisObject, @Nullable final Object otherObject) {
        return otherObject instanceof GetCount<?> && //
               thisObject.getCount() == ((GetCount<?>) otherObject).getCount();
    }
}
