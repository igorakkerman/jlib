package org.jlib.container.sequence;

/**
 * {@link IllegalStateException} thrown when
 * {@link ReplaceSequenceIterator#remove()} has been called without.
 * 
 * @author Igor Akkerman
 */
public class NoElementToRemoveException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1028428356522236671L;

    /**
     * Creates a new {@link NoElementToRemoveException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     */
    public NoElementToRemoveException(final ReplaceSequence<?> sequence) {
        super(sequence);
    }
}
