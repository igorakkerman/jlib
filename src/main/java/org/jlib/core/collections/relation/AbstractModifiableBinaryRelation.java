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

package org.jlib.core.collections.relation;

import java.util.Iterator;

import org.jlib.core.collections.AbstractModifiableCollection;
import org.jlib.core.collections.Collection;
import org.jlib.core.collections.ModifiableCollection;

/**
 * Skeletal implementation of a ModifiableBinaryRelation.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public abstract class AbstractModifiableBinaryRelation<LeftObject, RightObject>
extends AbstractBinaryRelation<LeftObject, RightObject>
implements ModifiableBinaryRelation<LeftObject, RightObject> {

    /**
     * ModifiableCollection used as delegate for some methods allowing the
     * {@code AbstractModifiableBinaryRelation} class to implement the
     * {@link ModifiableCollection} interface.
     * 
     * @param <DelegateLeftObject>
     *        type of the objects on the left hand side of the Associations held
     *        in this Collection
     * @param <DelegateRightObject>
     *        type of the objects on the right hand side of the Associations
     *        held in this Collection
     * @author Igor Akkerman
     */
    private class DelegateCollection<DelegateLeftObject, DelegateRightObject>
    extends AbstractModifiableCollection<Association<DelegateLeftObject, DelegateRightObject>> {

        /** BinaryRelation for which this Collection is used as delegate */
        private final ModifiableBinaryRelation<DelegateLeftObject, DelegateRightObject> baseBinaryRelation;

        /**
         * Creates a new DelegateCollection.
         * 
         * @param baseBinaryRelation
         *        BinaryRelation for which this Collection is used as delegate
         */
        DelegateCollection(ModifiableBinaryRelation<DelegateLeftObject, DelegateRightObject> baseBinaryRelation) {
            super();
            this.baseBinaryRelation = baseBinaryRelation;
        }

        // @see org.jlib.core.collections.Collection#size()
        @Override
        public int size() {
            return baseBinaryRelation.size();
        }

        // @see java.lang.Iterable#iterator()
        @Override
        public Iterator<Association<DelegateLeftObject, DelegateRightObject>> iterator() {
            return baseBinaryRelation.iterator();
        }

        // @see java.util.Collection#add(java.lang.Object)
        @Override
        public boolean add(Association<DelegateLeftObject, DelegateRightObject> element) {
            return baseBinaryRelation.add(element);
        }

        // @see java.util.Collection#remove(java.lang.Object)
        @Override
        public boolean remove(Object object) {
            return baseBinaryRelation.remove(object);
        }
    }

    /** DelegateCollection for this BinaryRelation */
    private final DelegateCollection<LeftObject, RightObject> delegateCollection = new DelegateCollection<LeftObject, RightObject>(
                                                                                                                             this);

    /**
     * Creates a new AbstractModifiableBinaryRelation.
     */
    protected AbstractModifiableBinaryRelation() {
        super();
    }
    
    // @see java.lang.Iterable#iterator()
    @Override
    public Iterator<Association<LeftObject, RightObject>> iterator() {
        return new ModifiableBinaryRelationIterator<LeftObject, RightObject>(this);
    }

    // @see java.util.Collection#add(java.lang.Object)
    @Override
    public boolean add(Association<LeftObject, RightObject> association) {
        return add(association.left(), association.right());
    }

    // @see java.util.Collection#remove(java.lang.Object)
    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object object) {
        try {
            // wrong type of the Object (not Association<?, ?>) may cause a ClassCastException here
            Association<LeftObject, RightObject> association = (Association<LeftObject, RightObject>) object;
            // wrong parameter types of the Association Objects may cause a ClassCastException here
            return remove(association.left(), association.right());
        }
        catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends Association<LeftObject, RightObject>> otherCollection) {
        return delegateCollection.addAll(otherCollection);
    }

    @Override
    public boolean addAll(Association<LeftObject, RightObject>... elements) {
        return delegateCollection.addAll(elements);
    }

    // @see java.util.Collection#addAll(java.util.Collection)
    @Override
    public boolean addAll(java.util.Collection<? extends Association<LeftObject, RightObject>> javaCollection) {
        return delegateCollection.addAll(javaCollection);
    }

    @Override
    public boolean removeAll(Collection<?> otherCollection) {
        return delegateCollection.removeAll(otherCollection);
    }

    @Override
    public boolean removeAll(Object... elements) {
        return delegateCollection.removeAll(elements);
    }

    // @see java.util.Collection#removeAll(java.util.Collection)
    @Override
    public boolean removeAll(java.util.Collection<?> javaCollection) {
        return delegateCollection.removeAll(javaCollection);
    }

    @Override
    public boolean retainAll(Collection<?> otherCollection) {
        return delegateCollection.retainAll(otherCollection);
    }

    @Override
    public boolean retainAll(Object... elements) {
        return delegateCollection.retainAll(elements);
    }
    
    // @see java.util.Collection#retainAll(java.util.Collection)
    @Override
    public boolean retainAll(java.util.Collection<?> javaCollection) {
        return delegateCollection.retainAll(javaCollection);
    }
    
    // @see java.util.Collection#clear()
    @Override
    public void clear() {
        delegateCollection.clear();
    }
    
    // @see java.util.Collection#toArray(T[])
    @Override
    public <T> T[] toArray(T[] array) {
        return delegateCollection.toArray(array);
    }
}
