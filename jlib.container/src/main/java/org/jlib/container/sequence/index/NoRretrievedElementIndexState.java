package org.jlib.container.sequence.index;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * TODO:
 * 
 * @author Igor Akkerman
 */
public class NoRretrievedElementIndexState<Element>
extends AbstractSequenceIteratorState<Element> {

    private final StateIndexSequenceIterator<Element> parentIterator;

    private int nextElementIndex;

    /**
     * Creates a new {@link NoRretrievedElementIndexState}.
     */
    public NoRretrievedElementIndexState(final StateIndexSequenceIterator<Element> parentIterator) {
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
        nextElementIndex = parentIterator.getNextElementIndex();

        return nextElementIndex <= parentIterator.getSequence().getLastIndex();
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        final Element element = parentIterator.getSequence().get(parentIterator.getNextElementIndex());

        parentIterator.setNextElementIndex(nextElementIndex + 1);

        return element;
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
