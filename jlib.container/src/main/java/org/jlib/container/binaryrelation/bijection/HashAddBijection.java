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

package org.jlib.container.binaryrelation.bijection;

import java.util.Collection;
import java.util.Set;

import org.jlib.container.Container;
import org.jlib.container.binaryrelation.AddBinaryRelation;
import org.jlib.container.binaryrelation.Association;
import org.jlib.core.traverser.Traverser;

/**
 * {@link AddBijection} implemented using hashing for left and right hand side
 * associations.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the bijection
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the bijection
 * 
 * @author Igor Akkerman
 */
public class HashAddBijection<LeftValue, RightValue>
extends HashBijection<LeftValue, RightValue>
implements AddBijection<LeftValue, RightValue> {

    /**
     * AddBinaryRelation used as delegate for some methods allowing the
     * {@code HashAddBijection} class to implement the {@link AddBinaryRelation}
     * interface.
     * 
     * @param <DelegateLeftValue>
     *        type of the objects on the left hand side of the BinaryRelation
     * 
     * @param <DelegateRightValue>
     *        type of the objects on the right hand side of the BinaryRelation
     * 
     * @author Igor Akkerman
     */
    private class DelegateBijection<DelegateLeftValue, DelegateRightValue>
    extends AbstractAddBinaryRelation<DelegateLeftValue, DelegateRightValue> {

        /** Bijection for which this Bijection is used as delegate */
        private final AddBijection<DelegateLeftValue, DelegateRightValue> baseBijection;

        /**
         * Creates a new DelegateBijection.
         * 
         * @param baseBijection
         *        AddBijection for which this Bijection is used as delegate
         */
        DelegateBijection(final AddBijection<DelegateLeftValue, DelegateRightValue> baseBijection) {
            super();

            this.baseBijection = baseBijection;
        }

        // @see org.jlib.container.binaryrelation.AddBinaryRelation#add(java.lang.Object, java.lang.Object)
        @Override
        public void add(final DelegateLeftValue leftValue, final DelegateRightValue rightValue) {
            baseBijection.insert(leftValue, rightValue);
        }

        // @see org.jlib.container.binaryrelation.AddBinaryRelation#remove(java.lang.Object, java.lang.Object)
        @Override
        public void remove(final DelegateLeftValue leftValue, final DelegateRightValue rightValue) {
            baseBijection.remove(leftValue, rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#hasLeft(java.lang.Object)
        @Override
        public boolean hasLeft(final DelegateLeftValue leftValue) {
            return baseBijection.hasLeft(leftValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#hasRight(java.lang.Object)
        @Override
        public boolean hasRight(final DelegateRightValue rightValue) {
            return baseBijection.hasRight(rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#leftValues()
        @Override
        public Set<DelegateLeftValue> getLeftValues() {
            return baseBijection.getLeftValues();
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#leftSet(java.lang.Object)
        @Override
        public Set<DelegateLeftValue> leftSet(final DelegateRightValue rightValue) {
            return baseBijection.getLeftSet(rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#rightValues()
        @Override
        public Set<DelegateRightValue> getRightValues() {
            return baseBijection.getRightValues();
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#rightSet(java.lang.Object)
        @Override
        public Set<DelegateRightValue> rightSet(final DelegateLeftValue leftValue) {
            return baseBijection.getRightSet(leftValue);
        }

        // @see Container#size()
        @Override
        public int getSize() {
            return baseBijection.getSize();
        }
    }

    /** DelegateBijection for this Bijection */
    private final DelegateBijection<LeftValue, RightValue> delegateBijection =
        new DelegateBijection<LeftValue, RightValue>(this);

    /** Creates a new initially empty HashAddBijection. */
    public HashAddBijection() {
        super();
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified jlib Container.
     * 
     * @param associations
     *        Container of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations specified in a
     * comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    // overridden to be made public
    @Override
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        super.associate(leftValue, rightValue);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue) {
        leftToRightMap.remove(leftValue);
        rightToLeftMap.remove(rightValue);
    }

    @Override
    public Traverser<Association<LeftValue, RightValue>> iterator() {
        return delegateBijection.iterator();
    }

    @Override
    public void addAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void removeAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.removeAll(associations);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateBijection.removeAll(associations);
    }

    @Override
    public void retainAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.retainAll(associations);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateBijection.retainAll(associations);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association) {
        delegateBijection.add(association);
    }

    @Override
    public void addAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void clear() {
        delegateBijection.removeAll();
    }

    @Override
    public void remove(final Association<LeftValue, RightValue> object) {
        delegateBijection.remove(object);
    }

    @Override
    public void removeAll(final Collection<? extends Association<LeftValue, RightValue>> collection) {
        delegateBijection.removeAll(collection);
    }

    @Override
    public void retainAll(final Collection<? extends Association<LeftValue, RightValue>> collection) {
        delegateBijection.retainAll(collection);
    }

}
