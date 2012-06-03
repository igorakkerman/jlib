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
 * Association in a BinaryRelation.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the BinaryRelation
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the BinaryRelation
 * 
 * @author Igor Akkerman
 */
public class Association<LeftValue, RightValue> {

    /** LeftValue of this Association */
    private final LeftValue leftValue;

    /** RightValue of this Association */
    private final RightValue rightValue;

    /**
     * Creates a new Association.
     * 
     * @param leftValue
     *        LeftValue of this Association
     * 
     * @param rightValue
     *        RightValue of this Association
     */
    public Association(final LeftValue leftValue, final RightValue rightValue) {
        super();

        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /**
     * Returns the object on the left hand side of this Association.
     * 
     * @return LeftValue of this Association
     */
    public LeftValue getLeftValue() {
        return leftValue;
    }

    /**
     * Returns the object on the right hand side of this Association.
     * 
     * @return RightValue of this Association
     */
    public RightValue getRightValue() {
        return rightValue;
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (!(otherObject instanceof Association<?, ?>))
            return false;

        final Association<?, ?> otherAssociation = (Association<?, ?>) otherObject;

        return leftValue.equals(otherAssociation.getLeftValue()) && rightValue.equals(otherAssociation.getRightValue());
    }

    @Override
    public int hashCode() {
        return leftValue.hashCode() * 2 + rightValue.hashCode();
    }
}
