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

import org.jlib.container.sequence.ReplaceSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} and {@link ReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequenceTraverser<Item>
extends IndexSequenceTraverser<Item>, ReplaceSequenceTraverser<Item> {
    // unifying interface
}
