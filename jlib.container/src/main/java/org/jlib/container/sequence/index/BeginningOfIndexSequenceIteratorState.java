package org.jlib.container.sequence.index;

import org.jlib.container.sequence.BeginningOfSequenceIteratorState;
import org.jlib.container.sequence.NoSuchSequenceElementException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * {@link IndexSequenceIteratorState} when a {@link SequenceIterator} is at the
 * beginning of an {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class BeginningOfIndexSequenceIteratorState<Element, Sequenze extends IndexSequence<Element>>
extends BeginningOfSequenceIteratorState<Element, Sequenze>
implements IndexSequenceIteratorState<Element> {

    /**
     * Creates a new {@link BeginningOfIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public BeginningOfIndexSequenceIteratorState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public int getPreviousElementIndex()
    throws NoSuchSequenceElementException {
        throw new NoSuchSequenceElementException(getSequence());
    }

    @Override
    public int getNextElementIndex() {
        return getSequence().getFirstIndex();
    }

    @Override
    public Element next() {
        return getSequence().getFirst();
    }

    @Override
    public IndexSequenceIteratorState<Element> getPreviousState() {
        return this;
    }
}
