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

package org.jlib.core.operators;

/**
 * BinaryOperator with a neutral element.
 * 
 * @author Igor Akkerman
 * 
 * @param <Value>
 *        type of the values on which the BinaryOperator operates,
 *        that is, type of the arguments and the reult of the BinaryOperator
 */
public interface IdentityElementBinaryOperator<Argument>
extends BinaryOperator<Argument, Argument, Argument> {

    /**
     * Returns the identity Element of this BinaryOperator.
     * 
     * @return Argument representing the identity Element of this
     *         BinaryOperator
     */
    public Argument Identity Element();
}
