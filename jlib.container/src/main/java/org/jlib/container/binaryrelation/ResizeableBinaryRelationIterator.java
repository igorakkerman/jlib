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

import java.util.NoSuchElementException;

/**
 * Iterator over the Associations of a AddBinaryRelation.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the binaryRelation
 * @param <RightValue>
 *        type of the objects on the right hand side of the binaryRelation
 * @author Igor Akkerman
 */
public class AddBinaryRelationIterator<LeftValue, RightValue>
extends BinaryRelationIterator<LeftValue, RightValue> {

    /** AddBinaryRelation traversed by this Iterator  */
    private AddBinaryRelation<LeftValue, RightValue> binaryRelation;
    
    /** last Element returned by this Iterator */
    private Association<LeftValue, RightValue> lastElementReturned = null;
    
    
    /**
     * Creates a new AddBinaryRelationIterator.
     * 
     * @param binaryRelation
     *        AddBinaryRelation traversed by this Iterator
     */
    protected AddBinaryRelationIterator(AddBinaryRelation<LeftValue, RightValue> binaryRelation) {
        super(binaryRelation);
        this.binaryRelation = binaryRelation;
    }
    
    @Override
    public Association<LeftValue, RightValue> next()
    throws NoSuchElementException {
        lastElementReturned = super.next();
        return lastElementReturned;
    }
    
    @Override
    public void remove() {
        if (lastElementReturned == null)
            throw new IllegalStateException();
        binaryRelation.remove(lastElementReturned);
        lastElementReturned = null;
    }
}
