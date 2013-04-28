package org.jlib.container.sequence;

import org.jlib.core.traverser.NoNextItemException;

/**
 * {@link NoNextItemException} thrown when there is no next Item to return by a
 * {@link SequenceTraverser}.
 * 
 * @author Igor Akkerman
 */
public class NoNextSequenceItemException
extends NoNextItemException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286617731417853890L;

    /** traversed {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link NoNextSequenceItemException}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public NoNextSequenceItemException(final Sequence<?> sequence) {
        this(sequence, null);
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

        this.sequence = sequence;
    }

    @Override
    public Sequence<?> getTraversible() {
        return sequence;
    }
}
