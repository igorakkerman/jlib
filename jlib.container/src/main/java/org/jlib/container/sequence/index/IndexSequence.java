/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index;

import java.util.RandomAccess;

import org.jlib.container.sequence.Sequence;

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
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    public Item get(final int index)
    throws SequenceIndexOutOfBoundsException;

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
    public int getItemIndex(final Item item)
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
    public int getLastItemIndex(final Item item)
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
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code fromIndex > toIndex}
     */
    public IndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

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
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public IndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

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
    public boolean equals(final Object otherObject);
}
