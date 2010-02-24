package org.jlib.core.text;


/**
 * Exception thrown when an begin index of a {@link CharSequence} is above its upper bound.
 *
 * @author Igor Akkerman
 */
public class CharSequenceBeginIndexAboveBoundException
extends CharSequenceIndexOutOfBoundsException {

    /**
     * Creates a new CharSequenceBeginIndexAboveBoundException for the specified
     * {@link CharSequence}.
     * 
     * @param charSequence
     *        {@link CharSequence} for which the index is above the upper bound
     * @param beginIndex
     *        integer specifying the invalid begin index
     */
    public CharSequenceBeginIndexAboveBoundException(CharSequence charSequence, int beginIndex) {
        super(charSequence, beginIndex);
    }
}
