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

import java.util.List;
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
     * Returns the Item stored at the specified index in this IndexSequence.
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
     * @return integer specifying the index of the first occurrence of
     *         {@code item}
     * @throws NoSuchSequenceItemException
     *         if this IndexSequence does not contain {@code item}
     */
    public int getFirstIndexOf(final Item item)
    throws NoSuchSequenceItemException;

    /**
     * Returns the index of the first occurrence of the specified Item in this
     * IndexSequence.
     * 
     * @param item
     *        Item to find
     * @return integer specifying the index of the first occurrence of
     *         {@code item}
     * @throws NoSuchSequenceItemException
     *         if this IndexSequence does not contain {@code item}
     */
    public int getLastIndexOf(final Item item)
    throws NoSuchSequenceItemException;

    /**
     * Returns a {@link List} containing the Items stored in this IndexSequence
     * in the specified index range in proper sequence.
     * 
     * @param fromIndex
     *        integer specifying the index of the first Item
     * @param toIndex
     *        integer specifying the index of the last Item
     * @return Sequence containing the specified Items
     * @throws IllegalArgumentException
     *         if {@code fromIndex > toIndex}
     * @throws InvalidSequenceIndexRangeException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     */
    public List<Item> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, InvalidSequenceIndexRangeException;

    /**
     * Returns an IndexSequence containing the Items stored in this
     * IndexSequence in the specified index range. The Items in the result
     * IndexSequence will have the same index as they had in this IndexSequence.
     * 
     * @param fromIndex
     *        integer specifying the index of the first Item
     * @param toIndex
     *        integer specifying the index of the last Item
     * @return IndexSequence containing the specified Items
     * @throws IllegalArgumentException
     *         if {@code fromIndex > toIndex}
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     */
    public IndexSequence<Item> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException;

    /**
     * Returns an IndexSequenceTraverser traversing the Items of this
     * IndexSequence in proper sequence. Initially, the Traverser points to the
     * beginning of this IndexSequence, that is, the Item returned by the first
     * call to {@code nextIndex()} is the Item stored at {@code getFirstIndex()}
     * .
     * 
     * @return {@link IndexSequenceTraverser} over this IndexSequence initially
     *         pointing to the beginning of this IndexSequence
     */
    public IndexSequenceTraverser<Item> createIndexSequenceTraverser();

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
     * @return IndexSequenceTraverser over this IndexSequence initially pointing
     *         to the beginning of this IndexSequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public IndexSequenceTraverser<Item> createIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Verifies whether the specified Object is an IndexSequence with the same
     * minimum and maximum indices and contains equal Items at the same indices.
     * Two Items {@code item1} and {@code item2} are equal if and only if both
     * are {@code null} or both are equal by the {@code equals()} method.
     * 
     * @param otherIndexSequence
     *        Object to compare to this IndexSequence
     * @return {@code true} if {@code indexSequence} is equal to this
     *         IndexSequence; {@code false} otherwise
     */
    @Override
    public boolean equals(final Object otherIndexSequence);
}
