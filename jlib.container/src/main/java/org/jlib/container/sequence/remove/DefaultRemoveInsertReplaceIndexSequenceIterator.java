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

package org.jlib.container.sequence.remove;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.add.AddIndexSequence;
import org.jlib.container.sequence.index.IndexSequenceIterator;
import org.jlib.container.sequence.insert.DefaultInsertReplaceIndexSequenceIterator;
import org.jlib.container.sequence.insert.InsertIndexSequence;
import org.jlib.container.sequence.replace.ReplaceIndexSequence;
import org.jlib.container.sequence.replace.ReplaceIndexSequenceIterator;

/**
 * {@link ReplaceIndexSequenceIterator} over a {@link AddIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultRemoveInsertReplaceIndexSequenceIterator<Element>
extends DefaultInsertReplaceIndexSequenceIterator<Element>
implements RemoveSequenceIterator<Element>, IndexSequenceIterator<Element> {

    /** RemoveIndexSequence traversed by this Iterator */
    private final RemoveIndexSequence<Element> sequence;

    /**
     * Creates a new {@link DefaultInsertReplaceIndexSequenceIterator} over the
     * specified {@link RemoveIndexSequence}.
     * 
     * @param sequence
     *        {@link RemoveIndexSequence} to traverse
     */
    protected <Sequenze extends RemoveIndexSequence<Element> & InsertIndexSequence<Element> & ReplaceIndexSequence<Element>> DefaultRemoveInsertReplaceIndexSequenceIterator(final Sequenze sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    /**
     * Creates a new DefaultRemoveInsertReplaceIndexSequenceIterator for the
     * specified AddIndexSequence.
     * 
     * @param sequence
     *        RemoveIndexSequence to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws IndexOutOfBoundsException
     *         if
     *         {@code startIndex < matrix.getFirstIndex() || matrix.lastIndex > startindex}
     */
    protected <Sequenze extends RemoveIndexSequence<Element> & InsertIndexSequence<Element> & ReplaceIndexSequence<Element>> DefaultRemoveInsertReplaceIndexSequenceIterator(final Sequenze sequence,
                                                                                                                                                                             final int startIndex)
    throws IndexOutOfBoundsException {
        super(sequence, startIndex);

        this.sequence = sequence;
    }

    @Override
    public void remove() {
        if (!modificationReady)
            throw new IllegalStateException();

        sequence.remove(getLastRetreivedElementIndex());

        modificationReady = false;
    }
}
