package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequenceIteratorState;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceIteratorState} of a {@link ReplaceIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequenceIteratorState<Element>
extends IndexSequenceIteratorState<Element>, ReplaceSequenceIteratorState<Element> {

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getReplacedState();
}
