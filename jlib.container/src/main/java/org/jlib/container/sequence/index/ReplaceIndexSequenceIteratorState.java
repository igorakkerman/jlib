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
// @formatter:off
public interface ReplaceIndexSequenceIteratorState<Element>
extends IndexSequenceIteratorState<Element>, ReplaceSequenceIteratorState<Element>,
        ReplaceIndexSequenceIterator<Element> {
// @formatter:on

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getNextState();

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getPreviousState();

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getReplacedState();
}
