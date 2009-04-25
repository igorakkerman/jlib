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

package org.jlib.core.collections.relation;

/**
 * Association in a BinaryRelation.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public class Association<LeftObject, RightObject> {

    /** LeftObject of this Association */
    private final LeftObject leftObject;

    /** RightObject of this Association */
    private final RightObject rightObject;

    /**
     * Creates a new Association.
     * 
     * @param leftObject
     *        LeftObject of this Association
     * @param rightObject
     *        RightObject of this Association
     */
    public Association(LeftObject leftObject, RightObject rightObject) {
        super();
        this.leftObject = leftObject;
        this.rightObject = rightObject;
    }

    /**
     * Returns the object on the left hand side of this Association.
     * 
     * @return LeftObject of this Association
     */
    public LeftObject left() {
        return leftObject;
    }

    /**
     * Returns the object on the right hand side of this Association.
     * 
     * @return RightObject of this Association
     */
    public RightObject right() {
        return rightObject;
    }

    // @see java.lang.Object#equals(java.lang.Object)
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Association<?, ?>))
            return false;
        Association<?, ?> otherAssociation = (Association<?, ?>) otherObject;
        Object otherLeftObject = otherAssociation.left();
        Object otherRightObject = otherAssociation.right();
        if (leftObject != null && rightObject != null)
            return leftObject.equals(otherLeftObject) && rightObject.equals(otherRightObject);
        if (leftObject != null /* && rightObject == null */)
            return leftObject.equals(otherLeftObject) && otherRightObject == null;
        if (rightObject != null /* && leftObject == null */)
            return rightObject.equals(otherRightObject) && otherLeftObject == null;
        // if (leftObject == rightObject == null)
        return otherLeftObject == null && otherRightObject == null;
    }

    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return (leftObject != null ? leftObject.hashCode() : 0) + (rightObject != null ? rightObject.hashCode() : 0);
    }
}
