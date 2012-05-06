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

import java.util.NoSuchElementException;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.replace.ReplaceIndexSequence;
import org.jlib.container.sequence.replace.ReplaceSequence;
import org.jlib.container.sequence.replace.ReplaceSequenceIteratorState;

/**
 * FIXME:
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class ReplaceState<Element>
extends AbstractSequenceIteratorState<Element>
implements ReplaceSequenceIteratorState<Element> {

    /**
     * ReplaceSequence traversed by this {@link ReplaceState}
     */
    private final ReplaceSequence<Element> replaceSequence;

    /**
     * Creates a new {@link ReplaceState} over the Elements of the specified
     * ReplaceIndexSequence.
     * 
     * @param replaceIndexSequence
     *        ReplaceIndexSequence to traverse
     */
    protected ReplaceState(final ReplaceSequence<Element> replaceSequence) {
        this(replaceIndexSequence, replaceIndexSequence.getFirstIndex());
    }

    /**
     * Creates a new {@link ReplaceState} over the Elements of the specified
     * IndexSequence starting the traversal at the specified index.
     * 
     * @param replaceIndexSequence
     *        ReplaceIndexSequence to traverse
     * 
     * @param startIndex
     *        integer specifying the start index of the traversal
     * 
     * @throws IndexOutOfBoundsException
     *         if
     *         {@code startIndex < replaceIndexSequence.getFirstIndex() || startIndex > replaceIndexSequence.getLastIndex()}
     */
    protected ReplaceState(final ReplaceIndexSequence<Element> replaceIndexSequence, final int startIndex)
    throws IndexOutOfBoundsException {
        super(replaceIndexSequence, startIndex);

        this.replaceIndexSequence = replaceIndexSequence;
        modificationReady = false;
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
