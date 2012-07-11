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

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceIndexSequence} and {@link AppendSequence} .
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceAppendIndexSequence<Item>
extends ReplaceIndexSequence<Item>, AppendSequence<Item> {

    /**
     * {@inheritDoc}
     * 
     * @return {@link ReplaceAppendIndexSequence} view of the specified
     *         subsequence
     */
    @Override
    public ReplaceAppendIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;
}
