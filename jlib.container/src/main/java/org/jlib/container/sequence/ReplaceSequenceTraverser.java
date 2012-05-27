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

import org.jlib.container.ReplaceContainerTraverser;

/**
 * Traverser of an ReplaceSequence.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceSequenceTraverser<Item>
extends ReplaceContainerTraverser<Item>, SequenceTraverser<Item> {

    /**
     * Replaces the last Item returned by {@code previous()} or
     * {@code next()} with the specified value.
     * 
     * @param item
     *        Item by which the former Item is replaced
     * 
     * @throws NoItemToReplaceException
     *         if no Item has been returned by this
     *         {@link ReplaceSequenceTraverser}
     */
    @Override
    public void replace(final Item item)
    throws NoItemToReplaceException;
}
