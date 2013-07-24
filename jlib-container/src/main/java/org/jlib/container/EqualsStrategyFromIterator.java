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

import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.jlib.core.iterator.IterableUtility;
import org.jlib.core.language.EqualsStrategy;
import org.jlib.core.traverser.Traverser;

public class EqualsStrategyFromIterator<Item>
implements EqualsStrategy<Item> {

    private final Iterable<Item> iterable;

    public EqualsStrategyFromIterator(final Iterable<Item> iterable) {
        super();

        this.iterable = iterable;
    }

    /**
     * Verifies whether the {@link Traverser} instances created by the {@link #createTraverser()} methods of this
     * {@link TraversableContainer} and the specified {@link TraversableContainer} traverse the same number of Items in the same order and
     * all traversed Items are equal. Two Items {@code item1} and {@code item2} are called equal if
     * {@code item1.equals(item2)}.
     *
     * @param otherContainer
     *        compared {@link TraversableContainer}
     *
     * @return {@code true} if this {@link TraversableContainer} and {@code otherContainer}contain equal Items;
     *         {@code false} otherwise
     */
    @Override
    public final boolean isEqual(final @Nullable Object otherObject) {
        if (otherObject == null || ! getClass().equals(otherObject.getClass()))
            return false;

        @SuppressWarnings("unchecked")
        final EqualsStrategyFromIterator<Item> otherContainer = (EqualsStrategyFromIterator<Item>) otherObject;

        return IterableUtility.provideEqualItems(otherContainer.iterable, iterable);
    }

    @Override
    public int getHashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        for (final Item item : iterable)
            hashCodeBuilder.append(item);

        return hashCodeBuilder.toHashCode();
    }
}
