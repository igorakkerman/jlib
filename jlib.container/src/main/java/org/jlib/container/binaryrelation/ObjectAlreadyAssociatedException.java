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
 * Exception thrown when trying to associate an Object with another Object by a
 * BinaryRelation, which allows an Object to be associated with only one other
 * Object, and the first Object is already associated with some third Object by
 * that BinaryRelation.
 * 
 * @author Igor Akkerman
 */
public class ObjectAlreadyAssociatedException
extends IllegalStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5032389345952105941L;

    /** Object already associated with another Object by the BinaryRelation */
    private final Object object;

    /** BinaryRelation that already associates the Object with another Object */
    private final BinaryRelation<?, ?> binaryRelation;

    /**
     * Creates a new ObjectAlreadyAssociatedException for the specified
     * BinaryRelation and the specified Object.
     * 
     * @param binaryRelation
     *        BinaryRelation that already associates the specified Object with
     *        another Object
     * @param object
     *        Object already associated with another Object by
     *        {@code binaryRelation}
     */
    public ObjectAlreadyAssociatedException(BinaryRelation<?, ?> binaryRelation, Object object) {
        super();
        this.binaryRelation = binaryRelation;
        this.object = object;
    }

    /**
     * Creates a new ObjectAlreadyAssociatedException for the specified
     * BinaryRelation and the specified Object.
     * 
     * @param binaryRelation
     *        BinaryRelation that already associates the specified Object with
     *        another Object
     * @param object
     *        Object already associated with another Object by
     *        {@code binaryRelation}
     * @param errorMessage
     *        String containing the error message
     */
    public ObjectAlreadyAssociatedException(BinaryRelation<?, ?> binaryRelation, Object object, String errorMessage) {
        super(errorMessage);
        this.binaryRelation = binaryRelation;
        this.object = object;
    }

    /**
     * Returns the BinaryRelation that already associates the Object with
     * another Object.
     * 
     * @return BinaryRelation that already associates the Object with another
     *         Object
     */
    public BinaryRelation<?,?> getBinaryRelation() {
        return binaryRelation;
    }

    /**
     * Returns the Object already associated with another Object by the
     * BinaryRelation.
     * 
     * @return Object already associated with another Object by the
     *         BinaryRelation
     */
    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return super.toString() + "[" + binaryRelation + object + "]";
    }
}
