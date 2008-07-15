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

/**
 * Skeletal implementation of a ModifiableCollection.
 * 
 * @param <Element>
 *        type of elements held in the Collection
 * @author Igor Akkerman
 */
public abstract class AbstractModifiableCollection<Element>
extends AbstractCollection<Element>
implements ModifiableCollection<Element> {

    /**
     * Java Collection used as delegate for some methods allowing the {@code AbstractModifiableCollection} class to
     * implement the {@link java.util.Collection} interface.
     * 
     * @param <DelegateElement>
     *        type of elements held in the Collection
     * @author Igor Akkerman
     */
    private final class DelegateCollection<DelegateElement>
    extends java.util.AbstractCollection<DelegateElement> {

        /** Collection for which this Java Collection is used as delegate */
        private ModifiableCollection<DelegateElement> baseCollection;

        /**
         * Creates a new DelegateModifiableCollection.
         * 
         * @param baseCollection
         *        ModifiableCollection for which this Java Collection is used as delegate
         */
        DelegateCollection(ModifiableCollection<DelegateElement> baseCollection) {
            super();
            this.baseCollection = baseCollection;
        }

        // @see org.jlib.core.collections.Collection#size()
        @Override
        public int size() {
            return baseCollection.size();
        }

        // @see java.util.AbstractCollection#contains(java.lang.Object)
        @Override
        public boolean contains(Object object) {
            return baseCollection.contains(object);
        }

        // @see java.lang.Iterable#iterator()
        @Override
        public Iterator<DelegateElement> iterator() {
            return baseCollection.iterator();
        }

        // @see java.util.Collection#remove(java.lang.Object)
        @Override
        public boolean remove(Object object) {
            return baseCollection.remove(object);
        }
    }

    /** DelegateCollection for this Collection */
    private final DelegateCollection<Element> delegateCollection = new DelegateCollection<Element>(this);

    /**
     * Creates a new ModifiableCollection.
     */
    protected AbstractModifiableCollection() {
        super();
    }

    /**
     * Adds all Elements returned by the Iterator of the specified Iterable to this Collection.
     * 
     * @param iterable
     *        Iterable creating the Iterator returning the Elements to add to this Collection
     * @return {@code true} if this Collection has been modified by this operation; {@code false} otherwise
     */
    private boolean addAll(Iterable<? extends Element> iterable) {
        boolean modified = false;
        for (Element element : iterable)
            modified |= add(element);
        return modified;
    }

    // @see org.jlib.core.collections.ModifiableCollection#addAll(org.jlib.core.collections.Collection)
    // method kept to allow overriding in subclasses for efficiency
    @Override
    public boolean addAll(Collection<? extends Element> otherCollection) {
        return addAll((Iterable<? extends Element>) otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#addAll(Element[])
    @Override
    public boolean addAll(Element... elements) {
        boolean modified = false;
        for (Element element : elements)
            modified |= add(element);
        return modified;
    }

    // @see java.util.Collection#addAll(java.util.Collection)
    @Override
    public boolean addAll(java.util.Collection<? extends Element> otherCollection) {
        return addAll((Iterable<? extends Element>) otherCollection);
    }

    // @see java.util.Collection#clear()
    @Override
    public void clear() {
        Iterator<Element> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /**
     * Removes all Elements returned by the Iterator of the specified Iterable from this Collection.
     * 
     * @param iterable
     *        Iterable creating the Iterator returning the Elements to remove from this Collection
     * @return {@code true} if this Collection has been modified by this operation; {@code false} otherwise
     */
    private boolean removeAll(Iterable<?> iterable) {
        boolean modified = false;
        for (Object object : iterable)
            modified |= remove(object);
        return modified;
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(org.jlib.core.collections.Collection)
    @Override
    public boolean removeAll(Collection<?> otherCollection) {
        return removeAll((Iterable<?>) otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(java.lang.Object[])
    @Override
    public boolean removeAll(Object... elements) {
        boolean modified = false;
        for (Object object : elements)
            modified |= remove(object);
        return modified;
    }

    @Override
    public boolean removeAll(java.util.Collection<?> otherCollection) {
        return removeAll((Iterable<?>) otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#retainAll(org.jlib.core.collections.Collection)
    @Override
    public boolean retainAll(Collection<?> otherCollection) {
        boolean modified = false;
        for (Object object : this)
            if (otherCollection.contains(object))
                modified |= remove(object);
        return modified;
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(java.lang.Object[])
    @Override
    public boolean retainAll(Object... elements) {
        // necessary as we need the contains() method fot the elements list
        return retainAll(CollectionsUtility.asSet(elements));
    }

    // @see org.jlib.core.collections.ModifiableCollection#retainAll(org.jlib.core.collections.Collection)
    @Override
    public boolean retainAll(java.util.Collection<?> otherCollection) {
        return delegateCollection.retainAll(otherCollection);
    }

    // @see java.util.Collection#toArray(T[])
    // implemented only in this class (not already in AbstractCollection)
    // because it is only specified by java.util.Collection, not by org.jlib.core.collections.Collection
    // Thus, it is not needed to implement the jlib Collection interface
    @Override
    public <ArrayElement> ArrayElement[] toArray(ArrayElement[] array) {
        return delegateCollection.toArray(array);
    }
}
