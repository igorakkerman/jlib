package org.jlib.container.sequence;

import org.jlib.container.sequence.index.array.ReplaceAppendRemoveTailArraySequence;

/**
 * {@link IllegalSequenceStateException} thrown when trying to remove the sole
 * Item of a {@link Sequence} that may not be empty.
 * 
 * @author Igor Akkerman
 */
public class SoleItemNotRemoveableException
extends IllegalSequenceStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -7467942886021869121L;

    /**
     * Creates a new {@link SoleItemNotRemoveableException}.
     * 
     * @param sequence
     *        targeted {@link Sequence}
     */
    public SoleItemNotRemoveableException(final ReplaceAppendRemoveTailArraySequence<?> sequence) {
        super(sequence);
    }
}
