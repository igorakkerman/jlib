package org.jlib.container.sequence.index;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.Sequence;

/**
 * {@link Exception} thrown when an expected {@link Sequence} element does not
 * exist.
 * 
 * @author Igor Akkerman
 */
public class NoSuchSequenceElementException
extends NoSuchElementException {

    /** serialVersionUID */
    private static final long serialVersionUID = 8829061406754132058L;

    /** cause */
    private final Throwable cause;

    /**
     * Creates a new {@link NoSuchSequenceElementException}.
     */
    public NoSuchSequenceElementException() {
        this(null);
    }

    /**
     * Creates a new {@link NoSuchSequenceElementException}.
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSuchSequenceElementException}
     */
    public NoSuchSequenceElementException(final Throwable cause) {
        super(cause.getMessage());

        this.cause = cause;
    }

    @Override
    @Deprecated
    // Deprecated: this method should not be called directly, only for stack trace, as it may return null
    public Throwable getCause() {
        return cause;
    }
}
