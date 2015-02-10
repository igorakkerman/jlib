package org.jlib.text;

/**
 * Exception thrown when a {@link CharSequence} end index is below the start
 * index.
 *
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexBelowStartIndexException
extends CharSequenceIndexOutOfBoundsException {

    private static final long serialVersionUID = 3126851142091723143L;

    /** valid begin index */
    private final int beginIndex;

    public CharSequenceEndIndexBelowStartIndexException(final CharSequence charSequence, final int beginIndex,
                                                        final int endIndex) {
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
