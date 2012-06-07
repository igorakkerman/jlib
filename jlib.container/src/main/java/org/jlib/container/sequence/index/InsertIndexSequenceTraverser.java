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

import org.jlib.container.sequence.InsertSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} and {@link InsertSequenceTraverser} over an
 * {@link InsertIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link InsertIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertIndexSequenceTraverser<Item>
extends IndexSequenceTraverser<Item>, InsertSequenceTraverser<Item> {
    // unifying interface
}
