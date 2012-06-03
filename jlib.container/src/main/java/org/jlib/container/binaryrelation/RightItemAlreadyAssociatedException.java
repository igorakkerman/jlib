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
public class RightItemAlreadyAssociatedException
extends ItemAlreadyAssociatedException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2749156159604433283L;

    /**
     * Creates a new {@link RightItemAlreadyAssociatedException} for the
     * specified {@link BinaryRelation} and the specified Item.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param item
     *        already associated Item
     */
    public RightItemAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object item) {
        super(binaryRelation, item);
    }
}
