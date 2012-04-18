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
 * Skeletal implementation of an ReplaceIndexSequence.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractNonEmptyReplaceIndexSequence<Element>
extends AbstractNonEmptyIndexSequence<Element>
implements ReplaceIndexSequence<Element> {

    /**
     * Creates a new {@link AbstractNonEmptyReplaceIndexSequence} with the
     * specified minimum and maximum indices.
     * 
     * @param firstIndex
     *        integer specifying the initial minimum index of this ArraySequence
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code  lastIndex < firstIndex}
     */
    public AbstractNonEmptyReplaceIndexSequence(int firstIndex, int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator() {
        return createIterator(getFirstIndex());
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator(int startIndex) {
        return new DefaultReplaceIndexSequenceIterator<Element>(this, startIndex);
    }
}
