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

import java.util.Iterator;

import org.jlib.core.collections.AbstractCollection;

/**
 * Skeletal implementation of a BinaryRelation.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public abstract class AbstractBinaryRelation<LeftObject, RightObject>
extends AbstractCollection<Association<LeftObject, RightObject>>
implements BinaryRelation<LeftObject, RightObject> {

    /**
     * Creates a new AbstractBinaryRelation.
     */
    protected AbstractBinaryRelation() {
        super();
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public Iterator<Association<LeftObject, RightObject>> iterator() {
        return new BinaryRelationIterator<LeftObject, RightObject>(this);
    }
    
    // @see org.jlib.core.collections.relation.BinaryRelation#contains(java.lang.Object, java.lang.Object)
    @Override
    public boolean contains(LeftObject leftObject, RightObject rightObject) {
        return hasLeft(leftObject) && rightSet(leftObject).contains(rightObject);
    }

    // @see org.jlib.core.collections.Collection#contains(java.lang.Object)
    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object object) {
        try {
            // wrong type of the Object (not Association<?, ?>) may cause a ClassCastException here
            Association<LeftObject, RightObject> association = (Association<LeftObject, RightObject>) object;
            // wrong parameter types of the Association Objects may cause a ClassCastException here
            return contains(association.left(), association.right());
        }
        catch (ClassCastException e) {
            return false;
        }
    }
}
