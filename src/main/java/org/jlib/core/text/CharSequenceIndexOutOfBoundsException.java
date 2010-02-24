package org.jlib.core.text;

/**
 * Exception thrown when a {@link CharSequence} index is out of bounds.
 * 
 * @author Igor Akkerman
 */
public class CharSequenceIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    /** {@link CharSequence} for which the index is out of bounds */
    private final CharSequence charSequence;

    /**
     * integer specifying the bad index that caused this
     * CharSequenceIndexOutOfBoundsException
     */
    private final int index;

    /**
     * Creates a new CharSequenceIndexOutOfBoundsException for the specified
     * {@link CharSequence}.
     * 
     * @param charSequence
     *        {@link CharSequence} for which the index is out of bounds
     * @param index
     *        integer specifying the invalid index
     */
    public CharSequenceIndexOutOfBoundsException(CharSequence charSequence, int index) {
        this.charSequence = charSequence;
        this.index = index;
    }

    /**
     * Returns the {@link CharSequence} for which the index is out of bounds.
     * 
     * @return {@link CharSequence} for which the index is out of bounds
     */
    public CharSequence getCharSequence() {
        return charSequence;
    }

    /**
     * Returns the bad index that caused this
     * CharSequenceIndexOutOfBoundsException.
     * 
     * @return integer specifying the bad index
     */
    public int getIndex() {
        return index;
    }

    // @see java.lang.Throwable#getMessage()
    @Override
    public String getMessage() {
        return "[\'" + charSequence + "\', " + index + "]";
    }
}
