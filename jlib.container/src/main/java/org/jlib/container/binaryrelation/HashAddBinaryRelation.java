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

import org.jlib.container.Container;
import org.jlib.container.binaryrelation.bijection.ObjectAlreadyAssociatedException;
import org.jlib.core.traverser.Traverser;

/**
 * AddBinaryRelation implemented using hashing for left and right hand side
 * items.
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
     * Creates a new AddHashBinaryRelation containing the Associations contained
     * by the specified jlib Container.
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
     * Creates a new AddHashBinaryRelation containing the Associations contained
     * by the specified Collection.
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
     * Creates a new AddHashBinaryRelation containing the Associations specified
     * in a comma separated sequence.
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
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws ObjectAlreadyAssociatedException {
        super.associate(leftValue, rightValue);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue) {
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
