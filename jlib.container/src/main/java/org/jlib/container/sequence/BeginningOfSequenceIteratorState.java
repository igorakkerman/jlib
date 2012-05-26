package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * {@link SequenceIteratorState} when a {@link SequenceIterator} is at the
 * beginning of the non-empty {@link Sequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class BeginningOfSequenceIteratorState<Element, Sequenze extends Sequence<Element>>
extends AbstractSequenceIteratorState<Element, Sequenze> {

    /**
     * Creates a new {@link BeginningOfSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public BeginningOfSequenceIteratorState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Element previous()
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    @Override
    public SequenceIteratorState<Element> getPreviousState() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
