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
 * {@link ReplaceAppendSequence} and {@link ReplacePrependSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceAppendPrependSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceAppendPrependSequence<Item>
extends ReplaceAppendSequence<Item>, ReplacePrependSequence<Item> {
    // unifying interface
}
