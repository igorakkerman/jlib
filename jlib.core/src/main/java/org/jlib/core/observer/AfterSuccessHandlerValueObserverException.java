package org.jlib.core.observer;

/**
 * {@link ValueObserverException} thrown during a
 * {@link ValueObserver#handleBefore(Object, Object...)} operation.
 * 
 * @author Igor Akkerman
 */
public abstract class AfterSuccessHandlerValueObserverException
extends ObserverException {

    /**
     * Creates a new {@link AfterSuccessHandlerValueObserverException}.
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
     *        {@link AfterSuccessHandlerValueObserverException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public AfterSuccessHandlerValueObserverException(final Object item, final String messagePattern, final Throwable cause,
                                               final Object... messageArguments) {
        super(messagePattern, cause, item, messageArguments);
    }
}
