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

import org.checkerframework.checker.nullness.qual.Nullable;

import org.jlib.core.language.operation.Equals;

import static org.jlib.core.iterator.IterableUtility.provideEqualItems;

public final class IterativeEquals<Item>
implements Equals<Iterable<Item>> {

    /** sole {@link IterativeEquals} instance */
    private static final IterativeEquals<?> INSTANCE = new IterativeEquals<>();

    /**
     * Returns the sole {@link IterativeEquals} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link IterativeEquals} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> IterativeEquals<Item> getInstance() {
        return (IterativeEquals<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link IterativeEquals}.
     */
    private IterativeEquals() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean areEqual(final Iterable<Item> thisIterable, @Nullable final Object otherObject) {
        return otherObject instanceof Iterable<?> && //
               provideEqualItems(thisIterable, (Iterable<Item>) otherObject);
    }
}
