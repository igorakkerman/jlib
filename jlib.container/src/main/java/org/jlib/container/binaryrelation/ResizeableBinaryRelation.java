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

/**
 * BinaryRelation allowing the addition and removal of associations.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the BinaryRelation
 *        
 * @param <RightValue>
 *        type of the objects on the right hand side of the BinaryRelation
 *        
 * @author Igor Akkerman
 */
public interface AddBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue>, AddContainer<Association<LeftValue, RightValue>> {

    /**
     * Associates the specified LeftValue with the specified RightValue in
     * this BinaryRelation.
     * 
     * @param leftValue
     *        LeftValue of the association
     *        
     * @param rightValue
     *        RightValue of the association
     *        
     * @throws ObjectAlreadyAssociatedException
     *         if {@code leftValue} or {@code rightValue} is already
     *         associated to another Object and the implementation doesn't allow
     *         an Object to have more than one association
     */
    public void add(LeftValue leftValue, RightValue rightValue)
    throws ObjectAlreadyAssociatedException;

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
