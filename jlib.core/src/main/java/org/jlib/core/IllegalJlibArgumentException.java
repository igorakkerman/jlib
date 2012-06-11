package org.jlib.core;

import java.text.MessageFormat;

/**
 * {@link IllegalArgumentException} using a formatted message.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalJlibArgumentException
extends IllegalArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 5894034302749387338L;

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     */
    public IllegalJlibArgumentException() {
        super();
    }

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalJlibArgumentException(final String messagePattern, final Object... messageArguments) {
        this(messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     * 
     * @param cause
     *        Throwable that caused this {@link IllegalJlibArgumentException}
     */
    public IllegalJlibArgumentException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        Throwable that caused this {@link IllegalJlibArgumentException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalJlibArgumentException(final String messagePattern, final Throwable cause,
                                        final Object... messageArguments) {
        super(MessageFormat.format(messagePattern, messageArguments), cause);
    }
}
