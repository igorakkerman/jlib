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

import java.util.NoSuchItemException;

/**
 * Traverser over the Associations of a AddBinaryRelation.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the binaryRelation
 * @param <RightValue>
 *        type of the objects on the right hand side of the binaryRelation
 * @author Igor Akkerman
 */
public class AddBinaryRelationTraverser<LeftValue, RightValue>
extends BinaryRelationTraverser<LeftValue, RightValue> {

    /** AddBinaryRelation traversed by this Traverser  */
    private AddBinaryRelation<LeftValue, RightValue> binaryRelation;
    
    /** last Item returned by this Traverser */
    private Association<LeftValue, RightValue> lastItemReturned = null;
    
    
    /**
     * Creates a new AddBinaryRelationTraverser.
     * 
     * @param binaryRelation
     *        AddBinaryRelation traversed by this Traverser
     */
    protected AddBinaryRelationTraverser(AddBinaryRelation<LeftValue, RightValue> binaryRelation) {
        super(binaryRelation);
        this.binaryRelation = binaryRelation;
    }
    
    @Override
    public Association<LeftValue, RightValue> next()
    throws NoSuchItemException {
        lastItemReturned = super.next();
        return lastItemReturned;
    }
    
    @Override
    public void remove() {
        if (lastItemReturned == null)
            throw new IllegalStateException();
        binaryRelation.remove(lastItemReturned);
        lastItemReturned = null;
    }
}
