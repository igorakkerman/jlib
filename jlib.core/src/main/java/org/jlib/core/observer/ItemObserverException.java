package org.jlib.core.observer;

/**
 * {@link ObserverException} thrown during an Item operation.
 * 
 * @author Igor Akkerman
 */
public class ItemObserverException
extends ObserverException {

    /**
     * Creates a new {@link ItemObserverException}.
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code item}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link ItemObserverException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ItemObserverException(final Object item, final String messagePattern, final Throwable cause,
                                 final Object... messageArguments) {
        super(messagePattern, cause, item, messageArguments);
    }
}
