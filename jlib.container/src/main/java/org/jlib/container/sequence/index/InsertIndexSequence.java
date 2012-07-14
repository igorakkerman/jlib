/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index;

import java.util.Iterator;

import org.jlib.container.Container;
import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.InsertSequenceTraverser;
import org.jlib.container.sequence.Sequence;

/**
 * {@link InsertSequence} and {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertIndexSequence<Item>
extends InsertSequence<Item>, IndexSequence<Item> {

    /**
     * Inserts the specified Item at the specified index in this
     * {@link IndexSequence}.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItem
     *        Item to insert
     */
    public void insert(int index, Item newItem);

    /**
     * Inserts all Items provided by the specified {@link Iterable} in the order
     * as provided by its {@link Iterator} at the specified index of this
     * {@link InsertIndexSequence}.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItems
     *        {@link Iterable} holding the Items to insert
     */
    public void insert(int index, Container<? extends Item> newItems);

    /**
     * @return {@link InsertIndexSequence} view of the specified subsequence
     */
    @Override
    public InsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * Returns an {@link InsertIndexSequenceTraverser} traversing the Items of
     * this {@link InsertIndexSequence} in proper sequence. That is, the Item
     * returned by the first call to
     * {@link InsertIndexSequenceTraverser#getNextItem()} is the Item stored at
     * the first index.
     * 
     * @return {@link InsertIndexSequenceTraverser} over the Items of this
     *         {@link InsertIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public InsertIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns an {@link InsertSequenceTraverser} traversing the Items of this
     * {@link InsertIndexSequence} in proper sequence. That is, the Item
     * returned by the first call to
     * {@link InsertSequenceTraverser#getNextItem()} is the Item stored at the
     * specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        Traverser
     * 
     * @return {@link InsertIndexSequenceTraverser} over the Items of this
     *         {@link InsertIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public InsertIndexSequenceTraverser<Item> createTraverser(int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
