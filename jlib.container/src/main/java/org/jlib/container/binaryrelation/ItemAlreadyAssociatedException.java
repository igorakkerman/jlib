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
public class ItemAlreadyAssociatedException
extends IllegalBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -7959565629107248727L;

    /** Item already associated with another Item by the BinaryRelation */
    private final Object item;

    /** BinaryRelation that already associates the Item with another Item */
    private final BinaryRelation<?, ?> binaryRelation;

    /**
     * Creates a new {@link ItemAlreadyAssociatedException} for the specified
     * {@link BinaryRelation} and the specified Item.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param item
     *        already associated Item
     */
    public ItemAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object item) {
        super(binaryRelation, "{1}: {2}", item);

        this.binaryRelation = binaryRelation;
        this.item = item;
    }

    /**
     * Returns the {@link BinaryRelation} that already associates the Item with
     * another Item.
     * 
     * @return referenced {@link BinaryRelation}
     */
    public BinaryRelation<?, ?> getBinaryRelation() {
        return binaryRelation;
    }

    /**
     * Returns the Item already associated with another Item by the
     * {@link BinaryRelation}.
     * 
     * @return already associated Item
     */
    public Object getItem() {
        return item;
    }
}
