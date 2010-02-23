package org.jlib.core.text;

import java.util.Iterator;

/**
 * Iterator over the {@link Character Characters} of a {@link CharSequence}.
 * 
 * @author Igor Akkerman
 */
public class CharSequenceIterator
implements Iterator<Character> {

    /**
     * Returns a new CharSequenceIterator over the {@link Character Characters}
     * of the specified {@link CharSequence}.
     * 
     * @param iteratedCharSequence
     *        {@link CharSequence} to iterate
     * @return new CharSequenceIterator over the {@link Character Characters} of
     *         the specified {@link CharSequence}
     */
    public static CharSequenceIterator iterator(CharSequence iteratedCharSequence) {
        return new CharSequenceIterator(iteratedCharSequence);
    }

    /**
     * Returns an {@link Iterable} creating {@link CharSequenceIterator
     * CharSequenceIterators} over the {@link Character Characters} of a
     * {@link CharSequence}.
     * 
     * @param iterableCharSequence
     *        {@link CharSequence} to iterate
     * @return {@link Iterable} creating {@link CharSequenceIterator
     *         CharSequenceIterators} over the {@link Character Characters} of a
     *         {@link CharSequence}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence) {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new CharSequenceIterator(iterableCharSequence);
            }
        };
    }

    /** {@link CharSequence} iterated by this CharSequenceIterator */
    private final CharSequence iteratedCharSequence;

    /** next character index */
    protected int nextCharacterIndex;

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters}
     * of the specified {@link CharSequence}.
     * 
     * @param iteratedCharSequence
     *        {@link CharSequence} to iterate
     */
    public CharSequenceIterator(CharSequence iteratedCharSequence) {
        this.iteratedCharSequence = iteratedCharSequence;
        nextCharacterIndex = 0;
    }

    // @see java.util.Iterator#hasNext()
    @Override
    public boolean hasNext() {
        return nextCharacterIndex < iteratedCharSequence.length();
    }

    // @see java.util.Iterator#next()
    @Override
    public Character next() {
        return iteratedCharSequence.charAt(nextCharacterIndex ++);
    }

    /**
     * <p>
     * This implementation throws an {@link UnsupportedOperationException} as a
     * general {@link CharSequence} does not support deletion of
     * {@link Character Characters}.
     * </p>
     * <p>
     * Subclasses may use covariance and imeplement this method for
     * {@link CharSequence CharSequences} supporting deletion of
     * {@link Character Characters}.
     * </p>
     */
    @Override
    public void remove()
    throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
