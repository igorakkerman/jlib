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
 * BinaryOperator with a neutral element.
 * 
 * @author Igor Akkerman
 * 
 * @param <Value>
 *        type of the values on which the BinaryOperator operates,
 *        that is, type of the arguments and the result of the BinaryOperator
 */
public interface IdentityElementBinaryOperator<Value>
extends BinaryOperator<Value, Value, Value> {

    /**
     * Returns the identity Element of this BinaryOperator.
     * 
     * @return Value representing the identity Element of this
     *         BinaryOperator
     */
    public Value identityElement();
}
