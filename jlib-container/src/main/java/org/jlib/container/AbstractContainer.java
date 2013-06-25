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

import org.jlib.core.iterator.IteratorUtility;
import org.jlib.core.system.AbstractCloneable;
import org.jlib.container.traverser.TraversibleIterator;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.jlib.container.traverser.TraversibleUtility.haveEqualItems;

/**
 * Skeletal implementation of a {@link Container}. A concrete Container
 * implementation needs only to extend this class and implement the
 * {@link Container#iterator()} method. Other methods may be overridden for
 * efficiency reasons.
 *
 * @param <Item>
 *        type of items held in the {@link Container}
 *
 * @author Igor Akkerman
 */
public abstract class AbstractContainer<Item>
extends AbstractCloneable
implements Container<Item> {

    /**
     * Creates a new empty Container.
     */
    protected AbstractContainer() {
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
    public boolean contains(final Container<? extends Item> items) {
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
     * Verifies whether this Container contains all of the Items returned by the
     * Traverser of the specified Iterable.
     *
     * @param items
     *        Iterable creating the Traverser returning the Items to verify
     *
     * @return {@code true} if this Container contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    private boolean contains(final Iterable<? extends Item> items) {
        for (final Item item : items)
            if (! contains(item))
                return false;
        return true;
    }

    @Override
    public Item[] toArray() {
        final int itemsCount = getItemsCount();
        @SuppressWarnings("unchecked")
        final Item[] targetArray = (Item[]) new Object[itemsCount];
        int index = 0;
        for (final Item item : this)
            targetArray[index++] = item;

        return targetArray;
    }

    @Override
    public List<Item> toList() {
        return appendContainedItemsToList(new ArrayList<Item>(getItemsCount()));
    }

    @Override
    public List<Item> toSequentialList() {
        return appendContainedItemsToList(new LinkedList<Item>());
    }

    /**
     * Appends the Items of this {@link Container} to the specified {@link List}
     * .
     *
     * @param <Lizt>
     *        type of the used {@link List}
     *
     * @param list
     *        {@link List} to which the Items are added
     *
     * @return filled {@link List} {@code list}
     */
    private <Lizt extends List<Item>> Lizt appendContainedItemsToList(final Lizt list) {
        for (final Item item : this)
            list.add(item);

        return list;
    }

    @Override
    public final boolean equals(final @Nullable Object otherObject) {
        if (otherObject == null || ! getClass().equals(otherObject.getClass()))
            return false;

        @SuppressWarnings("unchecked")
        final Container<Item> otherContainer = (Container<Item>) otherObject;

        return hasMatchingProperties(otherContainer) && containsEqualItems(otherContainer);
    }

    /**
     * Verifies whether additional properties of this {@link Container} match
     * those of the specified {@link Container} providing a prerequisite for
     * equality.
     *
     * @param otherContainer
     *        {@link Container} compared to this {@link Container}
     *
     * @return {@code true} if the additional properties are prerequisites for
     *         equality; {@code false} otherwise
     */
    protected boolean hasMatchingProperties(final Container<Item> otherContainer) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return getItemsCount() == 0;
    }

    @Override
    public boolean containsEqualItems(final Container<Item> otherContainer) {
        return getItemsCount() == otherContainer.getItemsCount() && //
               haveEqualItems(this, otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Collection<Item> collection) {
        return getItemsCount() == collection.size() && //
               IteratorUtility.provideEqualItems(this, collection);
    }

    @Override
    // TODO: use Apache Commons Lang
    public int hashCode() {
        int hashCode = 0;
        for (final Item item : this)
            hashCode += item.hashCode();
        hashCode *= getItemsCount();
        return hashCode;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AbstractContainer<Item> clone() {
        return (AbstractContainer<Item>) super.clone();
    }

    @Override
    public Iterator<Item> iterator() {
        return new TraversibleIterator<>(this);
    }
}
