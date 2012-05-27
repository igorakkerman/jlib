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

package org.jlib.container.binaryrelation;

import java.util.Collection;
import java.util.Traverser;
import java.util.Set;

import org.jlib.container.Container;

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
     * {@code HashAddBijection} class to implement the
     * {@link AddBinaryRelation} interface.
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
         *        AddBijection for which this Bijection is used as
         *        delegate
         */
        DelegateBijection(AddBijection<DelegateLeftValue, DelegateRightValue> baseBijection) {
            super();

            this.baseBijection = baseBijection;
        }

        // @see org.jlib.container.binaryrelation.AddBinaryRelation#add(java.lang.Object, java.lang.Object)
        @Override
        public void add(DelegateLeftValue leftValue, DelegateRightValue rightValue) {
            baseBijection.insert(leftValue, rightValue);
        }

        // @see org.jlib.container.binaryrelation.AddBinaryRelation#remove(java.lang.Object, java.lang.Object)
        @Override
        public void remove(DelegateLeftValue leftValue, DelegateRightValue rightValue) {
            baseBijection.remove(leftValue, rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#hasLeft(java.lang.Object)
        @Override
        public boolean hasLeft(DelegateLeftValue leftValue) {
            return baseBijection.hasLeft(leftValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#hasRight(java.lang.Object)
        @Override
        public boolean hasRight(DelegateRightValue rightValue) {
            return baseBijection.hasRight(rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#leftValues()
        @Override
        public Set<DelegateLeftValue> leftValues() {
            return baseBijection.leftValues();
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#leftSet(java.lang.Object)
        @Override
        public Set<DelegateLeftValue> leftSet(DelegateRightValue rightValue) {
            return baseBijection.leftSet(rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#rightValues()
        @Override
        public Set<DelegateRightValue> rightValues() {
            return baseBijection.rightValues();
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#rightSet(java.lang.Object)
        @Override
        public Set<DelegateRightValue> rightSet(DelegateLeftValue leftValue) {
            return baseBijection.rightSet(leftValue);
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
     * Creates a new HashAddBijection containing the Associations
     * contained by the specified jlib Container.
     * 
     * @param associations
     *        Container of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddBijection(Container<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations
     * contained by the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddBijection(Collection<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations
     * specified in a comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     *        
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) Association<LeftValue, RightValue>... associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    // overridden to be made public
    @Override
    public void add(LeftValue leftValue, RightValue rightValue)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        super.add(leftValue, rightValue);
    }

    @Override
    public void remove(LeftValue leftValue, RightValue rightValue) {
        leftToRightMap.remove(leftValue);
        rightToLeftMap.remove(rightValue);
    }

    @Override
    public Traverser<Association<LeftValue, RightValue>> iterator() {
        return delegateBijection.iterator();
    }

    @Override
    public void addAll(Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) Association<LeftValue, RightValue>... associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void removeAll(Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.removeAll(associations);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) Association<LeftValue, RightValue>... associations) {
        delegateBijection.removeAll(associations);
    }

    @Override
    public void retainAll(Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.retainAll(associations);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) Association<LeftValue, RightValue>... associations) {
        delegateBijection.retainAll(associations);
    }

    @Override
    public void add(Association<LeftValue, RightValue> association) {
        delegateBijection.add(association);
    }

    @Override
    public void addAll(Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void clear() {
        delegateBijection.clear();
    }

    @Override
    public void remove(Association<LeftValue, RightValue> object) {
        delegateBijection.remove(object);
    }

    @Override
    public void removeAll(Collection<? extends Association<LeftValue, RightValue>> collection) {
        delegateBijection.removeAll(collection);
    }

    @Override
    public void retainAll(Collection<? extends Association<LeftValue, RightValue>> collection) {
        delegateBijection.retainAll(collection);
    }

}
