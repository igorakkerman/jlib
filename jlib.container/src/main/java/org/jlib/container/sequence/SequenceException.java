package org.jlib.container.sequence;

import java.text.MessageFormat;

/**
 * {@link RuntimeException} referencing a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public abstract class SequenceException
extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = -540223071568730842L;

    /** referenced {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link SequenceException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public SequenceException(final Sequence<?> sequence) {
        this(sequence, (Throwable) null);
    }

    /**
     * Creates a new {@link SequenceException} with the specified error message.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     */
    public SequenceException(final Sequence<?> sequence, final String errorMessage) {
        this(sequence, errorMessage, null);
    }

    /**
     * Creates a new {@link SequenceException} with the specified cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link SequenceException}
     */
    public SequenceException(final Sequence<?> sequence, final Throwable cause) {
        this(sequence, "{1}", cause);
    }

    /**
     * Creates a new {@link SequenceException} with the specified error message
     * and cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link SequenceException}
     */
    public SequenceException(final Sequence<?> sequence, final String errorMessage, final Throwable cause) {
        super(MessageFormat.format(errorMessage, sequence), cause);

        this.sequence = sequence;
    }

    /**
     * Returns the {@link Sequence} of this {@link SequenceException}.
     * 
     * @return referenced {@link Sequence}
     */
    public Sequence<?> getSequence() {
        return sequence;
    }
}
