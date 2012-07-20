package org.jlib.core;

/**
 * {@link IllegalJlibStateException} thrown in an uexpected state.
 * 
 * @author Igor Akkerman
 */
public class UnexpectedStateException
extends IllegalJlibStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -4203256054042738427L;

    /**
     * Creates a new {@link UnexpectedStateException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param messageArguments
     *        comma separated sequence of error message arguments
     */
    public UnexpectedStateException(final String messagePattern, final Object... messageArguments) {
        super(messagePattern, messageArguments);
    }

    /**
     * Creates a new {@link UnexpectedStateException}.
     * 
     * @param cause
     *        Throwable that caused this {@link UnexpectedStateException}
     */
    public UnexpectedStateException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link UnexpectedStateException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param cause
     *        Throwable that caused this {@link UnexpectedStateException}
     * 
     * @param messageArguments
     *        comma separated sequence of error message arguments
     */
    public UnexpectedStateException(final String messagePattern, final Throwable cause,
                                    final Object... messageArguments) {
        super(messagePattern, cause, messageArguments);
    }
}
