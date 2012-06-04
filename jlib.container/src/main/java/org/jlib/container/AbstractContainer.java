/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.jlib.core.ObjectUtility;
import org.jlib.core.traverser.Traverser;
import org.jlib.core.traverser.TraversibleIterator;

/**
 * Skeletal implementation of a Container. A concrete Container implementation
 * needs only to extend this class and implement the
 * {@link Container#iterator()} method. Other methods may be overridden for
 * efficiency reasons.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * @author Igor Akkerman
 */
public abstract class AbstractContainer<Item>
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
    public boolean containsAll(final Container<? extends Item> items) {
        return containsAll((Iterable<? extends Item>) items);
    }

    @Override
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        for (final Item item : items)
            if (!contains(item))
                return false;
        return true;
    }

    @Override
    public boolean containsAll(final Collection<? extends Item> items) {
        return containsAll((Iterable<? extends Item>) items);
    }

    /**
     * Verifies whether this Container contains all of the Items returned by the
     * Traverser of the specified Iterable.
     * 
     * @param items
     *        Iterable creating the Traverser returning the Items to verify
     * @return {@code true} if this Container contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    private boolean containsAll(final Iterable<? extends Item> items) {
        for (final Item item : items)
            if (!contains(item))
                return false;
        return true;
    }

    @Override
    public Item[] toArray() {
        final int size = getSize();
        @SuppressWarnings("unchecked")
        final Item[] targetArray = (Item[]) new Object[size];
        int index = 0;
        for (final Item item : this)
            targetArray[index ++] = item;

        return targetArray;
    }

    @Override
    public Collection<Item> toCollection() {
        final Collection<Item> collection = new LinkedList<Item>();
        for (final Item item : this)
            collection.add(item);
        return collection;
    }

    /**
     * Verifies whether this Container is equal to the specified Object. The
     * implementation in this class defines the Objects equal if all of the
     * following conditions are satisfied:
     * <ul>
     * <lem>the specified {@link Object} is not {@code null}</lem>
     * <lem>this Object and the specified Object are instances of the same class</lem>
     * <lem>if the Traverser returned by the {@link #iterator()} method of this
     * Container and the specified Container (it is a Container by the previous
     * condition) return equal Items in the same order; two Items are said to be
     * equal if they are both {@code null} or the comparison using the
     * {@link Object#equals(Object) equals} method returns {@code true}</lem>
     * </ul>
     * 
     * @param otherObject
     *        Object to compare to this Container
     * @return {@code true} if all of the conditions stated above are satisfied;
     *         {@code false} otherwise
     */
    @Override
    // TODO: use Apache Commons Lang
    public boolean equals(final Object otherObject) {
        if (otherObject == null || !getClass().equals(otherObject.getClass()))
            return false;
        final Container<?> otherContainer = (Container<?>) otherObject;
        final Traverser<?> thisTraverser = createTraverser();
        final Traverser<?> otherTraverser = otherContainer.createTraverser();
        do {
            // TODO: use size() to verify that both Containers have the same number of items and rely on that fact
            final boolean thisHasNext = thisTraverser.isNextItemAccessible();
            if (thisHasNext != otherTraverser.isNextItemAccessible())
                return false;
            if (!thisHasNext)
                return true;
            if (!ObjectUtility.equal(thisTraverser.getNextItem(), otherTraverser.getNextItem()))
                return false;
        }
        while (true);
    }

    @Override
    // TODO: use Apache Commons Lang
    public int hashCode() {
        int hashCode = 0;
        for (final Item item : this)
            hashCode += item != null
                ? item.hashCode()
                : 0;
        return hashCode;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new TraversibleIterator<>(this);
    }
}
