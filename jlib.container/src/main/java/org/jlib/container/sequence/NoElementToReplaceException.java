package org.jlib.container.sequence;

/**
 * {@link IllegalStateException} thrown when
 * {@link ReplaceSequenceIterator#replace(Object)} has been called without.
 * 
 * @author Igor Akkerman
 */
public class NoElementToReplaceException
extends IllegalStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7078599807599575854L;

    /** traversed {@link ReplaceSequence} */
    private final ReplaceSequence<?> sequence;

    /**
     * Creates a new {@link NoElementToReplaceException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     */
    public NoElementToReplaceException(final ReplaceSequence<?> sequence) {
        super(sequence.toString());

        this.sequence = sequence;
    }

    /**
     * Creates a new {@link NoElementToReplaceException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     * 
     * @param message
     *        String specifying the error message
     */
    public NoElementToReplaceException(final ReplaceSequence<?> sequence, final String message) {
        super(message);

        this.sequence = sequence;
    }

    /**
     * Returns the traversed {@link ReplaceSequence}.
     * 
     * @return traversed {@link ReplaceSequence}
     */
    public ReplaceSequence<?> getSequence() {
        return sequence;
    }
}
