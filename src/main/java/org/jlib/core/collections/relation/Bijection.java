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

import java.util.NoSuchElementException;

/**
 * One-To-One association of Objects with other Objects. The further Objects are
 * called left hand side objects, the latter right hand side objects. A
 * Bijection does not allow {@code null} as a value for left or right hand side
 * objects. The object comparisons for lookup, retrieval and addition on both
 * sides are accomplished using the {@code equals} and {@code hashCode} methods
 * of the Objects. Note that for equal Objects their {@code hashCode} methods
 * must return the same value.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the Bijection
 * @param <RightObject>
 *        type of the objects on the right hand side of the Bijection
 * @author Igor Akkerman
 */
public interface Bijection<LeftObject, RightObject>
extends BinaryRelation<LeftObject, RightObject> {

    /**
     * Returns the RightObject associated with the specified LeftObject by this
     * Bijection.
     * 
     * @param leftObject
     *        LeftObject associated with the RightObject to return
     * @return RightObject associated with {@code leftObject}
     * @throws NoSuchElementException
     *         if no RightObject is associated with {@code leftObject}
     */
    public RightObject right(LeftObject leftObject)
    throws NoSuchElementException;

    /**
     * Returns the LeftObject associated with the specified RightObject by this
     * Bijection.
     * 
     * @param rightObject
     *        RightObject associated with the LeftObject to return
     * @return LeftObject associated with {@code rightObject}
     * @throws NoSuchElementException
     *         if no LeftObject is associated with {@code rightObject}
     */
    public LeftObject left(RightObject rightObject)
    throws NoSuchElementException;
}
