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

/**
 * {@link ReplaceInsertIndexSequenceTraverser} and
 * {@link RemoveIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the
 *        {@link ReplaceInsertRemoveIndexSequenceTraverser}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertRemoveIndexSequenceTraverser<Item>
extends ReplaceInsertIndexSequenceTraverser<Item>, RemoveIndexSequenceTraverser<Item> {
    // unifying interface
}
