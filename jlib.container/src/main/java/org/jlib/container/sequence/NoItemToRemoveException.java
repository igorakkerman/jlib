package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when
 * {@link RemoveSequenceTraverser#remove()} has been called without a previously
 * returned Item.
 * 
 * @author Igor Akkerman
 */
public class NoItemToRemoveException
extends IllegalSequenceTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6396461191818230981L;

    /**
     * Creates a new {@link NoItemToRemoveException}.
     * 
     * @param sequence
     *        traversed {@link RemoveSequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link NoItemToRemoveException}
     */
    public NoItemToRemoveException(final RemoveSequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
