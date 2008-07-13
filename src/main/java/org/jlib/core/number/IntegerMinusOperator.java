package org.jlib.core.number;

import org.jlib.core.operator.BinaryOperator;

/**
 * BinaryOperator on Integers performing the <i>minus</i> operation.
 * 
 * @author Igor Akkerman
 */
public class IntegerMinusOperator
implements BinaryOperator<Integer, Integer, Integer> {

    /**
     * Performs the <i>minus</i> operation on the arguments.
     * 
     * @param leftArgument
     *        {@inheritDoc}
     * @param rightArgument
     *        {@inheritDoc}
     * @return the result of {@code leftArgument} minus {@code rightArgument}
     */
    @Override
    public Integer operate(Integer leftArgument, Integer rightArgument) {
        return leftArgument - rightArgument;
    }
}
