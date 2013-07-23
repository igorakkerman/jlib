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

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.traverser.TraversableUtility;

public abstract class AbstractReadContainer<Item>
extends AbstractObject
implements ReadContainer<Item> {

    public AbstractReadContainer() {
        super();
    }

    @Override
    public boolean contains(final Item item) {
        for (final Object containedItem : this)
            if (containedItem.equals(item))
                return true;

        return false;
    }

    @Override
    public boolean contains(final ReadContainer<? extends Item> items) {
        return contains((Iterable<? extends Item>) items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items) {
        for (final Item item : items)
            if (! contains(item))
                return false;

        return true;
    }

    @Override
    public boolean contains(final Collection<? extends Item> items) {
        return contains((Iterable<? extends Item>) items);
    }

    /**
     * Verifies whether this ReadContainer contains all of the Items returned by the
     * Traverser of the specified Iterable.
     *
     * @param items
     *        Iterable creating the Traverser returning the Items to verify
     *
     * @return {@code true} if this ReadContainer contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    private boolean contains(final Iterable<? extends Item> items) {
        for (final Item item : items)
            if (! contains(item))
                return false;

        return true;
    }


    @Override
    public final boolean equals(final @Nullable Object otherObject) {
        if (otherObject == null || ! getClass().equals(otherObject.getClass()))
            return false;

        @SuppressWarnings("unchecked")
        final ReadContainer<Item> otherContainer = (ReadContainer<Item>) otherObject;

        return hasMatchingProperties(otherContainer) && containsEqualItems(otherContainer);
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        for (final Item item : this)
            hashCodeBuilder.append(item);

        return hashCodeBuilder.toHashCode();
    }

    @Override
    public boolean isEmpty() {
        return getItemsCount() == 0;
    }

    /**
     * <p>
     * Verifies whether additional properties of this {@link ReadContainer} match those of the specified
     * {@link ReadContainer} providing a prerequisite for equality.
     * </p>
     * <p>
     * The implementation in {@link AbstractReadContainer} verifies the number of contained {@link Item}s, as provided
     * by {@link #getItemsCount()}.
     * </p>
     *
     * @param otherContainer
     *        {@link ReadContainer} compared to this {@link ReadContainer}
     *
     * @return {@code true} if the additional properties are prerequisites for equality; {@code false} otherwise
     */
    protected boolean hasMatchingProperties(final ReadContainer<Item> otherContainer) {
        return new EqualsBuilder().append(otherContainer.getItemsCount(), getItemsCount()).isEquals();
    }

    @Override
    public boolean containsEqualItems(final ReadContainer<Item> otherContainer) {
        return getItemsCount() == otherContainer.getItemsCount() && //
               TraversableUtility.provideEqualItems(this, otherContainer);
    }
}
