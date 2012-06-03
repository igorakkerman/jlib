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

import org.jlib.container.RemoveContainer;

/**
 * {@link BinaryRelation} allowing the removal of {@link Association} items.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the BinaryRelation
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the BinaryRelation
 * 
 * @author Igor Akkerman
 */
public interface RemoveBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue>, RemoveContainer<Association<LeftValue, RightValue>> {

    /**
     * Removes the {@link Association} specified by its LeftValue and RightValue
     * from this {@link RemoveBinaryRelation}.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws NoSuchAssociationException
     *         if this {@link RemoveBinaryRelation} does not contain the
     *         specified {@link Association}
     */
    public void remove(LeftValue leftValue, RightValue rightValue)
    throws NoSuchAssociationException;
}
