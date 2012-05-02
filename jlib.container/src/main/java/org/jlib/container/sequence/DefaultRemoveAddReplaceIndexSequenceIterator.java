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
 * {@link ReplaceIndexSequenceIterator} over a {@link AddIndexSequence}.
 *
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 *        
 * @author Igor Akkerman
 */
public class DefaultRemoveAddReplaceIndexSequenceIterator<Element>
extends DefaultIndexSequenceIterator<Element>
implements RemoveSequenceIterator<Element>, IndexSequenceIterator<Element> {

    /** RemoveIndexSequence traversed by this Iterator */
    private RemoveIndexSequence<Element> sequence;

    /** ready for modifying operation (add/remove) */
    private boolean modificationReady;

    /**
     * Creates a new {@link DefaultAddReplaceIndexSequenceIterator} over the specified
     * {@link RemoveIndexSequence}.
     *
     * @param sequence
     *        {@link RemoveIndexSequence} to traverse
     */
    protected DefaultRemoveAddReplaceIndexSequenceIterator(final RemoveIndexSequence<Element> sequence) {
        super(sequence);
        
        this.sequence = sequence;
    }

    /**
     * Creates a new DefaultRemoveAddReplaceIndexSequenceIterator for the specified
     * AddIndexSequence.
     *
     * @param sequence
     *        RemoveIndexSequence to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws IndexOutOfBoundsException
     *         if {@code startIndex < matrix.getFirstIndex() || matrix.lastIndex > startindex}
     */
    protected DefaultRemoveAddReplaceIndexSequenceIterator(final RemoveIndexSequence<Element> sequence, int startIndex)
    throws IndexOutOfBoundsException {
        super(sequence, startIndex);
        
        this.sequence = sequence;
    }

    @Override
    public void remove() {
        if (!modificationReady)
            throw new IllegalStateException();

        sequence.remove(lastRetreivedElementIndex());

        modificationReady = false;
    }

    // @see
    // org.jlib.container.sequence.DefaultReplaceIndexSequenceIterator#next()
    @Override
    public Element next() {
        // this order in case of an exception
        Element nextElement = super.next();
        modificationReady = true;
        return nextElement;
    }

    // @see
    // org.jlib.container.sequence.DefaultReplaceIndexSequenceIterator#previous()
    @Override
    public Element previous() {
        // this order in case of an exception
        Element previousElement = super.previous();
        modificationReady = true;
        return previousElement;
    }
}
