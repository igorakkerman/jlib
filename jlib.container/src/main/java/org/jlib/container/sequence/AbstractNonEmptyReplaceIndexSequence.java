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
     * @param minimumIndex
     *        integer specifying the initial minimum index of this ArraySequence
     * 
     * @param maximumIndex
     *        integer specifying the maximum index of this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code  maximumIndex < firstIndex}
     */
    public AbstractNonEmptyReplaceIndexSequence(int minimumIndex, int maximumIndex) {
        super(minimumIndex, maximumIndex);
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator() {
        return createIterator(getMinimumIndex());
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator(int startIndex) {
        return new DefaultReplaceIndexSequenceIterator<Element>(this, startIndex);
    }
}
