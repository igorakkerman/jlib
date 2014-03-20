package org.jlib.text;



/**
 * Iterator over the {@link Character Characters} of a {@link StringBuilder}.
 *
 * @author Igor Akkerman
 */
public class StringBuilderIterator
extends CharSequenceIterator {

    /**
     * Returns an {@link Iterable} creating StringBuilderIterators over the
     * {@link Character Characters} of a {@link StringBuilder}.
     *
     * @param iterableStringBuilder
     *        {@link StringBuilder} to iterate
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character Characters} of {@code iterableStringBuilder}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder) {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new StringBuilderIterator(iterableStringBuilder);
            }
        };
    }

    /**
     * Returns an {@link Iterable} creating StringBuilderIterators over the
     * {@link Character Characters} of the subsequence specified by the index of
     * its first character (inclusive) contained by the specified
     * {@link StringBuilder}.
     *
     * @param iterableStringBuilder
     *        {@link StringBuilder} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character Characters} of the subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedStringBuilder.length()}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder, final int firstCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceBeginIndexAboveBoundException {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new StringBuilderIterator(iterableStringBuilder, firstCharacterIndex);
            }
        };
    }

    /**
     * Returns an {@link Iterable} creating StringBuilderIterators over the
     * {@link Character Characters} of the subsequence specified by the indices
     * of its first and last characters (inclusive) contained by the specified
     * {@link StringBuilder}.
     *
     * @param iterableStringBuilder
     *        {@link StringBuilder} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @param lastCharacterIndex
     *        integer specifying the index of the last character of the
     *        subsequence
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character Characters} of the subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceEndIndexBelowStartIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedStringBuilder.length()}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder, final int firstCharacterIndex,
                                               final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowStartIndexException,
    CharSequenceEndIndexAboveBoundException {
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return new StringBuilderIterator(iterableStringBuilder, firstCharacterIndex, lastCharacterIndex);
            }
        };
    }

    /** {@link StringBuilder} iterated by this StringBuilderIterator */
    private final StringBuilder iteratedStringBuilder;

    /** last {@link Character} returned by {@link #next()} */
    private Character lastReturnedCharacter = null;

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
     * Creates a new StringBuilderIterator over the {@link Character Characters}
     * of the subsequence specified by the index of its first character
     * (inclusive) contained by the specified {@link StringBuilder}.
     *
     * @param iteratedStringBuilder
     *        {@link StringBuilder} to iterate
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedStringBuilder.length()}
     */
    public StringBuilderIterator(StringBuilder iteratedStringBuilder, int firstCharacterIndex) {
        super(iteratedStringBuilder, firstCharacterIndex);
        this.iteratedStringBuilder = iteratedStringBuilder;
    }

    /**
     * Creates a new StringBuilderIterator over the {@link Character Characters}
     * of the subsequence specified by the indices of its first and last
     * characters (inclusive) contained by the specified {@link StringBuilder}.
     *
     * @param iteratedStringBuilder
     *        {@link StringBuilder} to iterate
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
     *         if {@code lastCharacterIndex >= iteratedStringBuilder.length()}
     */
    public StringBuilderIterator(StringBuilder iteratedStringBuilder, int firstCharacterIndex, int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowStartIndexException,
    CharSequenceEndIndexAboveBoundException {
        super(iteratedStringBuilder, firstCharacterIndex, lastCharacterIndex);
        this.iteratedStringBuilder = iteratedStringBuilder;
    }


    @Override
    public Character next() {
        lastReturnedCharacter = super.next();
        return lastReturnedCharacter;
    }

    /**
     * Deletes the last {@link Character} returned by this StringBuilderIterator
     * from the {@link StringBuilder}.
     *
     * @throws IllegalStateException
     *         if no {@link Character} has been returned yet
     */
    @Override
    public void remove() {
        if (lastReturnedCharacter == null)
            throw new IllegalStateException();

        iteratedStringBuilder.deleteCharAt(nextCharacterIndex - 1);
        lastCharacterIndex --;
    }
}
