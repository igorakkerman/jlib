/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * File:    CollectionAdapter.java
 * Project: jlib.core
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.collections;

import java.util.Iterator;

import org.jlib.core.collections.list.EditableList;

/**
 * <p>
 * Adapter allowing an immutable jlib Collection to be used as an immutable Java
 * Collection. This Collection is backed by the jlib Collection.
 * </p>
 * <p>
 * Having a Java Collection backing an immutable jlib Collection makes sense for
 * a Collection like an {@link EditableList}, where the contained Elements may
 * change even though no Element can be added to the List or removed from it.
 * </p>
 * 
 * @param <Element>
 *        type of the elements held in the Collection
 * @author Igor Akkerman
 */
public class ImmutableJavaCollection<Element>
extends java.util.AbstractCollection<Element>
implements Collection<Element>, java.util.Collection<Element> {

    /** adapted and backed jlib Collection */
    private final Collection<Element> backedCollection;

    /**
     * Creates a new ImmutableJavaCollection backing the specified jlib
     * Collection.
     * 
     * @param backedCollection
     *        jlib Collection to adapt
     * @throws NullPointerException
     *         if {@code backedCollection == null}
     */
    public ImmutableJavaCollection(Collection<Element> backedCollection)
    throws NullPointerException {
        super();
        if (backedCollection == null)
            throw new NullPointerException();
        this.backedCollection = backedCollection;
    }

    // @see java.util.AbstractCollection#iterator()
    @Override
    public Iterator<Element> iterator() {
        return backedCollection.iterator();
    }

    // @see java.util.AbstractCollection#size()
    @Override
    public int size() {
        return backedCollection.size();
    }

    // @see java.util.AbstractCollection#contains(java.lang.Object)
    public boolean contains(Object object) {
        return backedCollection.contains(object);
    }

    // @see org.jlib.core.collections.Collection#containsAll(org.jlib.core.collections.Collection)
    @Override
    public boolean containsAll(Collection<?> otherCollection) {
        return backedCollection.containsAll(otherCollection);
    }

    // @see org.jlib.core.collections.Collection#containsAll(java.lang.Object[])
    @Override
    public boolean containsAll(Object... objects) {
        return backedCollection.containsAll(objects);
    }

    // @see java.util.AbstractCollection#containsAll(java.util.Collection)
    public boolean containsAll(java.util.Collection<?> javaCollection) {
        return backedCollection.containsAll(javaCollection);
    }

    // @see java.util.AbstractCollection#isEmpty()
    public boolean isEmpty() {
        return backedCollection.isEmpty();
    }

    // @see java.util.AbstractCollection#toArray()
    @SuppressWarnings("unchecked")
    public Element[] toArray() {
        return (Element[]) super.toArray();
    }

    /**
     * <p>
     * Returns whether this Collection is equal to the specified Object. The
     * specification of this method in this class does not extend the general
     * contract for Object equality defined by the {@link Object#equals} method.
     * </p>
     * <p>
     * However, the implementation in this class defines the Objects equal if
     * all of the following conditions are satisfied:
     * </p>
     * <ul>
     * <li>the specified Object is itself an ImmutableJavaCollection and the
     * jlib Collections backed by this Collection and the specified Collection,
     * respectively, are equal by their {@code equals} methods.</li>
     * <li>the specified Object is not an ImmutableJavaCollection and the jlib
     * Collection backed by this Collection is equal to the specified Object by
     * its {@code equals} method</li>
     * </ul>
     * 
     * @param otherObject
     *        Object to which the backed jlib Collection is compared
     * @return {@code true} if the backed jlib Collection is equal to
     *         {@code otherObject}; {@code false} otherwise
     */
    public boolean equals(Object otherObject) {
        if (otherObject instanceof ImmutableJavaCollection)
            return backedCollection.equals(((ImmutableJavaCollection<?>) otherObject).backedCollection);

        return backedCollection.equals(otherObject);
    }

    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return backedCollection.hashCode();
    }

    // @see org.jlib.core.collections.Collection#toJavaCollection()
    @Override
    public java.util.Collection<Element> toJavaCollection() {
        return backedCollection.toJavaCollection();
    }
}
