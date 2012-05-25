package org.jlib.container.sequence.index;

import org.jlib.container.sequence.RemoveSequence;
import org.jlib.container.sequence.RemoveSequenceIterator;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceIterator} traversing a {@link RemoveSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveIndexSequenceIterator<Element>
extends RemoveSequenceIterator<Element>, IndexSequenceIterator<Element> {

    /**
     * Returns the traversed {@link RemoveIndexSequence}
     * 
     * @return traversed {@link RemoveIndexSequence}
     */
    @Override
    public RemoveIndexSequence<Element> getSequence();
}
