package org.jlib.core.operator;

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
     * plus operation (addition) on Integers (first argument plus second
     * argument)
     */
    public static final BinaryOperator<Integer, Integer, Integer> INTEGER_PLUS = new BinaryOperator<Integer, Integer, Integer>() {

        public Integer operate(Integer firstArgument, Integer secondArgument) {
            return firstArgument + secondArgument;
        }
    };

    /**
     * minus operation (subtraction) on Integers (first argument minus second
     * argument)
     */
    public static final BinaryOperator<Integer, Integer, Integer> INTEGER_MINUS = new BinaryOperator<Integer, Integer, Integer>() {

        public Integer operate(Integer firstArgument, Integer secondArgument) {
            return firstArgument - secondArgument;
        }
    };

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
