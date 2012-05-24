package org.jlib.container.sequence;

/**
 * {@link IllegalStateException} thrown when
 * {@link ReplaceSequenceIterator#replace(Object)} has been called without a
 * previously returned Element.
 * 
 * @author Igor Akkerman
 */
public class NoElementToReplaceException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -4930329712329638796L;

    /**
     * Creates a new {@link NoElementToReplaceException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     */
    public NoElementToReplaceException(final ReplaceSequence<?> sequence) {
        super(sequence);
    }
}
