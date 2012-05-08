package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * Global state of a {@link IndexSequenceIterator} accessible to every
 * {@link IndexSequenceIteratorState}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class IndexSequenceIteratorGlobalState<Element> {

    /** parent {@link IndexSequence} to traverse */
    private final IndexSequence<Element> parentSequence;

    /** index of the next Item in the {@link IndexSequence} */
    private int nextElementIndex;

    /**
     * Creates a new {@link IndexSequenceIteratorGlobalState}.
     * 
     * @param sequence
     *        parent {@link IndexSequence} to traverse
     * 
     * @param startElementIndex
     *        integer specifying the index of the start Element
     */
    public IndexSequenceIteratorGlobalState(final IndexSequence<Element> sequence, final int startElementIndex) {
        this.parentSequence = sequence;
        nextElementIndex = startElementIndex;
    }

    /**
     * Returns the parentSequence of this
     * {@link IndexSequenceIteratorGlobalState}.
     * 
     * @return {@link IndexSequence} specifying the parent parentSequence
     */
    protected IndexSequence<Element> getSequence() {
        return parentSequence;
    }

    /**
     * Returns the index of the next Element of the parent
     * {@link IndexSequenceIterator} of this
     * {@link IndexSequenceIteratorGlobalState}.
     * 
     * @return integer specifying the index of the next Element
     */
    protected int getNextElementIndex() {
        return nextElementIndex;
    }

    /**
     * Registers the index of the next Element of the parent
     * {@link IndexSequenceIterator} of this
     * {@link IndexSequenceIteratorGlobalState}.
     * 
     * @param nextElementIndex
     *        integer specifying the index of the next Element
     */
    protected void setNextElementIndex(final int nextElementIndex) {
        this.nextElementIndex = nextElementIndex;
    }

}
