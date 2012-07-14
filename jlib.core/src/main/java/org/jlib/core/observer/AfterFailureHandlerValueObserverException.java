package org.jlib.core.observer;

/**
 * {@link ValueObserverException} thrown during a
 * {@link ValueObserver#handleAfterFailure(Object, OperatorException)}
 * operation.
 * 
 * @author Igor Akkerman
 */
public abstract class AfterFailureHandlerValueObserverException
extends ObserverException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2379268967139497379L;

    /**
     * Creates a new {@link AfterFailureHandlerValueObserverException}.
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code item}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link AfterFailureHandlerValueObserverException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public AfterFailureHandlerValueObserverException(final Object item, final String messagePattern,
                                                     final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, item, messageArguments);
    }
}
