package org.jlib.text;

/**
 * Exception thrown when an end index of a {@link CharSequence} is above its
 * upper bound.
 *
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexAboveBoundException
extends CharSequenceIndexOutOfBoundsException {

    /** serialVersionUID */
    private static final long serialVersionUID = -1052579867414829092L;

    /**
     * Creates a new CharSequenceEndIndexAboveBoundException for the specified
     * {@link CharSequence}.
     *
     * @param charSequence
     *        {@link CharSequence} for which the index is above the upper bound
     * @param endIndex
     *        integer specifying the invalid end index
     */
    public CharSequenceEndIndexAboveBoundException(final CharSequence charSequence, final int endIndex) {
        super(charSequence, endIndex);
    }
}
