package org.jlib.core.text;


/**
 * Exception thrown when a {@link CharSequence} end index is below the start index.
 *
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexBelowStartIndexException
extends CharSequenceIndexOutOfBoundsException {

    /**
     * Creates a new CharSequenceEndIndexBelowStartIndexException for the specified
     * {@link CharSequence}.
     * 
     * @param charSequence
     *        {@link CharSequence} for which the end index is below the start index
     * @param index
     *        integer specifying the invalid index
     */
    public CharSequenceEndIndexBelowStartIndexException(CharSequence charSequence, int index) {
        super(charSequence, index);
    }
}
