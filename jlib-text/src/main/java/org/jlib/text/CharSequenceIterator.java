package org.jlib.text;


import java.util.NoSuchItemException;

import org.jlib.core.iterator.AbstractIterator;

/**
 * <p>
 * Iterator over the {@link Character Characters} of a {@link CharSequence}.
 * </p>
 *
 * <p>
 * This implementation's {@link #remove()} method throws an
 * {@link UnsupportedOperationException} as a general {@link CharSequence} does
 * not support deletion of {@link Character Characters}.
 * </p>
 * <p>
 * Subclasses may use covariance and imeplement this method for
 * {@link CharSequence CharSequences} supporting deletion of {@link Character
 * Characters}.
 * </p>
 *
 * @author Igor Akkerman
 */
public class CharSequenceIterator
extends AbstractIterator<Character> {

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of a {@link CharSequence}.
     *
     * @param iterableCharSequence
     *        {@link CharSequence} to iterate
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of {@code iterableCharSequence}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence) {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new CharSequenceIterator(iterableCharSequence);
            }
        };
    }

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of the subsequence specified by the index of
     * its first character (inclusive) contained by the specified
     * {@link CharSequence}.
     *
     * @param iterableCharSequence
     *        {@link CharSequence} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of the subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedCharSequence.length()}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence, final int firstCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceBeginIndexAboveBoundException {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new CharSequenceIterator(iterableCharSequence, firstCharacterIndex);
            }
        };
    }

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of the subsequence specified by the indices
     * of its first and last characters (inclusive) contained by the specified
     * {@link CharSequence}.
     *
     * @param iterableCharSequence
     *        {@link CharSequence} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @param lastCharacterIndex
     *        integer specifying the index of the last character of the
     *        subsequence
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of the subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceEndIndexBelowStartIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedCharSequence.length()}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence, final int firstCharacterIndex,
                                               final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowStartIndexException,
    CharSequenceEndIndexAboveBoundException {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new CharSequenceIterator(iterableCharSequence, firstCharacterIndex, lastCharacterIndex);
            }
        };
    }

    /** {@link CharSequence} iterated by this CharSequenceIterator */
    private final CharSequence iteratedCharSequence;

    /** index of next iterated character */
    protected int nextCharacterIndex;

    /** index of last iterated character */
    protected int lastCharacterIndex;

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters}
     * of the specified {@link CharSequence}.
     *
     * @param iteratedCharSequence
     *        {@link CharSequence} to iterate
     */
    public CharSequenceIterator(final CharSequence iteratedCharSequence) {
        // a call to another constructor would throw an Exception for an empty iteratedCharSequence
        // also, the indices checks are skipped here
        this.iteratedCharSequence = iteratedCharSequence;
        this.nextCharacterIndex = 0;
        this.lastCharacterIndex = iteratedCharSequence.length() - 1;
    }

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters}
     * of the subsequence specified by the index of its first character
     * (inclusive) contained by the specified {@link CharSequence}.
     *
     * @param iteratedCharSequence
     *        {@link CharSequence} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedCharSequence.length()}
     */
    public CharSequenceIterator(final CharSequence iteratedCharSequence, final int firstCharacterIndex) {
        if (firstCharacterIndex < 0)
            throw new CharSequenceBeginIndexNegativeException(iteratedCharSequence, firstCharacterIndex);

        if (firstCharacterIndex >= iteratedCharSequence.length())
            throw new CharSequenceBeginIndexAboveBoundException(iteratedCharSequence, firstCharacterIndex);

        this.iteratedCharSequence = iteratedCharSequence;
        this.nextCharacterIndex = firstCharacterIndex;
        this.lastCharacterIndex = iteratedCharSequence.length() - 1;
    }

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters}
     * of the subsequence specified by the indices of its first and last
     * characters (inclusive) contained by the specified {@link CharSequence}.
     *
     * @param iteratedCharSequence
     *        {@link CharSequence} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @param lastCharacterIndex
     *        integer specifying the index of the last character of the
     *        subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceEndIndexBelowStartIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedCharSequence.length()}
     */
    public CharSequenceIterator(final CharSequence iteratedCharSequence, final int firstCharacterIndex,
                                final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowStartIndexException,
    CharSequenceEndIndexAboveBoundException {
        if (firstCharacterIndex < 0)
            throw new CharSequenceBeginIndexNegativeException(iteratedCharSequence, firstCharacterIndex);

        if (lastCharacterIndex < firstCharacterIndex)
            throw new CharSequenceEndIndexBelowStartIndexException(iteratedCharSequence, firstCharacterIndex,
                                                                   lastCharacterIndex);

        if (lastCharacterIndex >= iteratedCharSequence.length())
            throw new CharSequenceEndIndexAboveBoundException(iteratedCharSequence, lastCharacterIndex);

        this.iteratedCharSequence = iteratedCharSequence;
        this.nextCharacterIndex = firstCharacterIndex;
        this.lastCharacterIndex = lastCharacterIndex;
    }

    @Override
    public boolean hasNext() {
        return nextCharacterIndex <= lastCharacterIndex && nextCharacterIndex < iteratedCharSequence.length();
    }

    @Override
    public Character next() {
        if (!hasNext())
            throw new NoSuchItemException("['" + iteratedCharSequence + "', " + nextCharacterIndex + "]");
        return iteratedCharSequence.charAt(nextCharacterIndex ++);
    }
}
