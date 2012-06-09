package org.jlib.core.observer;

/**
 * {@link ObserverException} thrown during an {@link ValueObserver} operation.
 * 
 * @author Igor Akkerman
 */
public abstract class ValueObserverException
extends ObserverException {

    /**
     * Creates a new {@link ValueObserverException}.
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code item}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link ValueObserverException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ValueObserverException(final Object item, final String messagePattern, final Throwable cause,
                                  final Object... messageArguments) {
        super(messagePattern, cause, item, messageArguments);
    }
}
