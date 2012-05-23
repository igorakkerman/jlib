package org.jlib.container.sequence;

import org.jlib.core.iterator.IteratorState;

/**
 * State of a {@link SequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceIteratorState<Element>
extends IteratorState<Element>, SequenceIterator<Element> {

    /**
     * Returns the {@link SequenceIteratorState} switched to after
     * {@link #previous()}.
     * 
     * @return {@link SequenceIteratorState} after {@link #previous()}
     */
    public SequenceIteratorState<Element> getPreviousState();

    /**
     * Returns the {@link SequenceIteratorState} switched to after
     * {@link #next()}.
     * 
     * @return {@link SequenceIteratorState} after {@link #next()}
     */
    @Override
    public SequenceIteratorState<Element> getNextState();
}
