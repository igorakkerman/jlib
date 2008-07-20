package org.jlib.core.operators;

/**
 * Binary function operating on two arguments and returning a result.
 * 
 * @param <FirstArgument>
 *        type of the first argument
 * @param <SecondArgument>
 *        type of the second argument
 * @param <Result>
 *        type of the result
 * @author Igor Akkerman
 */
public interface BinaryOperator<FirstArgument, SecondArgument, Result> {

    /**
     * Performs the operation of this BinaryOperator on the specified arguments.
     * 
     * @param firstArgument
     *        left argument to operate on
     * @param secondArgument
     *        right argument to operate on
     * @return result of the operation
     */
    public Result operate(FirstArgument firstArgument, SecondArgument secondArgument);
}
