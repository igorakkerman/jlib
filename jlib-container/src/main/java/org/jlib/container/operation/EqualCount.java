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

package org.jlib.container.operation;

import javax.annotation.Nullable;

import org.jlib.core.language.Equals;

public class EqualCount<Item>
implements Equals<GetCount<Item>> {

    /** sole {@link EqualCount} instance */
    private static final EqualCount<?> INSTANCE = new EqualCount<>();

    /**
     * Returns the sole {@link EqualCount} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link EqualCount} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> EqualCount<Item> getInstance() {
        return (EqualCount<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EqualCount}.
     */
    private EqualCount() {
        super();
    }

    @Override
    public boolean areEqual(final GetCount<Item> thisObject, @Nullable final Object otherObject) {
        return otherObject instanceof GetCount<?> && //
               thisObject.getCount() == ((GetCount<?>) otherObject).getCount();
    }
}
