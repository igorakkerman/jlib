package org.jlib.container.sequence;

import org.jlib.core.traverser.NoItemToRemoveException;

/**
 * {@link NoItemToRemoveException} thrown when
 * {@link RemoveSequenceTraverser#remove()} has been called without a previously
 * returned Item.
 * 
 * @author Igor Akkerman
 */
public class NoSequenceItemToRemoveException
extends NoItemToRemoveException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2785280233767786496L;

    /** traversed {@link RemoveSequence} */
    private final RemoveSequence<?> sequence;

    /**
     * Creates a new {@link NoSequenceItemToRemoveException}.
     * 
     * @param sequence
     *        traversed {@link RemoveSequence}
     */
    public NoSequenceItemToRemoveException(final RemoveSequence<?> sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    /**
     * Creates a new {@link NoSequenceItemToRemoveException}.
     * 
     * @param sequence
     *        traversed {@link RemoveSequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSequenceItemToRemoveException}
     */
    public NoSequenceItemToRemoveException(final RemoveSequence<?> sequence, final Throwable cause) {
        super(sequence, cause);

        this.sequence = sequence;
    }

    @Override
    public RemoveSequence<?> getTraversible() {
        return sequence;
    }
}
