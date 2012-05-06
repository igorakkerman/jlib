package org.jlib.container.sequence.index;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.SequenceIteratorState;

public class IndexSequenceIteratorState<Element>
extends AbstractSequenceIteratorState<Element> {

    private final StateIndexSequenceIterator<Element> parentIterator;

    private final IndexSequence<Element> sequence;

    private int lastReturnedElementIndex;

    /**
     * Creates a new {@link IndexSequenceIteratorState}.
     */
    public IndexSequenceIteratorState(final StateIndexSequenceIterator<Element> parentIterator) {
        this.parentIterator = parentIterator;

        sequence = parentIterator.getSequence();
    }

    @Override
    public boolean hasNext() {
        return parentIterator.getNextElementIndex() <= sequence.getLastIndex();
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        final int nextElementIndex = parentIterator.getNextElementIndex();
        final Element nextElement = sequence.get(nextElementIndex);

        parentIterator.setNextElementIndex(nextElementIndex + 1);

        lastReturnedElementIndex = nextElementIndex;

        return nextElement;
    }

    @Override
    public boolean hasPrevious() {
        return getPreviousElementIndex() >= sequence.getFirstIndex();
    }

    @Override
    public Element previous()
    throws NoSuchElementException {
        if (!hasPrevious())
            throw new NoSuchElementException();

        lastRetrievedElementIndex = -- nextElementIndex;

        return sequence.get(nextElementIndex);
    }

    @Override
    public SequenceIteratorState<Element> getPreviousState() {
        return null;
    }

    @Override
    public SequenceIteratorState<Element> getNextState() {
        return parentIterator.getElementReturnedState(lastReturnedElementIndex);
    }
}
