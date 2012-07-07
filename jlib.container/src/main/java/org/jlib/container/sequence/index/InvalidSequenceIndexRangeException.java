package org.jlib.container.sequence.index;

import org.jlib.container.sequence.IllegalSequenceArgumentException;

/**
 * {@link IllegalSequenceArgumentException} thrown if an invalid index range has
 * been used with an {@link IndexSequence}.
 * 
 * @author Igor Akkerman
 */
public class InvalidSequenceIndexRangeException
extends IllegalSequenceArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5716666495830602559L;

    /** from index */
    private final int fromIndex;

    /** to index */
    private final int toIndex;

    /**
     * Creates a new {@link InvalidSequenceIndexRangeException}.
     * 
     * @param sequence
     *        {@link IndexSequence} for which this
     *        {@link InvalidSequenceIndexRangeException} is thrown
     * 
     * @param fromIndex
     *        integer specifying the from index
     * 
     * @param toIndex
     *        integer specifying the to index
     * 
     */
    public InvalidSequenceIndexRangeException(final IndexSequence<?> sequence, final int fromIndex, final int toIndex) {
        super(sequence, "fromIndex == " + fromIndex + " > " + toIndex + " == toIndex: ");

        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    /**
     * Returns the from index of this {@link InvalidSequenceIndexRangeException}
     * .
     * 
     * @return integer specifying the from index
     */
    public int getFromIndex() {
        return fromIndex;
    }

    /**
     * Returns the to index of this {@link InvalidSequenceIndexRangeException}.
     * 
     * @return integer specifying the toIndex
     */
    public int getToIndex() {
        return toIndex;
    }
}
