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

package org.jlib.container.sequence;

import org.jlib.core.traverser.RemoveTraverser;

/**
 * Traverser over a {@link RemoveSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveSequenceTraverser<Item>
extends SequenceTraverser<Item>, RemoveTraverser<Item> {

    @Override
    public void remove()
    throws NoItemToRemoveException;
}
