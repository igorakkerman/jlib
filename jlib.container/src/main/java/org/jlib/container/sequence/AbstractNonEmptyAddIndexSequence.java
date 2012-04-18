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
 * Skeletal implementation of a AddIndexSequence using a random access data store.
 *
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public abstract class AbstractNonEmptyAddIndexSequence<Element>
extends AbstractNonEmptyIndexSequence<Element>
implements AddIndexSequence<Element> {

    // only constructors that make sense:
    // (final Sequence<Element> elements)
    // (final Element... elements)
    // (final Element[] elements)
    
    /**
     * Creates a new {@link AbstractNonEmptyAddIndexSequence} with the
     * specified minimum and maximum indices.
     * 
     * @param firstIndex
     *        integer specifying the initial first index
     * 
     * @param lastIndex
     *        integer specifying the initial last index
     * 
     * @throws IllegalArgumentException
     *         if {@code  lastIndex < firstIndex}
     */
    public AbstractNonEmptyAddIndexSequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public AddIndexSequenceIterator<Element> createIterator() {
        return createIterator(firstIndex);
    }

    @Override
    public AddIndexSequenceIterator<Element> createIterator(final int startIndex) {
        return new DefaultAddIndexSequenceIterator<Element>(this, startIndex);
    }
}
