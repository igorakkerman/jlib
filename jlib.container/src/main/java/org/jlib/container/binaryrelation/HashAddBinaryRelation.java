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
public class HashAddBinaryRelation<LeftValue, RightValue>
extends HashBinaryRelation<LeftValue, RightValue>
implements AddBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new initially empty {@link HashAddBinaryRelation}.
     */
    public HashAddBinaryRelation() {
        super();
    }

    /**
     * Creates a new {@link HashAddBinaryRelation} containing the
     * {@link Association} items contained by the specified {@link Container}.
     * 
     * @param associations
     *        Container of the Associations to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violates the rules of this
     *         {@link HashAddBinaryRelation}
     */
    public HashAddBinaryRelation(final Container<Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new {@link HashAddBinaryRelation} containing the
     * {@link Association} items contained by the specified {@link Collection}.
     * 
     * @param associations
     *        {@link Collection} of {@link Association} items to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violates the rules of this
     *         {@link HashAddBinaryRelation}
     */
    public HashAddBinaryRelation(final Collection<Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new {@link HashAddBinaryRelation} containing the
     * {@link Association} items specified in a comma separated sequence.
     * 
     * @param associations
     *        comma separated sequence of the {@link Association} items to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violates the rules of this
     *         {@link HashAddBinaryRelation}
     */
    public HashAddBinaryRelation(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
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
    public void addAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.addAll(this, associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        ContainerUtility.addAll(this, associations);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association) {
        associate(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void addAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        ContainerUtility.addAll(this, associations);
    }
}
