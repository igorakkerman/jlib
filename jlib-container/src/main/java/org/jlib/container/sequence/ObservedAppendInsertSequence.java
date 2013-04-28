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
 * {@link ObservedInsertSequence} and {@link ObservedAppendSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ObservedAppendInsertSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedAppendInsertSequence<Item>
extends AppendInsertSequence<Item>, ObservedInsertSequence<Item>, ObservedAppendSequence<Item> {
    // unifying interface
}
