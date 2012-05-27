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

import org.jlib.container.Container;
import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceIndexSequence} that allows Items to be added and removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertIndexSequence<Item>
extends InsertSequence<Item>, IndexSequence<Item> {

    /**
     * Returns an {@link InsertIndexSequenceTraverser} traversing the Items of
     * this Sequence in proper sequence. Initially, the Traverser points to the
     * beginning of this Sequence, that is, the Item returned by the first
     * call to {@link InsertIndexSequenceTraverser#next()} is the Item stored at
     * {@link #getFirstIndex()}.
     * 
     * @return InsertIndexSequenceTraverser over this IndexSequence initially
     *         pointing to the beginning of this Sequence
     */
    @Override
    public InsertIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns a InsertIndexSequenceTraverser traversing the Items of this
     * Sequence in proper sequence. That is, the Item returned by the first
     * call to {@link InsertIndexSequenceTraverser#next()} is the Item stored at
     * the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        Traverser
     * 
     * @return InsertIndexSequenceTraverser over this Sequence initially pointing to
     *         the beginning of this Sequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public InsertIndexSequenceTraverser<Item> createTraverser(int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Inserts the specified Item at the specified index in this
     * IndexSequence.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param item
     *        Item to add
     */
    public void insert(int index, Item item);

    /**
     * Inserts all Items of the specified Container at the specified index of
     * this IndexSequence. The Items are inserted in the order they are
     * returned by the Container's Traverser.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param items
     *        Container holding the Items to add
     */
    public void insert(int index, Container<? extends Item> items);
}
