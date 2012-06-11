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
     * Operates on the specified Value using the specified {@link Operator} .
     * 
     * @param <Value>
     *        type of the value
     * 
     * @param operator
     *        {@link Operator} performing the operation
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
    public static <Value> void operate(final Operator operator, final Value value,
                                       final ValueObserver<Value>... observers)
    throws RuntimeException {
        try {
            for (final ValueObserver<Value> observer : observers)
                observer.handleBefore(value);

            operator.operate();

            for (final ValueObserver<Value> observer : observers)
                observer.handleAfterSuccess(value);
        }
        catch (final OperatorException exception) {
            // if "legal" excption is thrown
            for (final ValueObserver<Value> observer : observers)
                observer.handleAfterFailure(value, exception);

            throw exception.getCause();
        }
    }
}
