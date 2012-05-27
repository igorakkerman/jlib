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

import org.jlib.container.sequence.NoSuchSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;

/**
 * Traverser over an IndexSequence.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface IndexSequenceTraverser<Item>
extends SequenceTraverser<Item> {

    /**
     * Returns the previous Item of this Traverser.
     * 
     * @return the previous Item of this Traverser
     * 
     * @throws NoSuchSequenceItemException
     *         sif there is no previous Item
     */
    public int getPreviousItemIndex()
    throws NoSuchSequenceItemException;

    /**
     * Returns the next Item of this Traverser.
     * 
     * @return the next Item of this Traverser; returns
     *         {@code getLastIndex() + 1} if there is no next Item
     * 
     * @throws NoSuchSequenceItemException
     *         sif there is no next Item
     */
    public int getNextItemIndex()
    throws NoSuchSequenceItemException;
}
