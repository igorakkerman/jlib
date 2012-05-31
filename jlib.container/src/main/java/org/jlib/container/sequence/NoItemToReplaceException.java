package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when
 * {@link ReplaceSequenceTraverser#replace(Object)} has been called without a
 * previously returned Item.
 * 
 * @author Igor Akkerman
 */
public class NoItemToReplaceException
extends IllegalSequenceTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -4930329712329638796L;

    /**
     * Creates a new {@link NoItemToReplaceException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoItemToReplaceException}
     */
    public NoItemToReplaceException(final ReplaceSequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
