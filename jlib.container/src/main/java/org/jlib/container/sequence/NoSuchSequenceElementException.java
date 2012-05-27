package org.jlib.container.sequence;

/**
 * {@link IllegalStateException} thrown when an expected {@link Sequence}
 * item does not exist.
 * 
 * @author Igor Akkerman
 */
public class NoSuchSequenceItemException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 5261616206496944873L;

    /**
     * Creates a new {@link NoSuchSequenceItemException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public NoSuchSequenceItemException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoSuchSequenceItemException} with the specified
     * cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSuchSequenceItemException}
     */
    public NoSuchSequenceItemException(final Sequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
