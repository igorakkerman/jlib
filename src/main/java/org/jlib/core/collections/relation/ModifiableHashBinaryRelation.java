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
import java.util.Set;

import org.jlib.core.collections.Collection;

/**
 * ModifiableBinaryRelation implemented using hashing for left and right hand
 * side elements.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public class ModifiableHashBinaryRelation<LeftObject, RightObject>
extends HashBinaryRelation<LeftObject, RightObject>
implements ModifiableBinaryRelation<LeftObject, RightObject> {

    /**
     * ModifiableBinaryRelation used as delegate for some methods allowing the
     * {@code ModifiableHashBinaryRelation} class to implement the
     * {@link ModifiableBinaryRelation} interface.
     * 
     * @param <DelegateLeftObject>
     *        type of the objects on the left hand side of the BinaryRelation
     * @param <DelegateRightObject>
     *        type of the objects on the right hand side of the BinaryRelation
     * @author Igor Akkerman
     */
    private class DelegateBinaryRelation<DelegateLeftObject, DelegateRightObject>
    extends AbstractModifiableBinaryRelation<DelegateLeftObject, DelegateRightObject> {

        /**
         * ModifiableBinaryRelation for which this BinaryRelation is used as
         * delegate
         */
        private ModifiableBinaryRelation<DelegateLeftObject, DelegateRightObject> baseBinaryRelation;

        /**
         * Creates a new DelegateBinaryRelation.
         * 
         * @param baseBinaryRelation
         *        ModifiableBinaryRelation for which this BinaryRelation is used
         *        as delegate
         */
        DelegateBinaryRelation(ModifiableBinaryRelation<DelegateLeftObject, DelegateRightObject> baseBinaryRelation) {
            super();
            this.baseBinaryRelation = baseBinaryRelation;
        }

        // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#add(java.lang.Object, java.lang.Object)
        @Override
        public boolean add(DelegateLeftObject leftObject, DelegateRightObject rightObject) {
            return baseBinaryRelation.add(leftObject, rightObject);
        }

        // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#remove(java.lang.Object, java.lang.Object)
        @Override
        public boolean remove(DelegateLeftObject leftObject, DelegateRightObject rightObject) {
            return baseBinaryRelation.remove(leftObject, rightObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#hasLeft(java.lang.Object)
        @Override
        public boolean hasLeft(DelegateLeftObject leftObject) {
            return baseBinaryRelation.hasLeft(leftObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#hasRight(java.lang.Object)
        @Override
        public boolean hasRight(DelegateRightObject rightObject) {
            return baseBinaryRelation.hasRight(rightObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#leftObjects()
        @Override
        public Set<DelegateLeftObject> leftObjects() {
            return baseBinaryRelation.leftObjects();
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#leftSet(java.lang.Object)
        @Override
        public Set<DelegateLeftObject> leftSet(DelegateRightObject rightObject) {
            return baseBinaryRelation.leftSet(rightObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#rightObjects()
        @Override
        public Set<DelegateRightObject> rightObjects() {
            return baseBinaryRelation.rightObjects();
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#rightSet(java.lang.Object)
        @Override
        public Set<DelegateRightObject> rightSet(DelegateLeftObject leftObject) {
            return baseBinaryRelation.rightSet(leftObject);
        }

        // @see org.jlib.core.collections.Collection#size()
        @Override
        public int size() {
            return baseBinaryRelation.size();
        }
    }

    /** DelegateBinaryRelation for this ModifiableHashBinaryRelation */
    DelegateBinaryRelation<LeftObject, RightObject> delegateBinaryRelation = new DelegateBinaryRelation<LeftObject, RightObject>(
                                                                                                                                 this);

    /**
     * Creates a new initially empty ModifiableHashBinaryRelation.
     */
    public ModifiableHashBinaryRelation() {
        super();
    }

    /**
     * Creates a new ModifiableHashBinaryRelation containing the Associations
     * contained by the specified jlib Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public ModifiableHashBinaryRelation(Collection<Association<LeftObject, RightObject>> associations)
    throws NullPointerException {
        super(associations);
    }

    /**
     * Creates a new ModifiableHashBinaryRelation containing the Associations
     * contained by the specified Java Collection.
     * 
     * @param associations
     *        Java Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public ModifiableHashBinaryRelation(java.util.Collection<Association<LeftObject, RightObject>> associations)
    throws NullPointerException {
        super(associations);
    }

    /**
     * Creates a new ModifiableHashBinaryRelation containing the Associations
     * specified in a comma separated list.
     * 
     * @param associations
     *        Comma separated list of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public ModifiableHashBinaryRelation(Association<LeftObject, RightObject>... associations)
    throws NullPointerException {
        super(associations);
    }

    // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#put(java.lang.Object, java.lang.Object)
    // overridden to be made public
    @Override
    public boolean add(LeftObject leftObject, RightObject rightObject)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        return super.add(leftObject, rightObject);
    }

    // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#remove(java.lang.Object, java.lang.Object)
    @Override
    public boolean remove(LeftObject leftObject, RightObject rightObject) {
        leftToRightMap.get(leftObject).remove(rightObject);
        return rightToLeftMap.get(rightObject).remove(leftObject);
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public Iterator<Association<LeftObject, RightObject>> iterator() {
        return delegateBinaryRelation.iterator();
    }

    // @see org.jlib.core.collections.ModifiableCollection#addAll(org.jlib.core.collections.Collection)
    @Override
    public boolean addAll(Collection<? extends Association<LeftObject, RightObject>> otherCollection) {
        return delegateBinaryRelation.addAll(otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#addAll(Element[])
    @Override
    public boolean addAll(Association<LeftObject, RightObject>... elements) {
        return delegateBinaryRelation.addAll(elements);
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(org.jlib.core.collections.Collection)
    @Override
    public boolean removeAll(Collection<?> otherCollection) {
        return delegateBinaryRelation.removeAll(otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(java.lang.Object[])
    @Override
    public boolean removeAll(Object... elements) {
        return delegateBinaryRelation.removeAll(elements);
    }

    // @see org.jlib.core.collections.ModifiableCollection#retainAll(org.jlib.core.collections.Collection)
    @Override
    public boolean retainAll(Collection<?> otherCollection) {
        return delegateBinaryRelation.retainAll(otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#retainAll(java.lang.Object[])
    @Override
    public boolean retainAll(Object... elements) {
        return delegateBinaryRelation.retainAll(elements);
    }

    // @see java.util.Collection#add(java.lang.Object)
    @Override
    public boolean add(Association<LeftObject, RightObject> association) {
        return delegateBinaryRelation.add(association);
    }

    // @see java.util.Collection#addAll(java.util.Collection)
    @Override
    public boolean addAll(java.util.Collection<? extends Association<LeftObject, RightObject>> javaCollection) {
        return delegateBinaryRelation.addAll(javaCollection);
    }

    // @see java.util.Collection#clear()
    @Override
    public void clear() {
        delegateBinaryRelation.clear();
    }

    // @see java.util.Collection#remove(java.lang.Object)
    @Override
    public boolean remove(Object object) {
        return delegateBinaryRelation.remove(object);
    }

    // @see java.util.Collection#removeAll(java.util.Collection)
    @Override
    public boolean removeAll(java.util.Collection<?> javaCollection) {
        return delegateBinaryRelation.removeAll(javaCollection);
    }

    // @see java.util.Collection#retainAll(java.util.Collection)
    @Override
    public boolean retainAll(java.util.Collection<?> javaCollection) {
        return delegateBinaryRelation.retainAll(javaCollection);
    }

    // @see java.util.Collection#toArray(T[])
    @Override
    public <T> T[] toArray(T[] array) {
        return delegateBinaryRelation.toArray(array);
    }
}
