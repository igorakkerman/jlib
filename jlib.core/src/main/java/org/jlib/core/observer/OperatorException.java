package org.jlib.core.observer;

import org.jlib.core.JlibException;

/**
 * {@link JlibException} thrown during the operation of an operator.
 * 
 * @author Igor Akkerman
 */
public abstract class OperatorException
extends JlibException {

    /** {@link RuntimeException} that caused this {@link OperatorException} */
    private final RuntimeException cause;

    /**
     * Creates a new {@link OperatorException}.
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code value}
     * 
     * @param cause
     *        {@link RuntimeException} that caused this
     *        {@link OperatorException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public OperatorException(final String messagePattern, final RuntimeException cause,
                             final Object... messageArguments) {
        super(messagePattern, cause, messageArguments);

        this.cause = cause;
    }

    @Override
    public synchronized RuntimeException getCause() {
        return cause;
    }
}
