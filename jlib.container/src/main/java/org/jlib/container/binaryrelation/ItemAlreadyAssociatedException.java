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
 * Exception thrown when trying to associate an Item with another Item by a
 * {@link BinaryRelation} which allows an Item to be associated with only one
 * other Item, and the first Item is already associated with some third Item.
 * 
 * @author Igor Akkerman
 */
public abstract class ItemAlreadyAssociatedException
extends IllegalAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = -7959565629107248727L;

    /**
     * Creates a new {@link ItemAlreadyAssociatedException}.
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
    public ItemAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                          final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
