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
 * {@link AppendPrependInsertSequence}, {@link ObservedAppendPrependSequence}
 * and {@link ObservedInsertSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ObservedAppendPrependInsertSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedAppendPrependInsertSequence<Item>
extends AppendPrependInsertSequence<Item>, ObservedAppendPrependSequence<Item>, ObservedInsertSequence<Item> {
    // unifying interface
}
