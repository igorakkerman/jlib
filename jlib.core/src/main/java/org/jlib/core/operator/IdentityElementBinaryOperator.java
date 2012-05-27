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

package org.jlib.core.operator;

/**
 * BinaryOperator with a neutral item.
 * 
 * @author Igor Akkerman
 * 
 * @param <Value>
 *        type of the values on which the BinaryOperator operates,
 *        that is, type of the arguments and the result of the BinaryOperator
 */
public interface IdentityItemBinaryOperator<Value>
extends BinaryOperator<Value, Value, Value> {

    /**
     * Returns the identity Item of this BinaryOperator.
     * 
     * @return Value representing the identity Item of this
     *         BinaryOperator
     */
    public Value identityItem();
}
