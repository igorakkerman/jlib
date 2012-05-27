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

import org.jlib.core.operator.AssociativeBinaryOperator;
import org.jlib.core.operator.BinaryOperator;
import org.jlib.core.operator.CommutativeBinaryOperator;
import org.jlib.core.operator.IdentityItemBinaryOperator;

/**
 * BinaryOperator on Integers performing the <i>plus</i> operation.
 * 
 * @author Igor Akkerman
 */
public class IntegerPlusOperator
implements BinaryOperator<Integer, Integer, Integer>, AssociativeBinaryOperator<Integer>,
CommutativeBinaryOperator<Integer>, IdentityItemBinaryOperator<Integer> {

    /** no visible constructor */
    IntegerPlusOperator() {}

    /**
     * Performs the <i>plus</i> operation on the arguments.
     * 
     * @param leftArgument
     *        {@inheritDoc}
     * @param rightArgument
     *        {@inheritDoc}
     * 
     * @return the result of {@code leftArgument} plus {@code rightArgument}
     */
    @Override
    public Integer operate(Integer leftArgument, Integer rightArgument) {
        return leftArgument + rightArgument;
    }

    @Override
    public Integer identityItem() {
        return 0;
    }
}
