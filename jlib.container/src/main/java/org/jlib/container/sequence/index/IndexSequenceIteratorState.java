package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * State of an {@link IndexSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface IndexSequenceIteratorState<Element>
extends SequenceIteratorState<Element>, IndexSequenceIterator<Element> {

    /**
     * Returns the {@link IndexSequenceIteratorState} switched to after a call
     * to {@link #previous()}.
     * 
     * @return {@link IndexSequenceIteratorState} after {@link #previous()}
     */
    @Override
    public IndexSequenceIteratorState<Element> getPreviousState();

    /**
     * Returns the {@link IndexSequenceIteratorState} switched to after a call
     * to {@link #next()}.
     * 
     * @return {@link IndexSequenceIteratorState} after {@link #next()}
     */
    @Override
    public IndexSequenceIteratorState<Element> getNextState();

}
