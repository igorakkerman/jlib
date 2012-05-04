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
     * Returns the previous {@link IteratorState}
     * 
     * @return previous {@link IteratorState}
     */
    public abstract SequenceIteratorState<Element> getPreviousState();

    @Override
    public abstract SequenceIteratorState<Element> getNextState();

}
