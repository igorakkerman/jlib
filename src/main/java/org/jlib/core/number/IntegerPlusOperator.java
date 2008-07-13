package org.jlib.core.number;

import org.jlib.core.operator.BinaryOperator;

/**
 * BinaryOperator on Integers performing the <i>plus</i> operation.
 * 
 * @author Igor Akkerman
 */
public class IntegerPlusOperator
implements BinaryOperator<Integer, Integer, Integer> {

    /**
     * Performs the <i>plus</i> operation on the arguments.
     * 
     * @param leftArgument
     *        {@inheritDoc}
     * @param rightArgument
     *        {@inheritDoc}
     * @return the result of {@code leftArgument} plus {@code rightArgument}
     */
    @Override
    public Integer operate(Integer leftArgument, Integer rightArgument) {
        return leftArgument + rightArgument;
    }
}
