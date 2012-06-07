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
import org.jlib.container.binaryrelation.DefaultRemoveBinaryRelationTraverser;
import org.jlib.container.binaryrelation.IllegalAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.NoSuchAssociationException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * {@link HashAssociateBijection} allowing the removal of {@link Association}
 * items.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 * 
 * @author Igor Akkerman
 */
public class HashAssociateRemoveBijection<LeftValue, RightValue>
extends HashAssociateBijection<LeftValue, RightValue>
implements RemoveBijection<LeftValue, RightValue> {

    /** Creates a new initially empty HashAddBijection. */
    public HashAssociateRemoveBijection() {
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
     *         {@link HashAssociateBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAssociateRemoveBijection(final Container<Association<LeftValue, RightValue>> associations)
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
     *         {@link HashAssociateBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAssociateRemoveBijection(final Collection<Association<LeftValue, RightValue>> associations)
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
     *         {@link HashAssociateBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAssociateRemoveBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue)
    throws NoSuchAssociationException {
        leftToRightMap.remove(leftValue);
        rightToLeftMap.remove(rightValue);
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
