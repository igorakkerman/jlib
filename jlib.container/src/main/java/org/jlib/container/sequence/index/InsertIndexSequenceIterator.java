package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertSequenceIterator;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * {@link SequenceIterator} over the Elements of an {@link InsertIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertIndexSequenceIterator<Element>
extends InsertSequenceIterator<Element>, IndexSequenceIterator<Element> {

    /**
     * Returns the traversed {@link InsertIndexSequence}
     * 
     * @return traversed {@link InsertIndexSequence}
     */
    @Override
    public InsertIndexSequence<Element> getSequence();
}
