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
import org.jlib.container.ContainerUtility;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * {@link AddBinaryRelation} implemented using hashing for left and right hand
 * side items.
 * 
 * @param <LeftValue>
 *        type of the items on the left hand side of the {@link BinaryRelation}
 * 
 * @param <RightValue>
 *        type of the items on the right hand side of the {@link BinaryRelation}
 * 
 * @author Igor Akkerman
 */
public class HashAddRemoveBinaryRelation<LeftValue, RightValue>
extends HashAddBinaryRelation<LeftValue, RightValue>
implements RemoveBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new initially empty {@link HashAddRemoveBinaryRelation}.
     */
    public HashAddRemoveBinaryRelation() {
        super();
    }

    /**
     * Creates a new {@link HashAddRemoveBinaryRelation} containing the
     * {@link Association} items contained by the specified {@link Container}.
     * 
     * @param associations
     *        Container of the Associations to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violate the rules of this
     *         {@link HashAddRemoveBinaryRelation}
     */
    public HashAddRemoveBinaryRelation(final Container<Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new {@link HashAddRemoveBinaryRelation} containing the
     * {@link Association} items contained by the specified {@link Collection}.
     * 
     * @param associations
     *        {@link Collection} of {@link Association} items to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violate the rules of this
     *         {@link HashAddRemoveBinaryRelation}
     */
    public HashAddRemoveBinaryRelation(final Collection<Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddRemoveBinaryRelation containing the
     * {@link Association} items specified in a comma separated sequence.
     * 
     * @param associations
     *        comma separated sequence of the {@link Association} items to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violate the rules of this
     *         {@link HashAddRemoveBinaryRelation}
     */
    public HashAddRemoveBinaryRelation(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws IllegalAssociationException {
        super(associations);
    }

    // overridden to be made public
    @Override
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws IllegalAssociationException {
        super.associate(leftValue, rightValue);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue) {
        leftToRightMap.get(leftValue).remove(rightValue);
        rightToLeftMap.get(rightValue).remove(leftValue);
    }

    @Override
    public void remove(final Association<LeftValue, RightValue> association) {
        remove(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void removeAll() {
        ContainerUtility.remove(this, this);
    }

    @Override
    public void remove(final Iterable<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    public void remove(final Container<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    public void remove(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    public void remove(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    public void retain(final Container<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.retain(this, associations);
    }

    @Override
    public void retain(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.retain(this, associations);
    }

    @Override
    public void retain(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        ContainerUtility.retain(this, associations);
    }

    @Override
    public RemoveTraverser<Association<LeftValue, RightValue>> createTraverser() {
        return new DefaultRemoveBinaryRelationTraverser<>(this);
    }
}
