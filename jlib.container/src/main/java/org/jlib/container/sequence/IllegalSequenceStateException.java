package org.jlib.container.sequence;

import java.text.MessageFormat;

import org.jlib.core.traverser.IllegalTraverserStateException;

/**
 * {@link IllegalTraverserStateException} referencing a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalSequenceStateException
extends IllegalTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7078599807599575854L;

    /** referenced {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link IllegalSequenceStateException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public IllegalSequenceStateException(final Sequence<?> sequence) {
        this(sequence, (Throwable) null);
    }

    /**
     * Creates a new {@link IllegalSequenceStateException} with the specified
     * error message.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     */
    public IllegalSequenceStateException(final Sequence<?> sequence, final String errorMessage) {
        this(sequence, errorMessage, null);
    }

    /**
     * Creates a new {@link IllegalSequenceStateException} with the specified
     * cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalSequenceStateException}
     */
    public IllegalSequenceStateException(final Sequence<?> sequence, final Throwable cause) {
        this(sequence, "{1}", cause);
    }

    /**
     * Creates a new {@link IllegalSequenceStateException} with the specified
     * error message and cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalSequenceStateException}
     */
    public IllegalSequenceStateException(final Sequence<?> sequence, final String errorMessage, final Throwable cause) {
        super(MessageFormat.format(errorMessage, sequence), cause);

        this.sequence = sequence;
    }

    /**
     * Returns the referenced {@link Sequence}.
     * 
     * @return referenced {@link Sequence}
     */
    public Sequence<?> getSequence() {
        return sequence;
    }
}
