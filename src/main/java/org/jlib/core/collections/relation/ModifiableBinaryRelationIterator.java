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

package org.jlib.core.collections.relation;

import java.util.NoSuchElementException;

/**
 * Iterator over the Associations of a ModifiableBinaryRelation.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the binaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the binaryRelation
 * @author Igor Akkerman
 */
public class ModifiableBinaryRelationIterator<LeftObject, RightObject>
extends BinaryRelationIterator<LeftObject, RightObject> {

    /** ModifiableBinaryRelation traversed by this Iterator  */
    private ModifiableBinaryRelation<LeftObject, RightObject> binaryRelation;
    
    /** last Element returned by this Iterator */
    private Association<LeftObject, RightObject> lastElementReturned = null;
    
    
    /**
     * Creates a new ModifiableBinaryRelationIterator.
     * 
     * @param binaryRelation
     *        ModifiableBinaryRelation traversed by this Iterator
     */
    protected ModifiableBinaryRelationIterator(ModifiableBinaryRelation<LeftObject, RightObject> binaryRelation) {
        super(binaryRelation);
        this.binaryRelation = binaryRelation;
    }
    
    // @see org.jlib.core.collections.relation.BinaryRelationIterator#next()
    @Override
    public Association<LeftObject, RightObject> next()
    throws NoSuchElementException {
        lastElementReturned = super.next();
        return lastElementReturned;
    }
    
    // @see org.jlib.core.collections.relation.BinaryRelationIterator#remove()
    @Override
    public void remove() {
        if (lastElementReturned == null)
            throw new IllegalStateException();
        binaryRelation.remove(lastElementReturned);
        lastElementReturned = null;
    }
}
