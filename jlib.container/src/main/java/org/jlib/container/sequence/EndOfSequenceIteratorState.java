package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * {@link SequenceIteratorState} when a {@link SequenceIterator} has reached the
 * end of the non-empty {@link Sequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class EndOfSequenceIteratorState<Element, Sequenze extends Sequence<Element>>
extends AbstractSequenceIteratorState<Element, Sequenze> {

    /**
     * Creates a new {@link EndOfSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public EndOfSequenceIteratorState(final Sequenze sequence) {
        super(sequence);
    }

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
