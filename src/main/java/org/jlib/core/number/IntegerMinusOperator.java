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
 * BinaryOperator on Integers performing the <i>minus</i> operation.
 * 
 * @author Igor Akkerman
 */
public class IntegerMinusOperator
implements BinaryOperator<Integer, Integer, Integer> {

    /** no visible constructor */
    IntegerMinusOperator() {}
    
    /**
     * Performs the <i>minus</i> operation on the arguments.
     * 
     * @param leftArgument
     *        {@inheritDoc}
     * @param rightArgument
     *        {@inheritDoc}
     *        
     * @return the result of {@code leftArgument} minus {@code rightArgument}
     */
    @Override
    public Integer operate(Integer leftArgument, Integer rightArgument) {
        return leftArgument - rightArgument;
    }
}
