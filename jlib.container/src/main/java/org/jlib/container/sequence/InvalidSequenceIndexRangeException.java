package org.jlib.container.sequence;

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

    /** from index */
    private final int fromIndex;

    /** to index */
    private final int toIndex;

    /**
     * Creates a new InvalidSequenceIndexRangeException.
     * 
     * @param fromIndex
     *        integer specifying the from index
     * @param toIndex
     *        integer specifying the to index
     * 
     */
    public InvalidSequenceIndexRangeException(final int fromIndex, final int toIndex) {
        super("fromIndex == " + fromIndex + " > " + toIndex + " == toIndex: ");

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
