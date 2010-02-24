package org.jlib.core.text;

/**
 * Exception thrown when a {@link CharSequence} end index is below the start
 * index.
 * 
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexBelowStartIndexException
extends CharSequenceIndexOutOfBoundsException {

    /** valid begin index */
    private final int beginIndex;

    /**
     * Creates a new CharSequenceEndIndexBelowStartIndexException for the
     * specified {@link CharSequence}.
     * 
     * @param charSequence
     *        {@link CharSequence} for which the end index is below the start
     *        index
     * @param beginIndex
     *        integer specifying the valid begin index
     * @param endIndex
     *        integer specifying the invalid end index
     */
    public CharSequenceEndIndexBelowStartIndexException(CharSequence charSequence, int beginIndex, int endIndex) {
        super(charSequence, endIndex);
        this.beginIndex = beginIndex;
    }

    /**
     * Returns the valid index of the first character.
     * 
     * @return integer specifying the valid index of the first character
     */
    public int getBeginIndex() {
        return beginIndex;
    }

    // @see java.lang.Throwable#getMessage()
    @Override
    public String getMessage() {
        return "[\'" + getCharSequence() + "\', " + beginIndex + ", " + getInvalidCharacterIndex() + "]";
    }
}
