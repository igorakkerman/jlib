package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when there is no next Item to
 * return by a {@link SequenceTraverser}.
 * 
 * @author Igor Akkerman
 */
public class NoNextItemException
extends IllegalSequenceTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286617731417853890L;

    /**
     * Creates a new {@link NoNextItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public NoNextItemException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoNextItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link Exception}
     */
    public NoNextItemException(final Sequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
