package org.jlib.text;

/**
 * Exception thrown when a {@link CharSequence} end index is below the start
 * index.
 *
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexBelowStartIndexException
extends CharSequenceIndexOutOfBoundsException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3126851142091723143L;

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
    public CharSequenceEndIndexBelowStartIndexException(final CharSequence charSequence, final int beginIndex, final int endIndex) {
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


    @Override
    public String getMessage() {
        return "[\'" + getCharSequence() + "\', " + beginIndex + ", " + getInvalidCharacterIndex() + "]";
    }
}
