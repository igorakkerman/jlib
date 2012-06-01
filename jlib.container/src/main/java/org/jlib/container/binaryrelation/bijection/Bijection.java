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

package org.jlib.container.binaryrelation.bijection;

import org.jlib.container.binaryrelation.BinaryRelation;
import org.jlib.container.binaryrelation.NoSuchLeftValueException;
import org.jlib.container.binaryrelation.NoSuchRightValueException;

/**
 * One-To-One association of values with other values. The further values are
 * called left hand side values, the latter right hand side values. The value
 * comparisons for lookup, retrieval and addition on both sides are accomplished
 * using the {@code equals} and {@code hashCode} methods of the Objects.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the Bijection
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the Bijection
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
     * @throws NoSuchLeftValueException
     *         if no RightValue is associated with {@code leftValue}
     */
    public RightValue right(LeftValue leftValue)
    throws NoSuchLeftValueException;

    /**
     * Returns the LeftValue associated with the specified RightValue by this
     * Bijection.
     * 
     * @param rightValue
     *        RightValue associated with the LeftValue to return
     * 
     * @return LeftValue associated with {@code rightValue}
     * 
     * @throws NoSuchRightValueException
     *         if no LeftValue is associated with {@code rightValue}
     */
    public LeftValue left(RightValue rightValue)
    throws NoSuchRightValueException;
}
