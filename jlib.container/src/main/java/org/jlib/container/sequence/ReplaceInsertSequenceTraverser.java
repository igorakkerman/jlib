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

/**
 * {@link ReplaceSequenceTraverser} and {@link InsertSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceInsertSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertSequenceTraverser<Item>
extends ReplaceSequenceTraverser<Item>, InsertSequenceTraverser<Item> {
    // unifying interface
}
