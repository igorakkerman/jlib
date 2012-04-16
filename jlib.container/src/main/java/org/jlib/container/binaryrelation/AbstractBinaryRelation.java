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

import java.util.Iterator;

import org.jlib.container.AbstractContainer;

/**
 * Skeletal implementation of a BinaryRelation.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightValue>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public abstract class AbstractBinaryRelation<LeftValue, RightValue>
extends AbstractContainer<Association<LeftValue, RightValue>>
implements BinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new AbstractBinaryRelation.
     */
    protected AbstractBinaryRelation() {
        super();
    }

    @Override
    public Iterator<Association<LeftValue, RightValue>> iterator() {
        return new BinaryRelationIterator<LeftValue, RightValue>(this);
    }

    @Override
    public boolean contains(LeftValue leftValue, RightValue rightValue) {
        return hasLeft(leftValue) && rightSet(leftValue).contains(rightValue);
    }

    @Override
    public boolean contains(Association<LeftValue, RightValue> association) {
        return contains(association.left(), association.right());
    }
}
