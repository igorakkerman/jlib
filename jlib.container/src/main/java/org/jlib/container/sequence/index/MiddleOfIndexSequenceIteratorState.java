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
public abstract class MiddleOfIndexSequenceIteratorState<Element>
extends AbstractSequenceIteratorState<Element> {

    /** index of the next Element */
    private int nextElementIndex;

    /**
     * Creates a new {@link MiddleOfIndexSequenceIteratorState}.
     */
    public MiddleOfIndexSequenceIteratorState() {
        super();
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
            return getSequenceElement(nextElementIndex ++);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(exception);
        }
    }

    @Override
    public Element previous() {
        try {
            return getSequenceElement(nextElementIndex -- - 1);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(exception);
        }
    }

    /**
     * Returns the Element stored at the specified index in the {@link Sequence}
     * 
     * @param elementIndex
     *        integer specifying the index of the Element
     * 
     * @return Element stored at {@code elementIndex}
     */
    protected abstract Element getSequenceElement(final int elementIndex);
    
    @Override
    public SequenceIteratorState<Element> getPreviousState() {
        return getReturnedElementState();
    }

    /**
     * Returns the new {@link SequenceIteratorState} after returning an Element.
     * 
     * @return new {@link SequenceIteratorState}
     */
    protected abstract SequenceIteratorState<Element> getReturnedElementState();

    @Override
    public SequenceIteratorState<Element> getNextState() {
        return getReturnedElementState();
    }

    /**
     * Returns the index of the next Element of the {@link IndexSequence}.
     * 
     * @return integer specifying the index of the next Element
     */
    public int getNextElementIndex() {
        return nextElementIndex;
    }

    /**
     * Registers the index of the next Element of the {@link IndexSequence}.
     * 
     * @param nextElementIndex
     *        integer specifying the index of the next Element
     */
    public void setNextElementIndex(final int nextElementIndex) {
        this.nextElementIndex = nextElementIndex;
    }
}
