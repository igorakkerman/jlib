package org.jlib.container.sequence;

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
