package org.jlib.core.text;


/**
 * Exception thrown when a {@link CharSequence} begin index is negative.
 *
 * @author Igor Akkerman
 */
public class CharSequenceBeginIndexNegativeException
extends CharSequenceIndexOutOfBoundsException {

    /**
     * Creates a new CharSequenceBeginIndexNegativeException for the specified
     * {@link CharSequence}.
     * 
     * @param charSequence
     *        {@link CharSequence} for which the index is negative
     * @param index
     *        integer specifying the invalid index
     */
    public CharSequenceBeginIndexNegativeException(CharSequence charSequence, int index) {
        super(charSequence, index);
    }
}
