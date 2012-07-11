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
 * {@link Traverser} allowing to traverse Items forward and backwards.
 * 
 * @param <Item>
 *        type of items traversed by the {@link TwoWayTraverser}
 * 
 * @author Igor Akkerman
 */
public interface TwoWayTraverser<Item>
extends Traverser<Item> {

    /**
     * Verifies whether this {@link TwoWayTraverser} has a previous Item.
     * 
     * @return {@code true} if this {@link TwoWayTraverser} has a previous Item;
     *         {@code false} otherwise
     */
    public boolean isPreviousItemAccessible();

    /**
     * Returns the previous Item of this {@link TwoWayTraverser}.
     * 
     * @return the previous Item
     * 
     * @throws NoPreviousItemException
     *         if there is no previous Item
     */
    public Item getPreviousItem()
    throws NoPreviousItemException;
}
