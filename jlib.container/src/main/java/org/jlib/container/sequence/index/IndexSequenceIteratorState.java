package org.jlib.container.sequence.index;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.SequenceIteratorState;

public class IndexSsequenceIteratorState<Element>
extends AbstractSequenceIteratorState<Element> {

    private final StateIndexSequenceIterator<Element> parentIterator;

    /**
     * Creates a new {@link IndexSequenceIteratorState}.
     */
    public IndexSsequenceIteratorState(final StateIndexSequenceIterator<Element> parentIterator) {
        this.parentIterator = parentIterator;
    }

    @Override
    public SequenceIteratorState<Element> getPreviousState() {
        return null;
    }

    @Override
    public SequenceIteratorState<Element> getNextState() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Element next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Element previous()
    throws NoSuchElementException {
        return null;
    }

}
