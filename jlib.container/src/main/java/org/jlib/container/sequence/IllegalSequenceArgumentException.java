package org.jlib.container.sequence;

import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link IllegalContainerArgumentException} referencing a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalSequenceArgumentException
extends IllegalContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -4935044142559108435L;

    /** referenced {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link IllegalSequenceArgumentException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public IllegalSequenceArgumentException(final Sequence<?> sequence) {
        this(sequence, (Throwable) null);
    }

    /**
     * Creates a new {@link IllegalSequenceArgumentException} with the specified
     * error message.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param messageArguments
     *        sequence of {@link Object} error message arguments
     */
    public IllegalSequenceArgumentException(final Sequence<?> sequence, final String messagePattern,
                                            final Object... messageArguments) {
        this(sequence, messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalSequenceArgumentException} with the specified
     * cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalSequenceArgumentException}
     */
    public IllegalSequenceArgumentException(final Sequence<?> sequence, final Throwable cause) {
        this(sequence, "{1}", cause);
    }

    /**
     * Creates a new {@link IllegalSequenceArgumentException} with the specified
     * error message and cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalSequenceArgumentException}
     * 
     * @param messageArguments
     *        sequence of {@link Object} error message arguments
     */
    public IllegalSequenceArgumentException(final Sequence<?> sequence, final String messagePattern,
                                            final Throwable cause, final Object... messageArguments) {
        super(sequence, messagePattern, cause, messageArguments);

        this.sequence = sequence;
    }

    /**
     * Returns the {@link Sequence} of this
     * {@link IllegalSequenceArgumentException}.
     * 
     * @return referenced {@link Sequence}
     */
    @Override
    public Sequence<?> getContainer() {
        return sequence;
    }
}
