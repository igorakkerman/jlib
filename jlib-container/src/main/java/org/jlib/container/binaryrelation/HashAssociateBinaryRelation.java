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
import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link AssociateBinaryRelation} implemented using hashing for left and right
 * hand side items.
 * 
 * @param <LeftValue>
 *        type of the items on the left hand side of the {@link BinaryRelation}
 * 
 * @param <RightValue>
 *        type of the items on the right hand side of the {@link BinaryRelation}
 * 
 * @author Igor Akkerman
 */
public class HashAssociateBinaryRelation<LeftValue, RightValue>
extends HashBinaryRelation<LeftValue, RightValue>
implements AssociateBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new initially empty {@link HashAssociateBinaryRelation}.
     */
    public HashAssociateBinaryRelation() {
        super();
    }

    /**
     * Creates a new {@link HashAssociateBinaryRelation} containing the
     * {@link Association} items contained by the specified {@link Container}.
     * 
     * @param associations
     *        Container of the Associations to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violates the rules of this
     *         {@link HashAssociateBinaryRelation}
     */
    public HashAssociateBinaryRelation(final Container<Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new {@link HashAssociateBinaryRelation} containing the
     * {@link Association} items contained by the specified {@link Collection}.
     * 
     * @param associations
     *        {@link Collection} of {@link Association} items to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violates the rules of this
     *         {@link HashAssociateBinaryRelation}
     */
    public HashAssociateBinaryRelation(final Collection<Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new {@link HashAssociateBinaryRelation} containing the
     * {@link Association} items specified in a comma separated sequence.
     * 
     * @param associations
     *        comma separated sequence of the {@link Association} items to add
     * 
     * @throws IllegalAssociationException
     *         if {@code associations} violates the rules of this
     *         {@link HashAssociateBinaryRelation}
     */
    @SuppressWarnings("unchecked")
    public HashAssociateBinaryRelation(final Association<LeftValue, RightValue>... associations)
    throws IllegalAssociationException {
        super(associations);
    }

    @Override
    // raising visibility from protected to public
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws IllegalAssociationException {
        super.associate(leftValue, rightValue);
    }

    @Override
    // raising visibility from protected to public
    public void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws IllegalAssociationException {
        super.assertAssociated(leftValue, rightValue);
    }

    @Override
    public void associate(final Association<LeftValue, RightValue> association)
    throws IllegalAssociationException {
        associate(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void associate(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalContainerArgumentException {
        BinaryRelationUtility.associate(this, associations);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void associate(final Association<LeftValue, RightValue>... associations)
    throws IllegalAssociationException {
        BinaryRelationUtility.associate(this, associations);
    }

    @Override
    public void associate(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        BinaryRelationUtility.associate(this, associations);
    }

    @Override
    public void assertContained(final Association<LeftValue, RightValue> association)
    throws IllegalAssociationException {
        assertAssociated(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void assertContained(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {
        BinaryRelationUtility.assertContained(this, associations);
    }

    @Override
    public void assertContained(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException {}

    @Override
    @SuppressWarnings("unchecked")
    public void assertContained(final Association<LeftValue, RightValue>... associations)
    throws IllegalAssociationException {
        BinaryRelationUtility.assertContained(this, associations);
    }
}
