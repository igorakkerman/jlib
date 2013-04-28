/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedRemoveFirstSequence;

/**
 * {@link ObservedReplaceInsertIndexSequence} and
 * {@link ObservedRemoveFirstSequence}.
 * 
 * @param <Item>
 *        type of items held in the
 *        {@link ObservedReplaceInsertRemoveFirstIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertRemoveFirstIndexSequence<Item>
extends ObservedReplaceInsertIndexSequence<Item>, ObservedRemoveFirstSequence<Item> {
    // unifying interface
}
