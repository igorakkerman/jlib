package org.jlib.container.sequence;

import org.jlib.core.traverser.IllegalTraverserStateException;

/**
 * {@link IllegalTraverserStateException} referencing a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalSequenceTraverserStateException
extends IllegalTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7078599807599575854L;

    /** referenced {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link IllegalSequenceTraverserStateException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public IllegalSequenceTraverserStateException(final Sequence<?> sequence) {
        this(sequence, (Throwable) null);
    }

    /**
     * Creates a new {@link IllegalSequenceTraverserStateException} with the
     * specified error message.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     */
    public IllegalSequenceTraverserStateException(final Sequence<?> sequence, final String errorMessage) {
        this(sequence, errorMessage, null);
    }

    /**
     * Creates a new {@link IllegalSequenceTraverserStateException} with the
     * specified cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalSequenceTraverserStateException}
     */
    public IllegalSequenceTraverserStateException(final Sequence<?> sequence, final Throwable cause) {
        this(sequence, "{1}", cause);
    }

    /**
     * Creates a new {@link IllegalSequenceTraverserStateException} with the
     * specified error message and cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param errorMessage
     *        {@link String} specifying the error message
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalSequenceTraverserStateException}
     */
    public IllegalSequenceTraverserStateException(final Sequence<?> sequence, final String errorMessage,
                                                  final Throwable cause) {
        super(sequence, errorMessage, cause);

        this.sequence = sequence;
    }

    /**
     * Returns the referenced {@link Sequence}.
     * 
     * @return referenced {@link Sequence}
     */
    @Override
    public Sequence<?> getTraversible() {
        return sequence;
    }
}
