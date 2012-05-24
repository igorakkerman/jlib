package org.jlib.container.sequence.index;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.SequenceIteratorState;

/**
 * TODO:
 * 
 * @author Igor Akkerman
 */
public class NoElementIndexSequenceIteratorState<Element>
extends AbstractIndexSequenceIteratorState<Element> {

    private final StateIndexSequenceIterator<Element> parentIterator;

    private int nextElementIndex;

    /**
     * Creates a new {@link NoElementIndexSequenceIteratorState}.
     */
    public NoElementIndexSequenceIteratorState() {}

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
