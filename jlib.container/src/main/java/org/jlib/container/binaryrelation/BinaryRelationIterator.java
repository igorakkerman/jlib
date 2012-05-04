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

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.jlib.core.iterator.AbstractIterator;

/**
 * Iterator over the Associations of a BinaryRelation.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the binaryRelation
 * @param <RightValue>
 *        type of the objects on the right hand side of the binaryRelation
 * @author Igor Akkerman
 */
class BinaryRelationIterator<LeftValue, RightValue>
extends AbstractIterator<Association<LeftValue, RightValue>> {

    /** BinaryRelation traversed by this Iterator */
    private final BinaryRelation<LeftValue, RightValue> binaryRelation;

    /**
     * Iterator over the LeftValues of the BinaryRelation traversed by this
     * Iterator
     */
    private final Iterator<LeftValue> leftValuesIterator;

    /**
     * Iterator over the RightValues of the BinaryRelation traversed by this
     * Iterator
     */
    private Iterator<RightValue> rightValuesIterator;

    /** current LeftValue */
    private LeftValue leftValue;

    /**
     * Creates a new BinaryRelationIterator.
     * 
     * @param binaryRelation
     *        BinaryRelation traversed by this Iterator
     */
    protected BinaryRelationIterator(final BinaryRelation<LeftValue, RightValue> binaryRelation) {
        super();
        this.binaryRelation = binaryRelation;
        leftValuesIterator = binaryRelation.leftValues().iterator();
        if (leftValuesIterator.hasNext())
            getNextLeftValue();
        else
            rightValuesIterator = new HashSet<RightValue>().iterator();
    }

    /**
     * Retrieves the next LeftValue.
     */
    private void getNextLeftValue() {
        leftValue = leftValuesIterator.next();
        rightValuesIterator = binaryRelation.rightSet(leftValue).iterator();
    }

    @Override
    public boolean hasNext() {
        if (rightValuesIterator.hasNext())
            return true;

        if (!leftValuesIterator.hasNext())
            return false;

        getNextLeftValue();

        return true;
    }

    @Override
    public Association<LeftValue, RightValue> next()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        return new Association<LeftValue, RightValue>(leftValue, rightValuesIterator.next());
    }
}
