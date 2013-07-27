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
import org.jlib.core.language.EqualsHashCodeStrategy;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.TraversableUtility;
import org.jlib.core.traverser.Traverser;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.IteratorUtils;

public class ApacheCommonsEqualsHashCodeOverTraversable<Item>
extends EqualsHashCodeStrategy<Traversable<Item>> {

    private final Traversable<Item> items;

    public ApacheCommonsEqualsHashCodeOverTraversable() {
        super();
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
    public final boolean isEqual(final Traversable) {
        if (otherObject == null || ! getClass().equals(otherObject.getClass()))
            return false;

        return TraversableUtility.equals()
    }

    @Override
    public int getHashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        for (final Item item : iterable)
            hashCodeBuilder.append(item);

        return hashCodeBuilder.toHashCode();
    }

    @Override
    public boolean equals(final Traversable<Item> thisObject, @Nullable final Object otherObject) {
        return false;
    }

    @Override
    public int getHashCode(final Object thisObject) {
        return 0;
    }
}
