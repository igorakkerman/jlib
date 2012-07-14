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

import org.jlib.core.traverser.ObservedReplaceTraverser;

/**
 * {@link ObservedReplaceTraverser} of an {@link ObservedReplaceSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceSequenceTraverser<Item>
extends ObservedReplaceTraverser<Item>, ReplaceSequenceTraverser<Item> {
    // unifying interface
}
