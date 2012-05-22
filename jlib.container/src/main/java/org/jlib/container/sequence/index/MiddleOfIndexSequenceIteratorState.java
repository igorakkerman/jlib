package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * {@link SequenceIteratorState} of an {@link IndexSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class MiddleOfIndexSequenceIteratorState<Element>
extends AbstractSequenceIteratorState<Element> {

//    /** index of the last returned Element */
//    private int lastReturnedElementIndex;

    /** traversed sequence */
    private final IndexSequence<Element> sequence;

    /** index of the next Element */
    private int nextElementIndex;

    /** beginning of {@link IndexSequence} {@link SequenceIteratorState} */
    private final SequenceIteratorState<Element> beginningOfSequenceState;

    /** end of {@link IndexSequence} {@link SequenceIteratorState} */
    private final SequenceIteratorState<Element> endOfSequenceState;

    /**
     * Creates a new {@link MiddleOfIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     * 
     * @param nextElementIndex
     *        integer specifying the index of the Element returned by
     *        {@link #next()}
     * 
     * @param beginningOfSequenceState
     *        {@link SequenceIteratorState} used at the beginning of the
     *        {@link IndexSequence}
     * 
     * @param endOfSequenceState
     *        {@link SequenceIteratorState} used at the end of the
     *        {@link IndexSequence}
     */
    public MiddleOfIndexSequenceIteratorState(final IndexSequence<Element> sequence, final int nextElementIndex,
                                              final SequenceIteratorState<Element> beginningOfSequenceState,
                                              final SequenceIteratorState<Element> endOfSequenceState) {
        this.sequence = sequence;
        this.nextElementIndex = nextElementIndex;
        this.beginningOfSequenceState = beginningOfSequenceState;
        this.endOfSequenceState = endOfSequenceState;
    }

    @Override
    public boolean hasPrevious() {
        return true;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Element next()
    throws NoSuchSequenceElementException {
        try {
            return sequence.get(nextElementIndex ++);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(exception);
        }
    }

    @Override
    public Element previous() {
        try {
            return sequence.get(nextElementIndex -- - 1);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(exception);
        }
    }

    @Override
    public SequenceIteratorState<Element> getPreviousState() {
        return getReturnedElementState();
    }

    @Override
    public SequenceIteratorState<Element> getNextState() {
        return getReturnedElementState();
    }

    /**
     * Returns the new {@link SequenceIteratorState} after returning an Element.
     * 
     * @return new {@link SequenceIteratorState}
     */
    private SequenceIteratorState<Element> getReturnedElementState() {
        if (nextElementIndex == sequence.getFirstIndex() - 1)
            return beginningOfSequenceState;

        if (nextElementIndex == sequence.getLastIndex())
            return endOfSequenceState;

        return this;
    }
}
