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
     * {@inheritDoc}
     * 
     * @throws LeftValueAlreadyAssociatedException
     *         if {@code leftValue} is already associated
     * 
     * @throws RightValueAlreadyAssociatedException
     *         if {@code rightValue} is already associated
     * 
     * @throws IllegalAssociationException
     *         if some property of the specified {@link Association} prevents it
     *         from being added
     */
    @Override
    public void associate(LeftValue leftValue, RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException;
}
