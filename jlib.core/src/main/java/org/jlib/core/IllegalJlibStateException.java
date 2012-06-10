package org.jlib.core;

import java.text.MessageFormat;

/**
 * {@link IllegalStateException} using a formatted message.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalJlibStateException
extends IllegalStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6535760982905205135L;

    /**
     * Creates a new {@link IllegalJlibStateException}.
     */
    public IllegalJlibStateException() {
        super();
    }

    /**
     * Creates a new {@link IllegalJlibStateException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalJlibStateException(final String messagePattern, final Object... messageArguments) {
        super(MessageFormat.format(messagePattern, messageArguments));
    }

    /**
     * Creates a new {@link IllegalJlibStateException}.
     * 
     * @param cause
     *        Throwable that caused this {@link IllegalJlibStateException}
     */
    public IllegalJlibStateException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link IllegalJlibStateException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        Throwable that caused this {@link IllegalJlibStateException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message States
     */
    public IllegalJlibStateException(final String messagePattern, final Throwable cause,
                                     final Object... messageArguments) {
        super(MessageFormat.format(messagePattern, messageArguments), cause);
    }
}
