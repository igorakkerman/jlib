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

import org.jlib.container.sequence.ObservedRemoveSequenceTraverser;
import org.jlib.container.sequence.ObservedReplaceRemoveSequenceTraverser;
import org.jlib.container.sequence.ObservedReplaceSequenceTraverser;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ObservedReplaceSequenceTraverser} and
 * {@link ObservedRemoveSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ObservedReplaceRemoveIndexSequenceTraverser<Item>
extends ObservedReplaceRemoveSequenceTraverser<Item>, ObservedInsertSequenceTraverser<Item> {
    // unifying interface
}
