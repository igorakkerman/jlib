/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

import java.util.RandomAccess;

/**
 * Non-empty {@link Sequence} allowing random access to its Items using their
 * index. The index may range from a specified minimum to a specified maximum.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface IndexSequence<Item>
extends Sequence<Item>, RandomAccess {

    /**
     * Returns the Item stored at the specified index in this
     * {@link IndexSequence}.
     *
     * @param index
     *        integer specifying the index of the stored Item
     *
     * @return Item stored at {@code index}
     *
     * @throws InvalidSequenceIndexException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    public Item get(int index)
    throws InvalidSequenceIndexException;

    /**
     * Returns the first index of this {@link IndexSequence}.
     *
     * @return integer specifying the minimum index
     */
    public int getFirstIndex();

    /**
     * Returns the last index of this {@link IndexSequence}.
     *
     * @return integer specifying the maximum index
     */
    public int getLastIndex();

    /**
     * Returns the Item stored at the first index in this {@link IndexSequence}.
     *
     * @return first Item
     */
    public Item getFirstItem();

    /**
     * Returns the Item stored at the last index in this {@link IndexSequence}.
     *
     * @return last Item
     */
    public Item getLastItem();

    /**
     * Returns the index of the first occurrence of the specified Item in this
     * IndexSequence.
     *
     * @param item
     *        Item to find
     *
     * @return integer specifying the index of the first occurrence of
     *         {@code item}
     *
     * @throws NoSuchSequenceItemException
     *         if this {@link IndexSequence} does not contain {@code item}
     */
    public int getItemIndex(Item item)
    throws NoSuchSequenceItemException;

    /**
     * Returns the index of the last occurrence of the specified Item in this
     * IndexSequence.
     *
     * @param item
     *        Item to find
     *
     * @return integer specifying the index of the first occurrence of
     *         {@code item}
     *
     * @throws NoSuchSequenceItemException
     *         if this {@link IndexSequence} does not contain {@code item}
     */
    public int getLastItemIndex(Item item)
    throws NoSuchSequenceItemException;

    /**
     * Returns an {@link IndexSequence} view of the Items stored in this
     * {@link IndexSequence} in the specified index range. The Items in the
     * result {@link IndexSequence} will have the same index as they had in this
     * {@link IndexSequence}.
     *
     * @param fromIndex
     *        integer specifying the index of the first Item
     *
     * @param toIndex
     *        integer specifying the index of the last Item
     *
     * @return {@link IndexSequence} view of the specified subsequence
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     *
     * @throws InvalidSequenceIndexRangeException
     *         if {@code fromIndex > toIndex}
     */
    public IndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws InvalidSequenceIndexException, InvalidSequenceIndexRangeException;

    /**
     * Returns an IndexSequenceTraverser traversing the Items of this
     * IndexSequence in proper sequence. Initially, the Traverser points to the
     * beginning of this {@link IndexSequence}, that is, the Item returned by
     * the first call to {@code nextIndex()} is the Item stored at
     * {@code getFirstIndex()} .
     *
     * @return {@link IndexSequenceTraverser} over the Items of this
     *         {@link IndexSequence} initially pointing to the beginning of this
     *         {@link IndexSequence}
     */
    @Override
    public IndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns an {@link IndexSequenceTraverser} traversing the Items of this
     * IndexSequence in proper sequence. That is, the Item returned by the first
     * call to {@code nextIndex()} is the Item stored at the specified start
     * index.
     *
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        Traverser
     *
     * @return IndexSequenceTraverser over the Items of this
     *         {@link IndexSequence} initially pointing to the beginning of this
     *         {@link IndexSequence}
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public IndexSequenceTraverser<Item> createTraverser(int startIndex)
    throws InvalidSequenceIndexException;

    /**
     * {@inheritDoc}
     *
     * Additionally, for an {@link IndexSequence}, the following conditions must
     * be satisfied:
     *
     * <ul>
     * <li>this {@link IndexSequence} and the specified {@link IndexSequence}
     * have the same minimum and maximum indices</li>
     * </ul>
     *
     * @param otherObject
     *        Object to compare to this {@link IndexSequence}
     *
     * @return {@code true} if {@code otherObject} is equal to this
     *         {@link IndexSequence}; {@code false} otherwise
     */
    @Override
    public boolean equals(Object otherObject);
}
