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
 * Commutative BinaryOperator. Tagging interface to indicate that a
 * BinaryOperator is commutative.
 * 
 * @author Igor Akkerman
 * 
 * @param <Argument>
 *        type of the arguments 
 */
public interface CommutativeBinaryOperator<Argument>
extends BinaryOperator<Argument, Argument, Argument> {
    // intentionally left blank
}
