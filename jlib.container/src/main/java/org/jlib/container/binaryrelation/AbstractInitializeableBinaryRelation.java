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

/**
 * Skeletal implementation of a {@link BinaryRelation}.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the
 *        {@link BinaryRelation}
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the
 *        {@link BinaryRelation}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractInitializeableBinaryRelation<LeftValue, RightValue>
extends AbstractBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new {@link AbstractInitializeableBinaryRelation}.
     */
    protected AbstractInitializeableBinaryRelation() {
        super();
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * BinaryRelation.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws IllegalAssociationException
     *         if some property of the specified {@link Association} prevents it
     *         from being added
     */
    protected abstract void associate(LeftValue leftValue, RightValue rightValue)
    throws IllegalAssociationException;
}
