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
public interface ObservedReplaceInsertRemoveIndexSequence<Item>
extends ReplaceInsertRemoveIndexSequence<Item>, ObservedReplaceInsertIndexSequence<Item>,
ObservedInsertRemoveIndexSequence<Item>, ObservedReplaceRemoveIndexSequence<Item> {

    @Override
    public ObservedReplaceInsertRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    @Override
    public ObservedReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException;

    @Override
    public ObservedReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
