package org.jlib.container.sequence;

import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link RuntimeException} referencing a {@link Sequence}.
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
     */
    public IllegalSequenceArgumentException(final Sequence<?> sequence, final String messagePattern) {
        this(sequence, messagePattern, null);
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
     */
    public IllegalSequenceArgumentException(final Sequence<?> sequence, final String messagePattern,
                                            final Throwable cause) {
        super(sequence, messagePattern, cause);

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
