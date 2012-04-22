package org.jlib.container.sequence;

import java.util.List;

/**
 * {@link Sequence} delegating all calls to its methods to the equivalent
 * methods of a delegate {@link IndexSequence}. The delegate {@link Sequence}
 * may be modified at any time allowing to dynamically switch to the contents
 * and the behaviour of another {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractDelegatingIndexSequence<Element>
extends AbstractDelegatingSequence<Element>
implements IndexSequence<Element> {

    /** {@link SequenceFillState} of this {@link AbstractDelegatingIndexSequence} */
    // TODO: move sequenceFillState to AbstractAddDelegatingIndexSequence
    private final SequenceFillState<Element> sequenceFillState;

    /**
     * Creates a new {@link AbstractDelegatingIndexSequence}.
     * 
     * @param initialSequenceFillState
     *        initial {@link SequenceFillState} of this
     *        {@link AbstractDelegatingIndexSequence}
     */
    protected AbstractDelegatingIndexSequence(final SequenceFillState<Element> initialSequenceFillState) {
        super();

        sequenceFillState = initialSequenceFillState;
    }

    /**
     * Returns the {@link IndexSequence} containing the {@code Elements} of this
     * {@link AbstractDelegatingIndexSequence}.
     * 
     * @return the delegate {@link IndexSequence}
     */
    @Override
    protected IndexSequence<Element> getDelegateSequence() {
        return sequenceFillState.getDelegateSequence();
    }

    @Override
    public Element get(final int index)
    throws SequenceIndexOutOfBoundsException {
        return getDelegateSequence().get(index);
    }

    @Override
    public int getFirstIndex() {
        return getDelegateSequence().getFirstIndex();
    }

    @Override
    public int getLastIndex() {
        return getDelegateSequence().getLastIndex();
    }

    @Override
    public int getFirstIndexOf(final Element element) {
        return getDelegateSequence().getFirstIndexOf(element);
    }

    @Override
    public int getLastIndexOf(final Element element) {
        return getDelegateSequence().getLastIndexOf(element);
    }

    @Override
    public List<Element> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        return getDelegateSequence().createSubList(fromIndex, toIndex);
    }

    @Override
    public IndexSequence<Element> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        return getDelegateSequence().createSubSequence(fromIndex, toIndex);
    }

    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return getDelegateSequence().createIterator();
    }

    @Override
    public IndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return getDelegateSequence().createIterator(startIndex);
    }
}
