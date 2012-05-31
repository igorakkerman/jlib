package org.jlib.container.sequence;

import java.text.MessageFormat;

/**
 * {@link RuntimeException} referencing a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public abstract class SequenceRuntimeException
extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = -540223071568730842L;

    /** referenced {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link SequenceRuntimeException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public SequenceRuntimeException(final Sequence<?> sequence) {
        this(sequence, (Throwable) null);
    }

    /**
     * Creates a new {@link SequenceRuntimeException} with the specified error message.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     */
    public SequenceRuntimeException(final Sequence<?> sequence, final String errorMessage) {
        this(sequence, errorMessage, null);
    }

    /**
     * Creates a new {@link SequenceRuntimeException} with the specified cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link SequenceRuntimeException}
     */
    public SequenceRuntimeException(final Sequence<?> sequence, final Throwable cause) {
        this(sequence, "{1}", cause);
    }

    /**
     * Creates a new {@link SequenceRuntimeException} with the specified error message
     * and cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link SequenceRuntimeException}
     */
    public SequenceRuntimeException(final Sequence<?> sequence, final String errorMessage, final Throwable cause) {
        super(MessageFormat.format(errorMessage, sequence), cause);

        this.sequence = sequence;
    }

    /**
     * Returns the {@link Sequence} of this {@link SequenceRuntimeException}.
     * 
     * @return referenced {@link Sequence}
     */
    public Sequence<?> getSequence() {
        return sequence;
    }
}
