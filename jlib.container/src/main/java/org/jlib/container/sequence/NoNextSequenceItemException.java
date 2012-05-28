package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when there is no next Item to
 * return by a {@link SequenceTraverser}.
 * 
 * @author Igor Akkerman
 */
public class NoNextSequenceItemException
extends IllegalSequenceTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286617731417853890L;

    /**
     * Creates a new {@link NoNextSequenceItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public NoNextSequenceItemException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoNextSequenceItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link Exception}
     */
    public NoNextSequenceItemException(final Sequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
