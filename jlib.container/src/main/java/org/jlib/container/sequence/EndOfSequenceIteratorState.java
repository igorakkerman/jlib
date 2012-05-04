package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * {@link SequenceIteratorState} when a {@link SequenceIterator} has reached the
 * end of the non-empty {@link Sequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class EndOfSequenceIteratorState<Element>
extends SequenceIteratorState<Element> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    @Override
    public SequenceIteratorState<Element> getNextState() {
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return true;
    }
}
