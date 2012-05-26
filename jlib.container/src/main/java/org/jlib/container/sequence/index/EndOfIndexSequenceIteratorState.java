package org.jlib.container.sequence.index;

import org.jlib.container.sequence.EndOfSequenceIteratorState;
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
public abstract class EndOfIndexSequenceIteratorState<Element, Sequenze extends IndexSequence<Element>>
extends EndOfSequenceIteratorState<Element, Sequenze>
implements IndexSequenceIteratorState<Element> {

    /**
     * Creates a new {@link EndOfIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public EndOfIndexSequenceIteratorState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public int getPreviousElementIndex() {
        return getSequence().getLastIndex();
    }

    @Override
    public int getNextElementIndex()
    throws NoSuchSequenceElementException {
        throw new NoSuchSequenceElementException(getSequence());
    }

    @Override
    public Element previous()
    throws NoSuchSequenceElementException {
        return getSequence().getLast();
    }

    @Override
    public IndexSequenceIteratorState<Element> getNextState() {
        return this;
    }
}
