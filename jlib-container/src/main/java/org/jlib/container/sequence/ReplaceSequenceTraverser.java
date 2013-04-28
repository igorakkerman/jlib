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

import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link ReplaceTraverser} and {@link SequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceSequenceTraverser<Item>
extends ReplaceTraverser<Item>, SequenceTraverser<Item> {

    /**
     * Replaces the last Item returned by {@code previous()} or {@code next()}
     * with the specified value.
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @throws NoSequenceItemToReplaceException
     *         if no Item has been returned by this
     *         {@link ReplaceSequenceTraverser}
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code newItem} prevents it from replacing
     *         the former Item
     */
    @Override
    public void replace(final Item newItem)
    throws NoSequenceItemToReplaceException, IllegalSequenceArgumentException;
}
