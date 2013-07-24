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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.traverser.TraversableUtility;

public abstract class HashCodeFromIteratorOperation<Item>
extends AbstractObject
implements ItemOperation<Item>,
           org.jlib.core.traverser.Traversable<Item>,
           Iterable<Item> {

    public HashCodeFromIteratorOperation() {
        super();
    }

    @Override
    public final boolean equals(final @Nullable Object otherObject) {
        if (otherObject == null || ! getClass().equals(otherObject.getClass()))
            return false;

        @SuppressWarnings("unchecked")
        final TraversableContainer<Item> otherContainer = (TraversableContainer<Item>) otherObject;

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

    @Override
    public boolean hasMatchingProperties(final TraversableContainer<Item> otherContainer) {
        return new EqualsBuilder().append(otherContainer.getItemsCount(), getItemsCount()).isEquals();
    }

    @Override
    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
        return getItemsCount() == otherContainer.getItemsCount() && //
               TraversableUtility.provideEqualItems(this, otherContainer);
    }
}
