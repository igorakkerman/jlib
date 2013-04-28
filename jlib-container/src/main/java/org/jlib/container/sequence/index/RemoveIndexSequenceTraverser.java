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

import org.jlib.container.sequence.RemoveSequenceTraverser;

/**
 * Traverser over an IndexSequence.
 * 
 * @param <Item>
 *        type of items held in the {@link RemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveIndexSequenceTraverser<Item>
extends IndexSequenceTraverser<Item>, RemoveSequenceTraverser<Item> {
    // unifying interface
}
