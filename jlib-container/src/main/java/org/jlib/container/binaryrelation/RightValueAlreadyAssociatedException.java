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
 * {@link ValueAlreadyAssociatedException} for a LeftValue.
 * 
 * @author Igor Akkerman
 */
public class RightValueAlreadyAssociatedException
extends ValueAlreadyAssociatedException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2805417022226046022L;

    /**
     * Creates a new {@link RightValueAlreadyAssociatedException} for the
     * specified {@link BinaryRelation} and the specified {@link Association}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param leftValue
     *        LeftValue to which {@code rightValue} cannot be associated
     * 
     * @param rightValue
     *        already associated RightValue
     */
    public RightValueAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                               final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
