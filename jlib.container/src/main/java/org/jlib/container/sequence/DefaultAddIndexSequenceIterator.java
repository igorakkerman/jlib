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
 * {@link AddSequenceIterator} and {@link IndexSequenceIterator} over an
 * {@link AddIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultAddIndexSequenceIterator<Element>
extends DefaultIndexSequenceIterator<Element>
implements AddIndexSequenceIterator<Element> {

    /** ReplaceIndexSequence traversed by this Iterator */
    private AddIndexSequence<Element> sequence;

    /** ready for modifying operation (add/remove) */
    // TODO: replace flag with State pattern: ModificationReady, NotModificationReady
    private boolean modificationReady;

    /**
     * Creates a new DefaultAddIndexSequenceIterator for the specified
     * AddIndexSequence.
     * 
     * @param sequence
     *        AddIndexSequence to traverse
     */
    protected DefaultAddIndexSequenceIterator(final AddIndexSequence<Element> sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    /**
     * Creates a new DefaultAddIndexSequenceIterator for the specified
     * AddIndexSequence.
     * 
     * @param sequence
     *        AddIndexSequence to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws IndexOutOfBoundsException
     *         if
     *         {@code startIndex < matrix.getFirstIndex() || matrix.lastIndex > startindex}
     */
    protected DefaultAddIndexSequenceIterator(final AddIndexSequence<Element> sequence, int startIndex)
    throws IndexOutOfBoundsException {
        super(sequence, startIndex);

        this.sequence = sequence;
    }

    @Override
    public void add(final Element element)
    throws IllegalStateException {
        if (! modificationReady)
            throw new IllegalStateException();

        sequence.add(nextElementIndex ++, element);

        modificationReady = false;
    }

    // @see org.jlib.container.sequence.DefaultReplaceIndexSequenceIterator#next()
    @Override
    public Element next() {
        // this order in case of an exception
        Element nextElement = super.next();
        modificationReady = true;
        return nextElement;
    }

    // @see org.jlib.container.sequence.DefaultReplaceIndexSequenceIterator#previous()
    @Override
    public Element previous() {
        // this order in case of an exception
        Element previousElement = super.previous();
        modificationReady = true;
        return previousElement;
    }
}
