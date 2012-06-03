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

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.binaryrelation.Association;
import org.jlib.container.binaryrelation.AssociationAlreadyExistsException;
import org.jlib.container.binaryrelation.IllegalAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;

/**
 * {@link HashBijection} allowing the addition of new {@link Association} items.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 * 
 * @author Igor Akkerman
 */
public class HashAddBijection<LeftValue, RightValue>
extends HashBijection<LeftValue, RightValue>
implements AddBijection<LeftValue, RightValue> {

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
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAddBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * 
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAddBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations specified in a
     * comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     * 
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAddBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    @Override
    // raising visibility from protected to public
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws AssociationAlreadyExistsException, LeftValueAlreadyAssociatedException,
    RightValueAlreadyAssociatedException, IllegalAssociationException {
        super.associate(leftValue, rightValue);
    }

    @Override
    // raising visibility from protected to public
    public void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super.assertAssociated(leftValue, rightValue);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association)
    throws AssociationAlreadyExistsException, LeftValueAlreadyAssociatedException,
    RightValueAlreadyAssociatedException, IllegalAssociationException {
        associate(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void add(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws AssociationAlreadyExistsException, LeftValueAlreadyAssociatedException,
    RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.add(this, associations);
    }

    @Override
    public void add(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws AssociationAlreadyExistsException, LeftValueAlreadyAssociatedException,
    RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.add(this, associations);
    }

    @Override
    public void add(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws AssociationAlreadyExistsException, LeftValueAlreadyAssociatedException,
    RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.add(this, associations);
    }

    @Override
    public void assertContained(final Association<LeftValue, RightValue> association)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.assertContained(this, association);
    }

    @Override
    public void assertContained(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.assertContained(this, associations);
    }

    @Override
    public void assertContained(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.assertContained(this, associations);
    }

    @Override
    public void assertContained(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.assertContained(this, associations);
    }
}
