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

package org.jlib.container.sequence.replace;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.Sequence;

/**
 * FIXME:
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class ReplaceIndexState<Element>
extends AbstractSequenceIteratorState<Element>
implements ReplaceSequenceIteratorState<Element> {

    /** parent {@link ReplaceIndexSequenceIterator} */
    private final ReplaceIndexSequenceIterator<Element> parentIterator;

    /**
     * Creates a new {@link ReplaceIndexState} for the specified
     * {@link ReplaceIndexSequenceIterator}.
     * 
     * @param parentIterator
     *        {@link ReplaceIndexSequenceIterator} using this
     *        {@link ReplaceIndexState}
     * 
     * @throws IndexOutOfBoundsException
     *         if
     *         {@code startIndex < replaceIndexSequence.getFirstIndex() || startIndex > replaceIndexSequence.getLastIndex()}
     */
    protected ReplaceIndexState(final ReplaceIndexSequenceIterator<Element> parentIterator)
    throws IndexOutOfBoundsException {
        super();

        this.parentIterator = parentIterator;
    }

    @Override
    public void replace(final Element element) {
        if (!modificationReady)
            throw new IllegalStateException();

        replaceIndexSequence.replace(getLastRetreivedElementIndex(), element);
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        final Element nextElement = super.next();

        modificationReady = true;

        return nextElement;
    }
}
