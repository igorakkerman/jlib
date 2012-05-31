package org.jlib.container.sequence;

import org.jlib.core.traverser.RemoveTraverser;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when
 * {@link RemoveTraverser#remove()} has been called without.
 * 
 * @author Igor Akkerman
 */
public class NoItemToRemoveException
extends IllegalSequenceTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1028428356522236671L;

    /**
     * Creates a new {@link NoItemToRemoveException}.
     * 
     * @param sequence
     *        traversed {@link ReplaceSequence}
     */
    public NoItemToRemoveException(final ReplaceSequence<?> sequence) {
        super(sequence);
    }
}
