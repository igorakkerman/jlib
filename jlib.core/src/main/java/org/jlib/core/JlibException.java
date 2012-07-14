package org.jlib.core;

import java.text.MessageFormat;

import org.jlib.core.array.ArrayUtility;

/**
 * {@link Exception} using a formatted message.
 * 
 * @author Igor Akkerman
 */
public abstract class JlibException
extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = -7508635402610527176L;

    /**
     * Creates a new {@link JlibException}.
     */
    public JlibException() {
        super();
    }

    /**
     * Creates a new {@link JlibException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public JlibException(final String messagePattern, final Object... messageArguments) {
        this(messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link JlibException}.
     * 
     * @param cause
     *        Throwable that caused this {@link JlibException}
     */
    public JlibException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link JlibException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        Throwable that caused this {@link JlibException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message States
     */
    public JlibException(final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(MessageFormat.format(messagePattern, ArrayUtility.flatten(messageArguments)), cause);
    }
}
