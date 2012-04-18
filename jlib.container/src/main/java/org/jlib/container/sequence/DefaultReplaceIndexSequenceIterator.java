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
 * Iterator over an ReplaceIndexSequence using a random access data store.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public class DefaultReplaceIndexSequenceIterator<Element>
extends DefaultIndexSequenceIterator<Element>
implements ReplaceIndexSequenceIterator<Element> {

    /**
     * ReplaceIndexSequence traversed by this
     * {@link DefaultReplaceIndexSequenceIterator}
     */
    private final ReplaceIndexSequence<Element> replaceIndexSequence;

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceIterator} over the
     * Elements of the specified ReplaceIndexSequence.
     * 
     * @param replaceIndexSequence
     *        ReplaceIndexSequence to traverse
     */
    protected DefaultReplaceIndexSequenceIterator(final ReplaceIndexSequence<Element> replaceIndexSequence) {
        this(replaceIndexSequence, replaceIndexSequence.getFirstIndex());
    }

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceIterator} over the
     * Elements of the specified IndexSequence starting the traversal at the
     * specified index.
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
    protected DefaultReplaceIndexSequenceIterator(final ReplaceIndexSequence<Element> replaceIndexSequence, int startIndex)
    throws IndexOutOfBoundsException {
        super(replaceIndexSequence, startIndex);
        
        this.replaceIndexSequence = replaceIndexSequence;
    }

    @Override
    public void replace(final Element element) {
        replaceIndexSequence.replace(lastRetreivedElementIndex(), element);
    }
}
