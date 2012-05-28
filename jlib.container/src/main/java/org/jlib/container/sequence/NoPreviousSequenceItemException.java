package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceStateException} thrown when there is no previous Item
 * to return by a {@link SequenceTraverser}.
 * 
 * @author Igor Akkerman
 */
public class NoPreviousSequenceItemException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286617731417853890L;

    /**
     * Creates a new {@link NoPreviousSequenceItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public NoPreviousSequenceItemException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoPreviousSequenceItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link Exception}
     */
    public NoPreviousSequenceItemException(final Sequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
