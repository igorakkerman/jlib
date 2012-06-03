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

import org.jlib.container.AddContainer;
import org.jlib.container.binaryrelation.bijection.Bijection;

/**
 * BinaryRelation allowing the addition and removal of associations.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the BinaryRelation
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the BinaryRelation
 * 
 * @author Igor Akkerman
 */
public interface AddBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue>, AddContainer<Association<LeftValue, RightValue>> {

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * BinaryRelation.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws IllegalAssociationException
     *         if some property of the specified {@link Association} prevents it
     *         from being added
     */
    public void associate(LeftValue leftValue, RightValue rightValue)
    throws IllegalAssociationException;

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
     * @throws IllegalAssociationException
     *         if some property of the {@code associations} prevents it from
     *         being added
     */
    public void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws IllegalAssociationException;
}
