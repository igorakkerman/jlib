package org.jlib.container.sequence.index;

import org.jlib.container.sequence.EndOfSequenceIteratorState;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * {@link IndexSequenceIteratorState} when a {@link SequenceIterator} is at the
 * beginning of an {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class EndOfIndexSequenceIteratorState<Element>
extends EndOfSequenceIteratorState<Element>
implements IndexSequenceIteratorState<Element> {

    /** traversed {@link IndexSequence} */
    private final IndexSequence<Element> sequence;

    /**
     * Creates a new {@link EndOfIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public EndOfIndexSequenceIteratorState(final IndexSequence<Element> sequence) {
        super();

        this.sequence = sequence;
    }

    @Override
    public int getPreviousElementIndex() {
        return sequence.getLastIndex();
    }

    @Override
    public int getNextElementIndex()
    throws NoSuchSequenceElementException {
        throw new NoSuchSequenceElementException();
    }

    @Override
    public Element previous()
    throws NoSuchSequenceElementException {
        return sequence.getLast();
    }

    @Override
    public IndexSequenceIteratorState<Element> getNextState() {
        return this;
    }
}
