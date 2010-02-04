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

package org.jlib.core.collections;

import java.util.Iterator;
import java.util.LinkedList;

import org.jlib.core.common.ObjectUtility;

/**
 * Skeletal implementation of a Collection. A concrete Collection implementation needs only to extend this class and
 * implement the {@link Collection#iterator()} method. Other methods may be overridden for efficiency reasons.
 * 
 * @param <Element>
 *        type of elements held in the Collection
 * @author Igor Akkerman
 */
public abstract class AbstractCollection<Element>
implements Collection<Element> {

    /**
     * Creates a new empty Collection.
     */
    protected AbstractCollection() {
        super();
    }

    // @see org.jlib.core.collections.Collection#contains(java.lang.Object)
    @Override
    public boolean contains(Object object) {
        for (Object collectionObject : this)
            if (collectionObject.equals(object))
                return true;
        return false;
    }

    // @see org.jlib.core.collections.Collection#containsAll(org.jlib.core.collections.Collection)
    @Override
    public boolean containsAll(Collection<?> otherCollection) {
        return containsAll((Iterable<?>) otherCollection);
    }

    // @see org.jlib.core.collections.Collection#containsAll(java.lang.Object[])
    @Override
    public boolean containsAll(Object... objects) {
        for (Object object : objects)
            if (!contains(object))
                return false;
        return true;
    }

    // @see org.jlib.core.collections.Collection#containsAll(org.jlib.core.collections.Collection)
    @Override
    public boolean containsAll(java.util.Collection<?> javaCollection) {
        return containsAll((Iterable<?>) javaCollection);
    }

    /**
     * Returns whether this Collection contains all of the Elements returned by the Iterator of the specified Iterable.
     * 
     * @param iterable
     *        Iterable creating the Iterator returning the Elements to verify
     * @return {@code true} if this Collection contains all of the Elements contained by {@code otherCollection};
     *         {@code false} otherwise
     */
    private boolean containsAll(Iterable<?> iterable) {
        for (Object object : iterable)
            if (!contains(object))
                return false;
        return true;
    }

    // @see org.jlib.core.collections.Collection#toArray()
    @Override
    public Element[] toArray() {
        int size = size();
        @SuppressWarnings("unchecked")
        Element[] array = (Element[]) new Object[size];
        int index = 0;
        for (Element element : this)
            array[index ++] = element;

        return array;
    }

    // @see org.jlib.core.collections.Collection#toJavaCollection()
    @Override
    public java.util.Collection<Element> toJavaCollection() {
        java.util.Collection<Element> javaCollection = new LinkedList<Element>();
        for (Element element : this)
            javaCollection.add(element);
        return javaCollection;
    }

    /**
     * Returns whether this Collection is equal to the specified Object. The implementation in this class defines the
     * Objects equal if all of the following conditions are satisfied:
     * <ul>
     * <li>the specified Object is not {@code null}</li>
     * <li>this Object and the specified Object are instances of the same class</li>
     * <li>if the Iterators returned by the {@code iterator} methods of this Collection and the specified Collection (it
     * is a Collection by the previous condition) return equal Elements in the same order; two Elements are said to be
     * equal if they are both {@code null} or the comparison using the {@link Object#equals(Object) equals} method
     * returns {@code true}</li>
     * </ul>
     * 
     * @param otherObject
     *        Object to compare to this Collection
     * @return {@code true} if all of the conditions stated above are satisfied; {@code false} otherwise
     */
    @Override
    // TODO: create reference to external implementation (Visitor?)
    public boolean equals(Object otherObject) {
        if (otherObject == null || !getClass().equals(otherObject.getClass()))
            return false;
        Collection<?> otherCollection = (Collection<?>) otherObject;
        Iterator<?> thisIterator = iterator();
        Iterator<?> otherIterator = otherCollection.iterator();
        do {
            boolean thisHasNext = thisIterator.hasNext();
            if (thisHasNext != otherIterator.hasNext())
                return false;
            if (!thisHasNext)
                return true;
            if (!ObjectUtility.equalOrNull(thisIterator.next(), otherIterator.next()))
                return false;
        }
        while (true);
    }

    // @see java.lang.Object#hashCode()
    @Override
    // TODO: create reference to external implementatin (Visitor?)
    public int hashCode() {
        int hashCode = 0;
        for (Element element : this)
            hashCode += element != null ? element.hashCode() : 0;
        return hashCode;
    }

    // @see org.jlib.core.collections.Collection#isEmpty()
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
