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
 * @param <LeftValue>
 *        type of the objects on the left hand side of the Bijection
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the Bijection
 * 
 * @author Igor Akkerman
 */
public interface Bijection<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue> {

    /**
     * Returns the RightValue associated with the specified LeftValue by this
     * Bijection.
     * 
     * @param leftValue
     *        LeftValue associated with the RightValue to return
     *        
     * @return RightValue associated with {@code leftValue}
     * 
     * @throws NoSuchElementException
     *         if no RightValue is associated with {@code leftValue}
     */
    public RightValue right(LeftValue leftValue)
    throws NoSuchElementException;

    /**
     * Returns the LeftValue associated with the specified RightValue by this
     * Bijection.
     * 
     * @param rightValue
     *        RightValue associated with the LeftValue to return
     *        
     * @return LeftValue associated with {@code rightValue}
     * 
     * @throws NoSuchElementException
     *         if no LeftValue is associated with {@code rightValue}
     */
    public LeftValue left(RightValue rightValue)
    throws NoSuchElementException;
}
