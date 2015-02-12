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
     * @param charSequence
     *        {@link CharSequence} to iterate
     *
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of {@code charSequence}
     */
    public static Iterable<Character> iterable(final CharSequence charSequence) {
        return () -> new CharSequenceIterator(charSequence);
    }

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of the subsequence specified by the index of
     * its first character (inclusive) contained by the specified
     * {@link CharSequence}.
     *
     * @param charSequence
     *        {@link CharSequence} to traverse
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the
     *        subsequence
     *
     * @return {@link Iterable} creating CharSequenceIterators over the
     *         {@link Character Characters} of the subsequence
     *
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code firstCharacterIndex > charSequence.length() - 1}</li>
     *         </ul>
     */
    public static Iterable<Character> iterable(final CharSequence charSequence, final int firstCharacterIndex)
    throws CharSequenceIndexOutOfBoundsException {
        return () -> new CharSequenceIterator(charSequence, firstCharacterIndex);
    }

    /**
     * Returns an {@link Iterable} creating CharSequenceIterators over the
     * {@link Character Characters} of the subsequence specified by the indices
     * of its first and last characters (inclusive) contained by the specified
     * {@link CharSequence}.
     *
     * @param charSequence
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
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code lastCharacterIndex < firstCharacterIndex}</li>
     *             <li>{@code lastCharacterIndex > charSequence.length() - 1}</li>
     *         </ul>
     */
    public static Iterable<Character> iterable(final CharSequence charSequence, final int firstCharacterIndex,
                                               final int lastCharacterIndex)
    throws CharSequenceIndexOutOfBoundsException {
        return () -> new CharSequenceIterator(charSequence, firstCharacterIndex, lastCharacterIndex);
    }

    /** {@link CharSequence} iterated by this CharSequenceIterator */
    private final CharSequence charSequence;

    /** index of next iterated character */
    protected int nextCharacterIndex;

    /** index of last iterated character */
    protected int lastCharacterIndex;

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters}
     * of the specified {@link CharSequence}.
     *
     * @param charSequence
     *        {@link CharSequence} to iterate
     */
    public CharSequenceIterator(final CharSequence charSequence) {
        // a call to another constructor would throw an Exception for an empty charSequence
        // also, the indices checks are skipped here
        this.charSequence = charSequence;

        nextCharacterIndex = 0;
        lastCharacterIndex = charSequence.length() - 1;
    }

    /**
     * Creates a new CharSequenceIterator over the {@link Character Characters} of the subsequence specified by the
     * index of its first character (inclusive) contained by the specified {@link CharSequence}.
     *
     * @param charSequence
     *        {@link CharSequence} to traverse
     *
     * @param firstCharacterIndex
     *        integer specifying the index of the first character of the subsequence
     *
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code firstCharacterIndex > charSequence.length() - 1}</li>
     *         </ul>
     */
    public CharSequenceIterator(final CharSequence charSequence, final int firstCharacterIndex)
    throws CharSequenceIndexOutOfBoundsException {

        TextUtility.ensureIndicesValid(charSequence, firstCharacterIndex, charSequence.length() - 1);

        this.charSequence = charSequence;
        nextCharacterIndex = firstCharacterIndex;
        lastCharacterIndex = charSequence.length() - 1;
    }

    /**
     * Creates a new {@link CharSequenceIterator} over the {@link Character}s of the subsequence specified by the
     * indices of its first and last {@link Character}s (inclusive) of the specified {@link CharSequence}.
     *
     * @param charSequence
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
     * @throws CharSequenceIndexOutOfBoundsException
     *         if one of the following conditions is true:
     *         <ul>
     *             <li>{@code firstCharacterIndex < 0}</li>
     *             <li>{@code lastCharacterIndex < firstCharacterIndex}</li>
     *             <li>{@code lastCharacterIndex > charSequence.length() - 1}</li>
     *         </ul>
     */
    public CharSequenceIterator(final CharSequence charSequence, final int firstCharacterIndex,
                                final int lastCharacterIndex)
    throws CharSequenceIndexOutOfBoundsException {

        TextUtility.ensureIndicesValid(charSequence, firstCharacterIndex, charSequence.length() - 1);

        this.charSequence = charSequence;
        nextCharacterIndex = firstCharacterIndex;
        this.lastCharacterIndex = lastCharacterIndex;
    }

    @Override
    public boolean hasNext() {
        return nextCharacterIndex <= lastCharacterIndex && nextCharacterIndex < charSequence.length();
    }

    @Override
    public Character next() {
        if (! hasNext())
            throw new NoNextItemException("characterSequence", charSequence,
                                          message().with("nextCharacterIndex", nextCharacterIndex));

        return charSequence.charAt(nextCharacterIndex++);
    }
}
