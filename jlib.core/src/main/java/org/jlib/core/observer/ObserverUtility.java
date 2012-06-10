package org.jlib.core.observer;

/**
 * Utility for the observer pattern.
 * 
 * @author Igor Akkerman
 */
public final class ObserverUtility {

    /** no visible constructor */
    private ObserverUtility() {}

    /**
     * Operates on the specified ArgumentValue using the specified
     * {@link ArgumentReturnValueOperator}.
     * 
     * @param <ArgumentValue>
     *        type of the argument value
     * 
     * @param <ReturnValue>
     *        type of the return value
     * 
     * @param operator
     *        {@link ArgumentReturnValueOperator} performing the operation
     * 
     * @param argumentValue
     *        ArgumentValue operated on
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @return ReturnValue of the operation
     * 
     * @throws RuntimeException
     *         <ul>
     *         <li>if {@code operator} throws an {@link OperatorException} with
     *         this {@link RuntimeException} as its cause</li>
     *         <li>if {@code operator} throws this {@link RuntimeException}</li>
     *         <li>if a {@link ValueObserver} in {@code observers} throws this
     *         {@link RuntimeException}</li>
     *         </ul>
     */
    @SafeVarargs
    public static <ArgumentValue, ReturnValue> ReturnValue operate(final ArgumentReturnValueOperator<ArgumentValue, ReturnValue> operator,
                                                                   final ArgumentValue argumentValue,
                                                                   final ValueObserver<ArgumentValue>... observers)
    throws RuntimeException {
        try {
            for (final ValueObserver<ArgumentValue> observer : observers)
                observer.handleBefore(argumentValue);

            final ReturnValue returnValue = operator.operate(argumentValue);

            for (final ValueObserver<ArgumentValue> observer : observers)
                observer.handleAfterSuccess(argumentValue);

            return returnValue;
        }
        catch (final OperatorException exception) {
            // if "legal" excption is thrown
            for (final ValueObserver<ArgumentValue> observer : observers)
                observer.handleAfterFailure(argumentValue, exception);

            throw exception.getCause();
        }
    }

    /**
     * Operates on the specified Value using the specified {@link ValueOperator}
     * .
     * 
     * @param <Value>
     *        type of the value
     * 
     * @param operator
     *        {@link ValueOperator} performing the operation
     * 
     * @param value
     *        Value operated on
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws RuntimeException
     *         <ul>
     *         <li>if {@code operator} throws an {@link OperatorException} with
     *         this {@link RuntimeException} as its cause</li>
     *         <li>if {@code operator} throws this {@link RuntimeException}</li>
     *         <li>if a {@link ValueObserver} in {@code observers} throws this
     *         {@link RuntimeException}</li>
     *         </ul>
     */
    @SafeVarargs
    public static <Value> void operate(final ValueOperator<Value> operator, final Value value,
                                       final ValueObserver<Value>... observers)
    throws RuntimeException {
        operate(new ArgumentReturnValueOperator<Value, Void>() {

            @Override
            public Void operate(final Value argumentValue)
            throws OperatorException, RuntimeException {
                operator.operate(argumentValue);

                return null;
            }

        }, value, observers);
    }
}
