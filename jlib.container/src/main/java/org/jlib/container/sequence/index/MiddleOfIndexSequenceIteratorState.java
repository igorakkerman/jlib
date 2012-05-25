package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AbstractSequenceIteratorState;
import org.jlib.container.sequence.NoSuchSequenceElementException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * {@link SequenceIteratorState} of an {@link IndexSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfIndexSequenceIteratorState<Element, Sequenze extends IndexSequence<Element>>
extends AbstractSequenceIteratorState<Element, Sequenze>
implements IndexSequenceIteratorState<Element> {

    /** index of the next Element */
    private int nextElementIndex;

    /** index of recently returned Element */
    private int recentlyReturnedElementIndex;

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
            return getSequenceElement(recentlyReturnedElementIndex = nextElementIndex ++);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(getSequence(), exception);
        }
    }

    @Override
    public Element previous() {
        try {
            return getSequenceElement(recentlyReturnedElementIndex = nextElementIndex -- - 1);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceElementException(getSequence(), exception);
        }
    }

    /**
     * Returns the Element stored at the specified index in the {@link Sequence}
     * 
     * @param elementIndex
     *        integer specifying the index of the Element
     * 
     * @return Element stored at {@code elementIndex}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code elementIndex} is out of the index bounds
     */
    private Element getSequenceElement(final int elementIndex)
    throws SequenceIndexOutOfBoundsException {
        return getSequence().get(elementIndex);
    }

    @Override
    public IndexSequenceIteratorState<Element> getPreviousState() {
        return getReturnedElementState();
    }

    @Override
    public IndexSequenceIteratorState<Element> getNextState() {
        return getReturnedElementState();
    }

    /**
     * Returns the new {@link SequenceIteratorState} after returning an Element.
     * 
     * @return new {@link SequenceIteratorState}
     */
    protected abstract IndexSequenceIteratorState<Element> getReturnedElementState();

    @Override
    public int getPreviousElementIndex() {
        return nextElementIndex - 1;
    }

    @Override
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

    /**
     * Returns the index of the recently returned Element by this
     * {@link MiddleOfIndexSequenceIteratorState}.
     * 
     * @return integer specifying the recentlyReturnedElementIndex
     */
    protected int getRecentlyRetrievedElementIndex() {
        return recentlyReturnedElementIndex;
    }
}
