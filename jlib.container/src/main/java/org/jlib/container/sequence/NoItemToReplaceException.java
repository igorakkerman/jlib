package org.jlib.container.sequence;

/**
 * {@link IllegalStateException} thrown when
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
     */
    public NoItemToReplaceException(final ReplaceSequence<?> sequence) {
        super(sequence);
    }
}
