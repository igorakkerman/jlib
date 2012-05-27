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

package org.jlib.container.sequence;

import org.jlib.container.Traverser;

/**
 * {@link Traverser} over the Items of a {@link Sequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceTraverser<Item>
extends Traverser<Item> {

    /**
     * Verifies whether this {@link SequenceTraverser} has a previous Item.
     * 
     * @return {@code true} if this {@link SequenceTraverser} has a previous
     *         Item; {@code false} otherwise
     */
    public boolean hasPrevious();

    /**
     * Returns the previous Item of this {@link SequenceTraverser}.
     * 
     * @return the previous Item
     * 
     * @throws NoSuchSequenceItemException
     *         if there is no previous Item
     */
    public Item previous()
    throws NoSuchSequenceItemException;

    /**
     * Verifies whether this {@link SequenceTraverser} has a next Item.
     * 
     * @return {@code true} if this {@link SequenceTraverser} has a next Item;
     *         {@code false} otherwise
     */
    @Override
    public boolean hasNext();

    /**
     * Returns the next Item of this {@link SequenceTraverser}.
     * 
     * @return the next Item
     * 
     * @throws NoSuchSequenceItemException
     *         if there is no next Item
     */
    @Override
    public Item next()
    throws NoSuchSequenceItemException;
}
