/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.text;

import org.jlib.iterator.NoItemToRemoveException;

/**
 * Iterator over the {@link Character}s of a {@link StringBuilder}.
 *
 * @author Igor Akkerman
 */
public class StringBuilderIterator
    extends CharSequenceIterator {

    /** {@link StringBuilder} iterated by this StringBuilderIterator */
    private final StringBuilder stringBuilder;
    /** last {@link Character} returned by {@link #next()} */
    private Character lastReturnedCharacter = null;

    /**
     * Creates a new {@link StringBuilderIterator} over the {@link Character}s of the specified {@link StringBuilder}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} to iterate
     */
    public StringBuilderIterator(final StringBuilder stringBuilder) {
        super(stringBuilder);
        this.stringBuilder = stringBuilder;
    }

    /**
     * Creates a new StringBuilderIterator over the {@link Character}s of the subsequence specified by the index of its
     * first {@link Character} (inclusive) contained by the specified {@link StringBuilder}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first {@link Character} of the  subsequence
     *
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code firstCharacterIndex > stringBuilder.length() - 1}</li>
     *         </ul>
     */
    public StringBuilderIterator(final StringBuilder stringBuilder, final int firstCharacterIndex)
        throws CharSequenceIndexOutOfBoundsException {
        super(stringBuilder, firstCharacterIndex);
        this.stringBuilder = stringBuilder;
    }

    /**
     * Creates a new StringBuilderIterator over the {@link Character}s of the subsequence specified by the indices of
     * its first and last {@link Character}s (inclusive) contained by the specified {@link StringBuilder}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first {@link Character} of the
     *        subsequence
     *
     * @param lastCharacterIndex
     *        integer specifying the index of the last {@link Character} of the
     *        subsequence
     *
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code lastCharacterIndex < firstCharacterIndex}</li>
     *             <li>{@code lastCharacterIndex > stringBuilder.length() - 1}</li>
     *         </ul>
     */
    public StringBuilderIterator(final StringBuilder stringBuilder, final int firstCharacterIndex,
                                 final int lastCharacterIndex)
        throws CharSequenceIndexOutOfBoundsException {
        super(stringBuilder, firstCharacterIndex, lastCharacterIndex);
        this.stringBuilder = stringBuilder;
    }

    /**
     * Returns an {@link Iterable} creating StringBuilderIterators over the
     * {@link Character}s of a {@link StringBuilder}.
     *
     * @param iterableStringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character}s of {@code iterableStringBuilder}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder) {
        return () -> new StringBuilderIterator(iterableStringBuilder);
    }

    /**
     * Returns an {@link Iterable} creating {@link StringBuilderIterator}s over the {@link Character}s of the
     * subsequence specified by the index of its first {@link Character} (inclusive) contained by the specified
     * {@link StringBuilder}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first {@link Character} of the
     *        subsequence
     *
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character}s of the subsequence
     *
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code firstCharacterIndex > stringBuilder.length() - 1}</li>
     *         </ul>
     */
    public static Iterable<Character> iterable(final StringBuilder stringBuilder, final int firstCharacterIndex)
        throws CharSequenceIndexOutOfBoundsException {
        return () -> new StringBuilderIterator(stringBuilder, firstCharacterIndex);
    }

    /**
     * Returns an {@link Iterable} creating {@link StringBuilderIterator}s over the {@link Character}s of the
     * subsequence specified by the indices of its first and last {@link Character}s (inclusive) contained by the
     * specified {@link StringBuilder}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first {@link Character} of the subsequence
     *
     * @param lastCharacterIndex
     *        integer specifying the index of the last {@link Character} of the
     *        subsequence
     *
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character}s of the subsequence
     *
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code lastCharacterIndex < firstCharacterIndex}</li>
     *             <li>{@code lastCharacterIndex > stringBuilder.length() - 1}</li>
     *         </ul>
     */
    public static Iterable<Character> iterable(final StringBuilder stringBuilder, final int firstCharacterIndex,
                                               final int lastCharacterIndex)
        throws CharSequenceIndexOutOfBoundsException {
        return () -> new StringBuilderIterator(stringBuilder, firstCharacterIndex, lastCharacterIndex);
    }

    @Override
    public Character next() {
        final Character lastReturnedCharacter = super.next();
        this.lastReturnedCharacter = lastReturnedCharacter;
        return lastReturnedCharacter;
    }

    /**
     * Deletes the last {@link Character} returned by this {@link StringBuilderIterator} from the {@link StringBuilder}.
     *
     * @throws IllegalStateException
     *         if no {@link Character} has been returned yet
     */
    @Override
    public void remove() {
        if (lastReturnedCharacter != null)
            throw new NoItemToRemoveException(stringBuilder);

        stringBuilder.deleteCharAt(nextCharacterIndex - 1);
        lastCharacterIndex--;
    }
}
