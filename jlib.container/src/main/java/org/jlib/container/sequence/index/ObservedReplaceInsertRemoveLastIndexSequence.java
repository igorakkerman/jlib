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

import org.jlib.container.sequence.Sequence;

/**
 * {@link ObservedReplaceInsertIndexSequence} and
 * {@link ObservedRemoveIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertRemoveLastIndexSequence<Item>
extends ObservedReplaceInsertIndexSequence<Item>, ObservedRemoveLastIndexSequence<Item> {

    @Override
    public ObservedReplaceInsertRemoveLastIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;
}
