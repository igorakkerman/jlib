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

/**
 * Skeletal implementation of a Container. A concrete Container implementation
 * needs only to extend this class and implement the
 * {@link Container#iterator()} method. Other methods may be overridden for
 * efficiency reasons.
 * 
 * @param <Element>
 *        type of elements held in the {@link Container}
 * @author Igor Akkerman
 */
public abstract class AbstractContainer<Element>
implements Container<Element> {

    /**
     * Creates a new empty Container.
     */
    protected AbstractContainer() {
        super();
    }

    @Override
    public boolean contains(final Element element) {
        for (final Object containedElement : this)
            if (containedElement.equals(element))
                return true;
        return false;
    }

    @Override
    public boolean containsAll(final Container<? extends Element> elements) {
        return containsAll((Iterable<? extends Element>) elements);
    }

    @Override
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        for (Element element : elements)
            if (! contains(element))
                return false;
        return true;
    }

    @Override
    public boolean containsAll(final Collection<? extends Element> elements) {
        return containsAll((Iterable<? extends Element>) elements);
    }

    /**
     * Verifies whether this Container contains all of the Elements returned by
     * the Iterator of the specified Iterable.
     * 
     * @param elements
     *        Iterable creating the Iterator returning the Elements to verify
     * @return {@code true} if this Container contains all of the Elements
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    private boolean containsAll(final Iterable<? extends Element> elements) {
        for (Element element : elements)
            if (! contains(element))
                return false;
        return true;
    }

    @Override
    public Element[] toArray() {
        int size = getSize();
        @SuppressWarnings("unchecked")
        final Element[] targetArray = (Element[]) new Object[size];
        int index = 0;
        for (Element element : this)
            targetArray[index ++] = element;

        return targetArray;
    }

    @Override
    public Collection<Element> toCollection() {
        Collection<Element> collection = new LinkedList<Element>();
        for (Element element : this)
            collection.add(element);
        return collection;
    }

    /**
     * Verifies whether this Container is equal to the specified Object. The
     * implementation in this class defines the Objects equal if all of the
     * following conditions are satisfied:
     * <ul>
     * <li>the specified {@link Object} is not {@code null}</li>
     * <li>this Object and the specified Object are instances of the same class</li>
     * <li>if the Iterator returned by the {@link #iterator()} method of this
     * Container and the specified Container (it is a Container by the previous
     * condition) return equal Elements in the same order; two Elements are said
     * to be equal if they are both {@code null} or the comparison using the
     * {@link Object#equals(Object) equals} method returns {@code true}</li>
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
        if (otherObject == null || ! getClass().equals(otherObject.getClass()))
            return false;
        final Container<?> otherContainer = (Container<?>) otherObject;
        final Iterator<?> thisIterator =  iterator();
        final Iterator<?> otherIterator = otherContainer.iterator();
        do {
            // TODO: use size() to verify that both Containers have the same number of elements and rely on that fact
            boolean thisHasNext = thisIterator.hasNext();
            if (thisHasNext != otherIterator.hasNext())
                return false;
            if (! thisHasNext)
                return true;
            if (! ObjectUtility.equal(thisIterator.next(), otherIterator.next()))
                return false;
        }
        while (true);
    }

    @Override
    // TODO: use Apache Commons Lang
    public int hashCode() {
        int hashCode = 0;
        for (Element element : this)
            hashCode += element != null ? element.hashCode() : 0;
        return hashCode;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    @Override
    public final Iterator<Element> iterator() {
        return createIterator();
    }
}
