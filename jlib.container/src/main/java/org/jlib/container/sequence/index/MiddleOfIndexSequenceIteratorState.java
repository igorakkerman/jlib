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

//    /** index of the last returned Element */
//    private int lastReturnedElementIndex;

    /** traversed sequence */
    private final IndexSequence<Element> sequence;

    /** index of the next Element */
    private int nextElementIndex;

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
     */
    public MiddleOfIndexSequenceIteratorState(final IndexSequence<Element> sequence, final int nextElementIndex) {
        this.sequence = sequence;
        this.nextElementIndex = nextElementIndex;
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
