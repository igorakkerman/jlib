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
 * BinaryRelation allowing the removal of {@link Association} instances.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the BinaryRelation
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the BinaryRelation
 * 
 * @author Igor Akkerman
 */
public interface RemoveBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue>, RemoveContainer<Association<LeftValue, RightValue>> {

    /**
     * Removes the association specified by its LeftValue and RightValue from
     * this BinaryRelation.
     * 
     * @param leftValue
     *        LeftValue of the association
     * 
     * @param rightValue
     *        RightValue of the association
     */
    public void remove(LeftValue leftValue, RightValue rightValue);
}
