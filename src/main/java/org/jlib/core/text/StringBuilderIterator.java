package org.jlib.core.text;

/**
 * Iterator over the {@link Character Characters} of a {@link StringBuilder}.
 * 
 * @author Igor Akkerman
 */
public class StringBuilderIterator
extends CharSequenceIterator {

    /**
     * Returns a new StringBuilderIterator over the {@link Character Characters}
     * of the specified {@link StringBuilder}.
     * 
     * @param iteratedStringBuilder
     *        {@link StringBuilder} to iterate
     * @return new StringBuilderIterator over the {@link Character Characters}
     *         of the specified {@link StringBuilder}
     */
    public static StringBuilderIterator iterator(StringBuilder iteratedStringBuilder) {
        return new StringBuilderIterator(iteratedStringBuilder);
    }

    /** StringBuilder iterated by this StringBuilderIterator */
    private final StringBuilder iteratedStringBuilder;

    /**
     * Creates a new StringBuilderIterator over the {@link Character Characters}
     * of the specified {@link StringBuilder}.
     * 
     * @param iteratedStringBuilder
     *        {@link StringBuilder} to iterate
     */
    public StringBuilderIterator(StringBuilder iteratedStringBuilder) {
        super(iteratedStringBuilder);
        this.iteratedStringBuilder = iteratedStringBuilder;
    }

    /**
     * Deletes the last {@link Character} returned by this StringBuilderIterator
     * from the {@link StringBuilder}.
     */
    @Override
    public void remove() {
        iteratedStringBuilder.deleteCharAt(nextCharacterIndex - 1);
    }
}
