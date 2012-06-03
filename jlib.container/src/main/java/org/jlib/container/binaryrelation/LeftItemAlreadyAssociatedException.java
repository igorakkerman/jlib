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
 * {@link ItemAlreadyAssociatedException} for a LeftItem.
 * 
 * @author Igor Akkerman
 */
public class LeftItemAlreadyAssociatedException
extends ItemAlreadyAssociatedException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7999182498569902948L;

    /**
     * Creates a new {@link LeftItemAlreadyAssociatedException} for the
     * specified {@link BinaryRelation} and the specified {@link Association}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param leftValue
     *        already associated LeftValue
     * 
     * @param rightValue
     *        RightValue to which {@code leftValue} cannot be associated
     */
    public LeftItemAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                              final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
