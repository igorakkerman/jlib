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

import org.jlib.core.collections.ModifiableCollection;

/**
 * BinaryRelation allowing the addition and removal of associations.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public interface ModifiableBinaryRelation<LeftObject, RightObject>
extends BinaryRelation<LeftObject, RightObject>, ModifiableCollection<Association<LeftObject, RightObject>> {

    /**
     * Associates the specified LeftObject with the specified RightObject in
     * this BinaryRelation.
     * 
     * @param leftObject
     *        LeftObject of the association
     * @param rightObject
     *        RightObject of the association
     * @return {@code true} if this Bijection has been modified by this
     *         operation, that is, if {@code leftObject} has been associated
     *         with {@code rightObject} by this Bijection; {@code false}
     *         otherwise
     * @throws NullPointerException
     *         if {@code leftObject == null || rightObject == null}
     * @throws ObjectAlreadyAssociatedException
     *         if {@code leftObject} or {@code rightObject} is already
     *         associated to another Object and the implementation doesn't allow
     *         an Object to have more than one association
     */
    public boolean add(LeftObject leftObject, RightObject rightObject)
    throws NullPointerException, ObjectAlreadyAssociatedException;

    /**
     * Removes the association specified by its LeftObject and RightObject from
     * this BinaryRelation.
     * 
     * @param leftObject
     *        LeftObject of the association
     * @param rightObject
     *        RightObject of the association
     * @return {@code true} if this Bijection has been modified by this
     *         operation, that is, if {@code leftObject} has not been associated
     *         with {@code rightObject} by this Bijection; {@code false}
     *         otherwise
     */
    public boolean remove(LeftObject leftObject, RightObject rightObject);
}
