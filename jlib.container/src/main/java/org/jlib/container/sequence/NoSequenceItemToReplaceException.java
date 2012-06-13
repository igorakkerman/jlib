package org.jlib.container.sequence;

import org.jlib.core.traverser.NoItemToReplaceException;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when
 * {@link ReplaceSequenceTraverser#replace(Object)} has been called without a
 * previously returned Item.
 * 
 * @author Igor Akkerman
 */
public class NoSequenceItemToReplaceException
extends NoItemToReplaceException {

    /** serialVersionUID */
    private static final long serialVersionUID = -4930329712329638796L;

    /**
     * Creates a new {@link NoSequenceItemToReplaceException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     *        {@link NoSequenceItemToReplaceException}
     */
    public NoSequenceItemToReplaceException(final ReplaceSequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoSequenceItemToReplaceException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSequenceItemToReplaceException}
     */
    public NoSequenceItemToReplaceException(final ReplaceSequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
