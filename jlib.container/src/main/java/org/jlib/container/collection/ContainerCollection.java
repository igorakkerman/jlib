/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.collection;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.Container;

/**
 * Adapter allowing a {@link Container} to be used as a {@link Collection}. A
 * {@link ContainerCollection} is backed by a {@link Container} specified at
 * initialization.
 * 
 * @param <Item>
 *        type of the items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public class ContainerCollection<Item>
extends AbstractCollection<Item> {

    /** adapted and backed {@link Container} */
    private final Container<Item> delegateContainer;

    /**
     * Creates a new {@link ContainerCollection} backed by the specified
     * {@link Container}.
     * 
     * @param delegateContainer
     *        {@link Container} backing this {@link ContainerCollection}
     */
    public ContainerCollection(final Container<Item> delegateContainer) {
        super();

        this.delegateContainer = delegateContainer;
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateContainer.iterator();
    }

    @Override
    public int size() {
        return delegateContainer.getItemsCount();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Object object) {
        // (pretty) safe cast thanks to type erasure
        return delegateContainer.contains((Item) object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsAll(final Collection<?> items) {
        // (pretty) safe cast thanks to type erasure
        return delegateContainer.contains((Collection<? extends Item>) items);
    }

    @Override
    public boolean isEmpty() {
        return delegateContainer.isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Item[] toArray() {
        return (Item[]) super.toArray();
    }

    /**
     * <p>
     * Verifies whether the specified {@link Object} is itself an
     * ContainerCollection and the Containers backed by this Container and the
     * specified {@link ContainerCollection}, respectively, are equal by their
     * {@code equals} methods.
     * </p>
     * 
     * @param otherObject
     *        Object to which the backed Container is compared
     * @return {@code true} if the backed Container is equal to
     *         {@code otherObject}; {@code false} otherwise
     */
    @Override
    public boolean equals(final Object otherObject) {
        return otherObject instanceof ContainerCollection<?> &&
               delegateContainer.equals(((ContainerCollection<?>) otherObject).delegateContainer);
    }

    @Override
    public int hashCode() {
        return delegateContainer.hashCode() << 1;
    }
}
