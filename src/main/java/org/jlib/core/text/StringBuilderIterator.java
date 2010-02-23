package org.jlib.core.text;

import java.util.Iterator;

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

    /**
     * Returns an {@link Iterable} creating {@link StringBuilderIterator
     * StringBuilderIterators} over the {@link Character Characters} of a
     * {@link StringBuilder}.
     * 
     * @param iterableStringBuilder
     *        {@link StringBuilder} to iterate
     * @return {@link Iterable} creating {@link StringBuilderIterator
     *         StringBuilderIterators} over the {@link Character Characters} of a
     *         {@link StringBuilder}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder) {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new StringBuilderIterator(iterableStringBuilder);
            }
        };
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
