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

package org.jlib.core.number;

import org.jlib.core.operator.BinaryOperator;

/**
 * Provides a set of {@link BinaryOperator BinaryOperators} on numbers. 
 *
 * @author Igor Akkerman
 */
public final class NumberOperators {

    /** no visible default constructor */
    private NumberOperators() { }
    
    /**
     * BinaryOperator on Integers performing the <i>plus</i> operation
     * (first argument plus second argument).
     */
    public static final IntegerPlusOperator INTEGER_PLUS = new IntegerPlusOperator();

    /**
     * BinaryOperator on Integers performing the <i>minus</i> operation
     * (first argument minus second argument).
     */
    public static final IntegerMinusOperator INTEGER_MINUS = new IntegerMinusOperator();
}
