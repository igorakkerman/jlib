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

import java.util.Optional;

import org.jlib.core.iterator.NoItemToRemoveException;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * Iterator over the {@link Character}s of a {@link StringBuilder}.
 *
 * @author Igor Akkerman
 */
public class StringBuilderIterator
extends CharSequenceIterator {

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
     * @param iterableStringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first {@link Character} of the
     *        subsequence
     *
     * @return {@link Iterable} creating StringBuilderIterators over the
     *         {@link Character}s of the subsequence
     *
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedStringBuilder.length()}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder, final int firstCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceBeginIndexAboveBoundException {
        return () -> new StringBuilderIterator(iterableStringBuilder, firstCharacterIndex);
    }

    /**
     * Returns an {@link Iterable} creating {@link StringBuilderIterator}s over the {@link Character}s of the
     * subsequence specified by the indices of its first and last {@link Character}s (inclusive) contained by the
     * specified {@link StringBuilder}.
     *
     * @param iterableStringBuilder
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
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceEndIndexBelowBeginIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     *
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedStringBuilder.length()}
     */
    public static Iterable<Character> iterable(final StringBuilder iterableStringBuilder, final int firstCharacterIndex,
                                               final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowBeginIndexException,
           CharSequenceEndIndexAboveBoundException {
        return () -> new StringBuilderIterator(iterableStringBuilder, firstCharacterIndex, lastCharacterIndex);
    }

    /** {@link StringBuilder} iterated by this StringBuilderIterator */
    private final StringBuilder iteratedStringBuilder;

    /** last {@link Character} returned by {@link #next()} */
    private Optional<Character> lastReturnedCharacter = empty();

    /**
     * Creates a new {@link StringBuilderIterator} over the {@link Character}s of the specified {@link StringBuilder}.
     *
     * @param iteratedStringBuilder
     *        {@link StringBuilder} to iterate
     */
    public StringBuilderIterator(final StringBuilder iteratedStringBuilder) {
        super(iteratedStringBuilder);
        this.iteratedStringBuilder = iteratedStringBuilder;
    }

    /**
     * Creates a new StringBuilderIterator over the {@link Character}s of the subsequence specified by the index of its
     * first {@link Character} (inclusive) contained by the specified {@link StringBuilder}.
     *
     * @param iteratedStringBuilder
     *        {@link StringBuilder} to iterate
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first {@link Character} of the  subsequence
     *
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceBeginIndexAboveBoundException
     *         if {@code firstCharacterIndex >= iteratedStringBuilder.length()}
     */
    public StringBuilderIterator(final StringBuilder iteratedStringBuilder, final int firstCharacterIndex) {
        super(iteratedStringBuilder, firstCharacterIndex);
        this.iteratedStringBuilder = iteratedStringBuilder;
    }

    /**
     * Creates a new StringBuilderIterator over the {@link Character}s of the subsequence specified by the indices of
     * its first and last {@link Character}s (inclusive) contained by the specified {@link StringBuilder}.
     *
     * @param iteratedStringBuilder
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
     * @throws CharSequenceBeginIndexNegativeException
     *         if {@code firstCharacterIndex < 0}
     *
     * @throws CharSequenceEndIndexBelowBeginIndexException
     *         if {@code lastCharacterIndex < firstCharacterIndex}
     *
     * @throws CharSequenceEndIndexAboveBoundException
     *         if {@code lastCharacterIndex >= iteratedStringBuilder.length()}
     */
    public StringBuilderIterator(final StringBuilder iteratedStringBuilder, final int firstCharacterIndex,
                                 final int lastCharacterIndex)
    throws CharSequenceBeginIndexNegativeException, CharSequenceEndIndexBelowBeginIndexException,
           CharSequenceEndIndexAboveBoundException {
        super(iteratedStringBuilder, firstCharacterIndex, lastCharacterIndex);
        this.iteratedStringBuilder = iteratedStringBuilder;
    }

    @Override
    public Character next() {
        final Character lastReturnedCharacter = super.next();
        this.lastReturnedCharacter = of(lastReturnedCharacter);
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
        if (! lastReturnedCharacter.isPresent())
            throw new NoItemToRemoveException(iteratedStringBuilder);

        iteratedStringBuilder.deleteCharAt(nextCharacterIndex - 1);
        lastCharacterIndex--;
    }
}
