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

import org.jlib.container.binaryrelation.AddBinaryRelation;
import org.jlib.container.binaryrelation.Association;
import org.jlib.container.binaryrelation.AssociationAlreadyExistsException;
import org.jlib.container.binaryrelation.IllegalAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;

/**
 * Bijection allowing to add new {@link Association} items.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 * 
 * @author Igor Akkerman
 */
public interface AddBijection<LeftValue, RightValue>
extends Bijection<LeftValue, RightValue>, AddBinaryRelation<LeftValue, RightValue> {

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection}.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws AssociationAlreadyExistsException
     *         if the specified {@link Association} already exists
     * 
     * @throws LeftValueAlreadyAssociatedException
     *         if {@code leftValue} is already associated to another RightValue
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if {@code rightValue} is already associated to another LeftValue
     * 
     * @throws IllegalAssociationException
     *         if some property of the {@link Association} prevents it from
     *         being added
     */
    @Override
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws AssociationAlreadyExistsException, LeftValueAlreadyAssociatedException,
    RightValueAlreadyAssociatedException, IllegalAssociationException;

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection}.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws LeftValueAlreadyAssociatedException
     *         if {@code leftValue} is already associated to another RightValue;
     *         if the {@link Association} is equal to another
     *         {@link Association} in this {@link AddBijection}, it is ignored
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if {@code rightValue} is already associated to another LeftValue;
     *         if the {@link Association} is equal to another
     *         {@link Association} in this {@link AddBijection}, it is ignored
     * 
     * @throws IllegalAssociationException
     *         if some property of the {@link Association} prevents it from
     *         being added
     */
    @Override
    public void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException;
}
