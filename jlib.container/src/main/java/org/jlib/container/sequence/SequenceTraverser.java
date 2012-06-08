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

import org.jlib.core.traverser.BidirectionalTraverser;

/**
 * {@link BidirectionalTraverser} over the Items of a {@link Sequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceTraverser<Item>
extends BidirectionalTraverser<Item> {

    /**
     * Returns the previous Item of this {@link SequenceTraverser}.
     * 
     * @return the previous Item
     * 
     * @throws NoPreviousSequenceItemException
     *         if there is no previous Item
     */
    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException;

    /**
     * Returns the next Item of this {@link SequenceTraverser}.
     * 
     * @return the next Item
     * 
     * @throws NoNextSequenceItemException
     *         if there is no next Item
     */
    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException;
}
