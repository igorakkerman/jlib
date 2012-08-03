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
 * {@link AppendPrependSequence}, {@link AppendInsertSequence} and
 * {@link PrependInsertSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link AppendPrependInsertSequence}
 * 
 * @author Igor Akkerman
 */
public interface AppendPrependInsertSequence<Item>
extends AppendPrependSequence<Item>, AppendInsertSequence<Item>, PrependInsertSequence<Item> {
    // unifying interface
}
