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

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator over the Associations of a BinaryRelation.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the binaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the binaryRelation
 * @author Igor Akkerman
 */
class BinaryRelationIterator<LeftObject, RightObject>
implements Iterator<Association<LeftObject, RightObject>> {

    /** BinaryRelation traversed by this Iterator */
    private final BinaryRelation<LeftObject, RightObject> binaryRelation;

    /**
     * Iterator over the LeftObjects of the BinaryRelation traversed by this
     * Iterator
     */
    private Iterator<LeftObject> leftObjectsIterator;

    /**
     * Iterator over the RightObjects of the BinaryRelation traversed by this
     * Iterator
     */
    private Iterator<RightObject> rightObjectsIterator;

    /** current LeftObject */
    private LeftObject leftObject;

    /**
     * Creates a new BinaryRelationIterator.
     * 
     * @param binaryRelation
     *        BinaryRelation traversed by this Iterator
     */
    protected BinaryRelationIterator(BinaryRelation<LeftObject, RightObject> binaryRelation) {
        super();
        this.binaryRelation = binaryRelation;
        leftObjectsIterator = binaryRelation.leftObjects().iterator();
        if (leftObjectsIterator.hasNext())
            getNextLeftObject();
        else
            rightObjectsIterator = new HashSet<RightObject>().iterator();
    }

    /**
     * Retrieves the next LeftObject.
     */
    private void getNextLeftObject() {
        leftObject = leftObjectsIterator.next();
        rightObjectsIterator = binaryRelation.rightSet(leftObject).iterator();
    }

    // @see java.util.Iterator#hasNext()
    @Override
    public boolean hasNext() {
        if (rightObjectsIterator.hasNext())
            return true;

        if (!leftObjectsIterator.hasNext())
            return false;

        getNextLeftObject();

        return true;
    }

    // @see java.util.Iterator#next()
    @Override
    public Association<LeftObject, RightObject> next()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        return new Association<LeftObject, RightObject>(leftObject, rightObjectsIterator.next());
    }

    // @see java.util.Iterator#remove()
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
