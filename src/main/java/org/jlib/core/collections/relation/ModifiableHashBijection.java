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
 * ModifiableBijection implemented using hashing for left and right hand side
 * elements.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the bijection
 * @param <RightObject>
 *        type of the objects on the right hand side of the bijection
 * @author Igor Akkerman
 */
public class ModifiableHashBijection<LeftObject, RightObject>
extends HashBijection<LeftObject, RightObject>
implements ModifiableBijection<LeftObject, RightObject> {

    /**
     * ModifiableBinaryRelation used as delegate for some methods allowing the
     * {@code ModifiableHashBijection} class to implement the
     * {@link ModifiableBinaryRelation} interface.
     * 
     * @param <DelegateLeftObject>
     *        type of the objects on the left hand side of the BinaryRelation
     * @param <DelegateRightObject>
     *        type of the objects on the right hand side of the BinaryRelation
     * @author Igor Akkerman
     */
    private class DelegateBijection<DelegateLeftObject, DelegateRightObject>
    extends AbstractModifiableBinaryRelation<DelegateLeftObject, DelegateRightObject> {

        /** Bijection for which this Bijection is used as delegate */
        private final ModifiableBijection<DelegateLeftObject, DelegateRightObject> baseBijection;

        /**
         * Creates a new DelegateBijection.
         * 
         * @param baseBijection
         *        ModifiableBijection for which this Bijection is used as
         *        delegate
         */
        DelegateBijection(ModifiableBijection<DelegateLeftObject, DelegateRightObject> baseBijection) {
            super();
            this.baseBijection = baseBijection;
        }

        // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#add(java.lang.Object, java.lang.Object)
        @Override
        public boolean add(DelegateLeftObject leftObject, DelegateRightObject rightObject) {
            return baseBijection.add(leftObject, rightObject);
        }

        // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#remove(java.lang.Object, java.lang.Object)
        @Override
        public boolean remove(DelegateLeftObject leftObject, DelegateRightObject rightObject) {
            return baseBijection.remove(leftObject, rightObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#hasLeft(java.lang.Object)
        @Override
        public boolean hasLeft(DelegateLeftObject leftObject) {
            return baseBijection.hasLeft(leftObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#hasRight(java.lang.Object)
        @Override
        public boolean hasRight(DelegateRightObject rightObject) {
            return baseBijection.hasRight(rightObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#leftObjects()
        @Override
        public Set<DelegateLeftObject> leftObjects() {
            return baseBijection.leftObjects();
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#leftSet(java.lang.Object)
        @Override
        public Set<DelegateLeftObject> leftSet(DelegateRightObject rightObject) {
            return baseBijection.leftSet(rightObject);
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#rightObjects()
        @Override
        public Set<DelegateRightObject> rightObjects() {
            return baseBijection.rightObjects();
        }

        // @see org.jlib.core.collections.relation.BinaryRelation#rightSet(java.lang.Object)
        @Override
        public Set<DelegateRightObject> rightSet(DelegateLeftObject leftObject) {
            return baseBijection.rightSet(leftObject);
        }

        // @see org.jlib.core.collections.Collection#size()
        @Override
        public int size() {
            return baseBijection.size();
        }
    }

    /** DelegateBijection for this Bijection */
    private final DelegateBijection<LeftObject, RightObject> delegateBijection = new DelegateBijection<LeftObject, RightObject>(
                                                                                                                                this);

    /**
     * Creates a new initially empty ModifiableHashBijection.
     */
    public ModifiableHashBijection() {
        super();
    }

    /**
     * Creates a new ModifiableHashBijection containing the Associations
     * contained by the specified jlib Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the
     *         Collection, it is ignored
     */
    public ModifiableHashBijection(Collection<Association<LeftObject, RightObject>> associations) {
        super(associations);
    }

    /**
     * Creates a new ModifiableHashBijection containing the Associations
     * contained by the specified Java Collection.
     * 
     * @param associations
     *        Java Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the
     *         Collection, it is ignored
     */
    public ModifiableHashBijection(java.util.Collection<Association<LeftObject, RightObject>> associations) {
        super(associations);
    }

    /**
     * Creates a new ModifiableHashBijection containing the Associations
     * specified in a comma separated list.
     * 
     * @param associations
     *        Comma separated list of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the
     *         Collection, it is ignored
     */
    public ModifiableHashBijection(Association<LeftObject, RightObject>... associations) {
        super(associations);
    }

    // @see org.jlib.core.collections.relation.ModifiableBijection#put(java.lang.Object, java.lang.Object)
    // overridden to be made public
    @Override
    public boolean add(LeftObject leftObject, RightObject rightObject)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        return super.add(leftObject, rightObject);
    }

    // @see org.jlib.core.collections.relation.ModifiableBinaryRelation#remove(java.lang.Object, java.lang.Object)
    @Override
    public boolean remove(LeftObject leftObject, RightObject rightObject) {
        leftToRightMap.remove(leftObject);
        return rightToLeftMap.remove(rightObject) != null;
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public Iterator<Association<LeftObject, RightObject>> iterator() {
        return delegateBijection.iterator();
    }

    // @see org.jlib.core.collections.ModifiableCollection#addAll(org.jlib.core.collections.Collection)
    @Override
    public boolean addAll(Collection<? extends Association<LeftObject, RightObject>> otherCollection) {
        return delegateBijection.addAll(otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#addAll(Element[])
    @Override
    public boolean addAll(Association<LeftObject, RightObject>... elements) {
        return delegateBijection.addAll(elements);
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(org.jlib.core.collections.Collection)
    @Override
    public boolean removeAll(Collection<?> otherCollection) {
        return delegateBijection.removeAll(otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#removeAll(java.lang.Object[])
    @Override
    public boolean removeAll(Object... elements) {
        return delegateBijection.removeAll(elements);
    }

    // @see org.jlib.core.collections.ModifiableCollection#retainAll(org.jlib.core.collections.Collection)
    @Override
    public boolean retainAll(Collection<?> otherCollection) {
        return delegateBijection.retainAll(otherCollection);
    }

    // @see org.jlib.core.collections.ModifiableCollection#retainAll(java.lang.Object[])
    @Override
    public boolean retainAll(Object... elements) {
        return delegateBijection.retainAll(elements);
    }

    // @see java.util.Collection#add(java.lang.Object)
    @Override
    public boolean add(Association<LeftObject, RightObject> association) {
        return delegateBijection.add(association);
    }

    // @see java.util.Collection#addAll(java.util.Collection)
    @Override
    public boolean addAll(java.util.Collection<? extends Association<LeftObject, RightObject>> javaCollection) {
        return delegateBijection.addAll(javaCollection);
    }

    // @see java.util.Collection#clear()
    @Override
    public void clear() {
        delegateBijection.clear();
    }

    // @see java.util.Collection#remove(java.lang.Object)
    @Override
    public boolean remove(Object object) {
        return delegateBijection.remove(object);
    }

    // @see java.util.Collection#removeAll(java.util.Collection)
    @Override
    public boolean removeAll(java.util.Collection<?> javaCollection) {
        return delegateBijection.removeAll(javaCollection);
    }

    // @see java.util.Collection#retainAll(java.util.Collection)
    @Override
    public boolean retainAll(java.util.Collection<?> javaCollection) {
        return delegateBijection.retainAll(javaCollection);
    }

    // @see java.util.Collection#toArray(T[])
    @Override
    public <T> T[] toArray(T[] array) {
        return delegateBijection.toArray(array);
    }
}
