package org.jlib.core.observer;

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;

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
     *        {@link ArgumentReturnValueOperator}
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
     * @throws IllegalJlibArgumentException
     *         if {@code newItem} causes an error
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    @SuppressWarnings("finally")
    public static <ArgumentValue, ReturnValue> ReturnValue operate(final ArgumentReturnValueOperator<ArgumentValue, ReturnValue> operator,
                                                                   final ArgumentValue argumentValue,
                                                                   final ValueObserver<ArgumentValue>... observers)
    throws IllegalJlibArgumentException, IllegalJlibStateException {
        try {
            for (final ValueObserver<ArgumentValue> observer : observers)
                observer.handleBefore(argumentValue, operator);

            final ReturnValue returnValue = operator.operate(argumentValue);

            for (final ValueObserver<ArgumentValue> observer : observers)
                observer.handleAfterSuccess(argumentValue, operator);

            return returnValue;
        }
        catch (final IllegalJlibArgumentException | IllegalJlibStateException exception) {
            // if "legal" excption is thrown
            try {
                for (final ValueObserver<ArgumentValue> observer : observers)
                    observer.handleAfterFailure(argumentValue, operator);
            }
            finally {
                throw exception;
            }
        }
        catch (final RuntimeException exception) {
            // if "illegal" excption is thrown
            try {
                for (final ValueObserver<ArgumentValue> observer : observers)
                    observer.handleAfterFailure(argumentValue, operator);

                throw new IllegalJlibStateException("{1}({2})", exception, operator, argumentValue);
            }
            catch (final RuntimeException handleAfterFailureException) {
                throw new IllegalJlibStateException("{1}({2}): {3}. handleAfterFailure: {4}", exception, operator,
                                                    argumentValue, exception.getLocalizedMessage(),
                                                    handleAfterFailureException.getLocalizedMessage());
            }
        }
    }

    /**
     * Operates on the specified ArgumentValue using the specified
     * {@link ArgumentReturnValueOperator}.
     * 
     * If a {@link ValueObserver#handleBefore(Object, Object...)} causes an
     * error, this method returns and the actual operation is not executed. If a
     * {@link ValueObserver#handleAfterSuccess(Object, Object...)} causes an
     * error, this method returns If a
     * {@link ValueObserver#handleAfterFailure(Object, Object...)} causes an
     * error, this method returns
     * 
     * @param <ArgumentValue>
     *        type of the argument value
     * 
     * @param operator
     *        {@link ValueOperator}
     * 
     * @param argumentValue
     *        ArgumentValue operated on
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws ValueOperatorException
     *         if the actual operation could not be completed
     * 
     * @throws ValueObserverException
     *         if a {@link ValueObserver} of {@code observers} causes an error
     */
    @SafeVarargs
    @SuppressWarnings("finally")
    public static <ArgumentValue> void operate(final ValueOperator<ArgumentValue> operator,
                                               final ArgumentValue argumentValue,
                                               final ValueObserver<ArgumentValue>... observers)
    throws ValueOperatorException, ValueObserverException {
        try {
            for (final ValueObserver<ArgumentValue> observer : observers)
                observer.handleBefore(argumentValue, operator);

            operator.operate(argumentValue);
        }
        catch (final ValueOperatorException exception) {
            try {
                for (final ValueObserver<ArgumentValue> observer : observers)
                    observer.handleAfterFailure(argumentValue, operator);
            }
            finally {
                throw exception;
            }
        }
    }
}

//            try {
//                for (final ValueObserver<ArgumentValue> observer : observers)
//                    observer.handleAfterFailure(argumentValue, operator);
//
//                throw new IllegalJlibStateException("{1}({2})", exception, operator, argumentValue);
//            }
//            catch (final RuntimeException handleAfterFailureException) {
//                throw new IllegalJlibStateException("{1}({2}): {3}. handleAfterFailure: {4}", exception, operator,
//                                                    argumentValue, exception.getLocalizedMessage(),
//                                                    handleAfterFailureException.getLocalizedMessage());
//            }
//        }
//
