package org.jlib.container.sequence.index;

/**
 * Exception thrown if an invalid index range has been used with an
 * {@link IndexSequence}.
 * 
 * @author Igor Akkerman
 */
public class InvalidSequenceIndexRangeException
extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6780143195522448143L;

    /** the {@link IndexSequence} */
    private final IndexSequence<?> sequence;

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
        super("fromIndex == " + fromIndex + " > " + toIndex + " == toIndex: ");

        this.sequence = sequence;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    /**
     * Returns the {@link IndexSequence} of this
     * InvalidSequenceIndexRangeException
     * 
     * @return the IndexSequence
     */
    public IndexSequence<?> getSequence() {
        return sequence;
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
