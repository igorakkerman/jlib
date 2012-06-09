package org.jlib.core.observer;

import org.jlib.core.IllegalJlibStateException;

/**
 * {@link IllegalJlibStateException} thrown during the operation of an operator.
 * 
 * @author Igor Akkerman
 */
public abstract class OperatorException
extends IllegalJlibStateException {

    /**
     * Creates a new {@link OperatorException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code value}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link OperatorException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public OperatorException(final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, messageArguments);
    }
}
