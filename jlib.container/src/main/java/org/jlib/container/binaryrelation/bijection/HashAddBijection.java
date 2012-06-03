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
import org.jlib.container.binaryrelation.IllegalAssociationException;
import org.jlib.container.binaryrelation.LeftItemAlreadyAssociatedException;
import org.jlib.container.binaryrelation.RightItemAlreadyAssociatedException;

/**
 * {@link HashBijection} allowing the addition of new {@link Association} items.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the {@link Bijection}
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the {@link Bijection}
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
     * @throws LeftItemAlreadyAssociatedException
     *         if the LeftItem of one Item in {@code associations} is already
     *         associated to another RightItem; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws RightItemAlreadyAssociatedException
     *         if the RightItem of one Item in {@code associations} is already
     *         associated to another LeftItem; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAddBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * 
     * @throws LeftItemAlreadyAssociatedException
     *         if the LeftItem of one Item in {@code associations} is already
     *         associated to another RightItem; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws RightItemAlreadyAssociatedException
     *         if the RightItem of one Item in {@code associations} is already
     *         associated to another LeftItem; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAddBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations specified in a
     * comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     * 
     * @throws LeftItemAlreadyAssociatedException
     *         if the LeftItem of one Item in {@code associations} is already
     *         associated to another RightItem; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws RightItemAlreadyAssociatedException
     *         if the RightItem of one Item in {@code associations} is already
     *         associated to another LeftItem; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAddBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    @Override
    // raising visibility from protected to public
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        super.associate(leftValue, rightValue);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association) {
        associate(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void addAll(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.addAll(this, associations);
    }

    @Override
    public void addAll(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.addAll(this, associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws LeftItemAlreadyAssociatedException, RightItemAlreadyAssociatedException, IllegalAssociationException {
        ContainerUtility.addAll(this, associations);
    }
}
