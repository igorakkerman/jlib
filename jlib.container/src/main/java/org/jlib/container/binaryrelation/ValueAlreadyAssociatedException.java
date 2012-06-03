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
 * Exception thrown when trying to associate a value with another value by a
 * {@link BinaryRelation} which allows a value to be associated with only one
 * other value, and the first value is already associated with some third value.
 * 
 * @author Igor Akkerman
 */
public abstract class ValueAlreadyAssociatedException
extends IllegalAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = -6309445418086228661L;

    /**
     * Creates a new {@link ValueAlreadyAssociatedException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param leftValue
     *        LeftValue of the illegal {@link Association}
     * 
     * @param rightValue
     *        RightValue of the illegal {@link Association}
     */
    public ValueAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                           final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
