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

import java.util.Set;

import org.jlib.container.Container;

/**
 * AddBinaryRelation implemented using hashing for left and right hand
 * side items.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightValue>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public class AddHashBinaryRelation<LeftValue, RightValue>
extends HashBinaryRelation<LeftValue, RightValue>
implements AddBinaryRelation<LeftValue, RightValue> {

    /**
     * AddBinaryRelation used as delegate for some methods allowing the
     * {@code AddHashBinaryRelation} class to implement the
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
    private class DelegateBinaryRelation<DelegateLeftValue, DelegateRightValue>
    extends AbstractAddBinaryRelation<DelegateLeftValue, DelegateRightValue> {

        /**
         * AddBinaryRelation for which this BinaryRelation is used as
         * delegate
         */
        private AddBinaryRelation<DelegateLeftValue, DelegateRightValue> baseBinaryRelation;

        /**
         * Creates a new DelegateBinaryRelation.
         * 
         * @param baseBinaryRelation
         *        AddBinaryRelation for which this BinaryRelation is used
         *        as delegate
         */
        DelegateBinaryRelation(final AddBinaryRelation<DelegateLeftValue, DelegateRightValue> baseBinaryRelation) {
            super();
            this.baseBinaryRelation = baseBinaryRelation;
        }

        // @see org.jlib.container.binaryrelation.AddBinaryRelation#add(java.lang.Object, java.lang.Object)
        @Override
        public void add(final DelegateLeftValue leftValue, DelegateRightValue rightValue) {
            baseBinaryRelation.add(leftValue, rightValue);
        }

        // @see org.jlib.container.binaryrelation.AddBinaryRelation#remove(java.lang.Object, java.lang.Object)
        @Override
        public void remove(final DelegateLeftValue leftValue, DelegateRightValue rightValue) {
            baseBinaryRelation.remove(leftValue, rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#hasLeft(java.lang.Object)
        @Override
        public boolean hasLeft(final DelegateLeftValue leftValue) {
            return baseBinaryRelation.hasLeft(leftValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#hasRight(java.lang.Object)
        @Override
        public boolean hasRight(final DelegateRightValue rightValue) {
            return baseBinaryRelation.hasRight(rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#leftValues()
        @Override
        public Set<DelegateLeftValue> leftValues() {
            return baseBinaryRelation.leftValues();
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#leftSet(java.lang.Object)
        @Override
        public Set<DelegateLeftValue> leftSet(final DelegateRightValue rightValue) {
            return baseBinaryRelation.leftSet(rightValue);
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#rightValues()
        @Override
        public Set<DelegateRightValue> rightValues() {
            return baseBinaryRelation.rightValues();
        }

        // @see org.jlib.container.binaryrelation.BinaryRelation#rightSet(java.lang.Object)
        @Override
        public Set<DelegateRightValue> rightSet(final DelegateLeftValue leftValue) {
            return baseBinaryRelation.rightSet(leftValue);
        }

        // @see Container#size()
        @Override
        public int getSize() {
            return baseBinaryRelation.getSize();
        }
    }

    /** DelegateBinaryRelation for this AddHashBinaryRelation */
    DelegateBinaryRelation<LeftValue, RightValue> delegateBinaryRelation =
        new DelegateBinaryRelation<LeftValue, RightValue>(this);

    /**
     * Creates a new initially empty AddHashBinaryRelation.
     */
    public AddHashBinaryRelation() {
        super();
    }

    /**
     * Creates a new AddHashBinaryRelation containing the Associations
     * contained by the specified jlib Container.
     * 
     * @param associations
     *        Container of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public AddHashBinaryRelation(final Container<Association<LeftValue, RightValue>> associations) {
        super(associations);
    }

    /**
     * Creates a new AddHashBinaryRelation containing the Associations
     * contained by the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public AddHashBinaryRelation(final Collection<Association<LeftValue, RightValue>> associations) {
        super(associations);
    }

    /**
     * Creates a new AddHashBinaryRelation containing the Associations
     * specified in a comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public AddHashBinaryRelation(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        super(associations);
    }

    // overridden to be made public
    @Override
    public void add(final LeftValue leftValue, RightValue rightValue)
    throws ObjectAlreadyAssociatedException {
        super.add(leftValue, rightValue);
    }

    @Override
    public void remove(final LeftValue leftValue, RightValue rightValue) {
        leftToRightMap.get(leftValue).remove(rightValue);
        rightToLeftMap.get(rightValue).remove(leftValue);
    }

    @Override
    public Traverser<Association<LeftValue, RightValue>> iterator() {
        return delegateBinaryRelation.iterator();
    }

    @Override
    public void addAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBinaryRelation.addAll(associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... items) {
        delegateBinaryRelation.addAll(items);
    }

    @Override
    public void removeAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBinaryRelation.removeAll(associations);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... items) {
        delegateBinaryRelation.removeAll(items);
    }

    @Override
    public void retainAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBinaryRelation.retainAll(associations);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... items) {
        delegateBinaryRelation.retainAll(items);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association) {
        delegateBinaryRelation.add(association);
    }

    @Override
    public void addAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateBinaryRelation.addAll(associations);
    }

    @Override
    public void clear() {
        delegateBinaryRelation.removeAll();
    }

    @Override
    public void remove(final Association<LeftValue, RightValue> object) {
        delegateBinaryRelation.remove(object);
    }

    @Override
    public void removeAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateBinaryRelation.removeAll(associations);
    }

    @Override
    public void retainAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateBinaryRelation.retainAll(associations);
    }

    @Override
    public Association<LeftValue, RightValue>[] toArray() {
        return delegateBinaryRelation.toArray();
    }
}
