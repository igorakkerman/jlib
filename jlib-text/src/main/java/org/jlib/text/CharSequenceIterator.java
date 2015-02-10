package org.jlib.text;

import java.util.Iterator;

import org.jlib.core.iterator.NoNextItemException;

import static org.jlib.core.message.MessageUtility.message;

/**
 * <p>
 * Iterator over the {@link Character}s of a {@link CharSequence}.
 * </p>
 * <p>
 * This implementation's {@link #remove()} method throws an {@link UnsupportedOperationException} as in general a
 * {@link CharSequence} does not necessarily support removal of {@link Character}s.
 * </p>
 * <p>
 * Subclasses may use covariance and imeplement {@link #remove()} for {@link CharSequence}s supporting removal of
 * {@link Character}s.
 * </p>
 *
 * @author Igor Akkerman
 */
public class CharSequenceIterator
implements Iterator<Character> {

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of a {@link CharSequence}.
     *
     * @param iterableCharSequence
     *        {@link CharSequence} to iterate
     *
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of {@code iterableCharSequence}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence) {
        return () -> new CharSequenceIterator(iterableCharSequence);
    }

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of the subsequence specified by the index of
     * its first character (inclusive) contained by the specified
     * {@link CharSequence}.
     *
     * @param iterableCharSequence
     *        {@link CharSequence} to traverse
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     *
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of the subsequence
     *
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedCharSequence.length()}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence, final int firstCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceBeginIndexAboveBoundException {
        return () -> new CharSequenceIterator(iterableCharSequence, firstCharacterIndex);
    }

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of the subsequence specified by the indices
     * of its first and last characters (inclusive) contained by the specified
     * {@link CharSequence}.
     *
     * @param iterableCharSequence
     *        {@link CharSequence} to traverse
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     *
     * @param lastCharacterIndex
     *        integer specifying the index of the last character of the
     *        subsequence
     *
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of the subsequence
     *
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceEndIndexBelowBeginIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     *
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedCharSequence.length()}
     */
    public static Iterable<Character> iterable(final CharSequence iterableCharSequence, final int firstCharacterIndex,
                                               final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowBeginIndexException,
           CharSequenceEndIndexAboveBoundException {
        return () -> new CharSequenceIterator(iterableCharSequence, firstCharacterIndex, lastCharacterIndex);
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

        nextCharacterIndex = 0;
        lastCharacterIndex = iteratedCharSequence.length() - 1;
    }

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters} of the subsequence specified by the
     * index of its first character (inclusive) contained by the specified {@link CharSequence}.
     *
     * @param iteratedCharSequence
     *        {@link CharSequence} to traverse
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the subsequence
     *
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedCharSequence.length()}
     */
    public CharSequenceIterator(final CharSequence iteratedCharSequence, final int firstCharacterIndex) {
        if (firstCharacterIndex < 0)
            throw new CharSequenceBeginIndexNegativeException(iteratedCharSequence, firstCharacterIndex);

        if (firstCharacterIndex >= iteratedCharSequence.length())
            throw new CharSequenceBeginIndexAboveBoundException(iteratedCharSequence, firstCharacterIndex);

        this.iteratedCharSequence = iteratedCharSequence;

        nextCharacterIndex = firstCharacterIndex;
        lastCharacterIndex = iteratedCharSequence.length() - 1;
    }

    /**
     * Creates a new {@link CharSequenceIterator} over the {@link Character}s of the subsequence specified by the
     * indices of its first and last {@link Character}s (inclusive) of the specified {@link CharSequence}.
     *
     * @param iteratedCharSequence
     *        {@link CharSequence} to traverse
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     *
     * @param lastCharacterIndex
     *        integer specifying the index of the last character of the
     *        subsequence
     *
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceEndIndexBelowBeginIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     *
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedCharSequence.length()}
     */
    public CharSequenceIterator(final CharSequence iteratedCharSequence, final int firstCharacterIndex,
                                final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowBeginIndexException,
           CharSequenceEndIndexAboveBoundException {
        if (firstCharacterIndex < 0)
            throw new CharSequenceBeginIndexNegativeException(iteratedCharSequence, firstCharacterIndex);

        if (lastCharacterIndex < firstCharacterIndex)
            throw new CharSequenceEndIndexBelowBeginIndexException(iteratedCharSequence, firstCharacterIndex,
                                                                   lastCharacterIndex);

        if (lastCharacterIndex >= iteratedCharSequence.length())
            throw new CharSequenceEndIndexAboveBoundException(iteratedCharSequence, lastCharacterIndex);

        this.iteratedCharSequence = iteratedCharSequence;

        nextCharacterIndex = firstCharacterIndex;
        this.lastCharacterIndex = lastCharacterIndex;
    }

    @Override
    public boolean hasNext() {
        return nextCharacterIndex <= lastCharacterIndex && nextCharacterIndex < iteratedCharSequence.length();
    }

    @Override
    public Character next() {
        if (! hasNext())
            throw new NoNextItemException("characterSequence", iteratedCharSequence,
                                          message().with("nextCharacterIndex", nextCharacterIndex));

        return iteratedCharSequence.charAt(nextCharacterIndex++);
    }
}
