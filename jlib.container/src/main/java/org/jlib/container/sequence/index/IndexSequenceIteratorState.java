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
public class IndexSequenceIteratorState<Element>
extends AbstractSequenceIteratorState<Element> {

    /** global {@link IndexSequenceIteratorGlobalState} */
    private final IndexSequenceIteratorGlobalState<Element> globalState;

    /** traversed {@link IndexSequence} */
    private final IndexSequence<Element> sequence;

    /** index of the last returned Element */
    private int lastReturnedElementIndex;

    /**
     * Creates a new {@link IndexSequenceIteratorState}.
     * 
     * @param globalState
     *        {@link IndexSequenceIteratorGlobalState} used by this
     *        {@link IndexSequenceIteratorState}
     */
    public IndexSequenceIteratorState(final IndexSequenceIteratorGlobalState<Element> globalState) {

        this.globalState = globalState;
        sequence = parentIterator.getSequence();
    }

    @Override
    public boolean hasNext() {
        return parentIterator.getNextElementIndex() <= sequence.getLastIndex();
    }

    @Override
    public Element next()
    throws NoSuchSequenceElementException {
        try {
            final int nextElementIndex = parentIterator.getNextElementIndex();
            final Element nextElement = sequence.get(nextElementIndex);

            parentIterator.setNextElementIndex(nextElementIndex + 1);

            lastReturnedElementIndex = nextElementIndex;

            return nextElement;
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(exception);
        }
    }

    @Override
    public boolean hasPrevious() {
        return parentIterator.getPreviousElementIndex() >= sequence.getFirstIndex();
    }

    @Override
    public Element previous()
    throws NoSuchSequenceElementException {
        try {
            final int previousElementIndex = parentIterator.getPreviousElementIndex();
            final Element previousElement = sequence.get(previousElementIndex);

            parentIterator.setNextElementIndex(previousElementIndex);

            lastReturnedElementIndex = previousElementIndex;

            return previousElement;
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(exception);
        }
    }

    @Override
    public SequenceIteratorState<Element> getPreviousState() {
        return parentIterator.getElementReturnedState(lastReturnedElementIndex);
    }

    @Override
    public SequenceIteratorState<Element> getNextState() {
        return parentIterator.getElementReturnedState(lastReturnedElementIndex);
    }
}
