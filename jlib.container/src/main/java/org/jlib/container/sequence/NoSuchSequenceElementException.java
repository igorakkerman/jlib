package org.jlib.container.sequence;

/**
 * {@link IllegalStateException} thrown when an expected {@link Sequence}
 * element does not exist.
 * 
 * @author Igor Akkerman
 */
public class NoSuchSequenceElementException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 5261616206496944873L;

    /**
     * Creates a new {@link NoSuchSequenceElementException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public NoSuchSequenceElementException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoSuchSequenceElementException} with the specified
     * cause.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSuchSequenceElementException}
     */
    public NoSuchSequenceElementException(final Sequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
