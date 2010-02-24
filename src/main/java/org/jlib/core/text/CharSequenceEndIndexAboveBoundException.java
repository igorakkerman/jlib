package org.jlib.core.text;

/**
 * Exception thrown when an end index of a {@link CharSequence} is above its
 * upper bound.
 * 
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexAboveBoundException
extends CharSequenceIndexOutOfBoundsException {

    /**
     * Creates a new CharSequenceEndIndexAboveBoundException for the specified
     * {@link CharSequence}.
     * 
     * @param charSequence
     *        {@link CharSequence} for which the index is above the upper bound
     * @param endIndex
     *        integer specifying the invalid end index
     */
    public CharSequenceEndIndexAboveBoundException(CharSequence charSequence, int endIndex) {
        super(charSequence, endIndex);
    }
}