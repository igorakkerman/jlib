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

package org.jlib.core.traverser;

/**
 * {@link Traverser} allowing to traverse the Items forward and backwards.
 * 
 * @param <Item>
 *        type of items traversed by the {@link BidirectionalTraverser}
 * 
 * @author Igor Akkerman
 */
public interface BidirectionalTraverser<Item>
extends Traverser<Item> {

    /**
     * Verifies whether this {@link BidirectionalTraverser} has a previous Item.
     * 
     * @return {@code true} if this {@link BidirectionalTraverser} has a
     *         previous Item; {@code false} otherwise
     */
    public boolean isPreviousItemAccessible();

    /**
     * Returns the previous Item of this {@link BidirectionalTraverser}.
     * 
     * @return the previous Item
     * 
     * @throws NoPreviousItemException
     *         if there is no previous Item
     */
    public Item getPreviousItem()
    throws NoPreviousItemException;

    /**
     * Verifies whether this {@link BidirectionalTraverser} has a next Item.
     * 
     * @return {@code true} if this {@link BidirectionalTraverser} has a next
     *         Item; {@code false} otherwise
     */
    @Override
    public boolean isNextItemAccessible();

    /**
     * Returns the next Item of this {@link BidirectionalTraverser}.
     * 
     * @return the next Item
     * 
     * @throws NoNextItemException
     *         if there is no next Item
     */
    @Override
    public Item getNextItem()
    throws NoNextItemException;
}
