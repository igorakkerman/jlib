package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when there is no previous Item
 * to return by a {@link SequenceTraverser}.
 * 
 * @author Igor Akkerman
 */
public class NoPreviousItemException
extends IllegalSequenceTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286617731417853890L;

    /**
     * Creates a new {@link NoPreviousItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public NoPreviousItemException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoPreviousItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link Exception}
     */
    public NoPreviousItemException(final Sequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
