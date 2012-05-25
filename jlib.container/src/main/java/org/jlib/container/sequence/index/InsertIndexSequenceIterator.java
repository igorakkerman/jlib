package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertSequenceIterator;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * {@link SequenceIterator} over the elements of an {@link InsertIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertIndexSequenceIterator<Element>
extends InsertSequenceIterator<Element>, IndexSequenceIterator<Element> {
    // unifying interface to satisfy the Eclipse compiler
}
