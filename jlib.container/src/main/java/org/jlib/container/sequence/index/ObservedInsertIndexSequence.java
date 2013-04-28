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

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.ObservedInsertSequence;
import org.jlib.core.observer.ValueObserver;

/**
 * {@link IndexSequence} and {@link InsertSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ObservedInsertIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedInsertIndexSequence<Item>
extends ObservedInsertSequence<Item>, InsertIndexSequence<Item> {

    /**
     * Inserts the Item at the specified index in this
     * {@link ObservedInsertIndexSequence} by the specified Items.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param item
     *        item to store
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code item} prevents the operation from
     *         being performed
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs performing the operation
     */
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Item item, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException;

    /**
     * Inserts the specified Items at the specified index of this
     * {@link ObservedInsertIndexSequence}.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param items
     *        {@link Container} holding the Items to insert
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, Container<? extends Item> items, final ValueObserver<Item>... observers);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link ObservedInsertIndexSequence}.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param items
     *        {@link Collection} holding the Items to insert
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, Collection<? extends Item> items, final ValueObserver<Item>... observers);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link ObservedInsertIndexSequence}.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     * 
     * @param items
     *        comma separated sequence holding the Items to insert
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, final ValueObserver<Item>[] observers, Item... items);

    /**
     * @return {@link ObservedRemoveIndexSequenceTraverser} traversing the Items
     */
    @Override
    public ObservedInsertIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException;

    /**
     * @return {@link ObservedRemoveIndexSequenceTraverser} traversing the Items
     */
    @Override
    public ObservedInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
