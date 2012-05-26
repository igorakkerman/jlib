package org.jlib.container.sequence;

/**
 * {@link SequenceIterator} using {@link SequenceIteratorState} instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class InitializedSequenceStateIterator<Element, Sequenze extends Sequence<Element>>
extends AbstractSequenceStateIterator<Element, Sequenze> {

    /** current {@link SequenceIteratorState} */
    private SequenceIteratorState<Element> currentState;

    /**
     * Creates a new {@link InitializedSequenceStateIterator} for the specified
     * initial {@link SequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     * 
     * @param initialState
     *        initial {@link SequenceIteratorState}
     */
    public InitializedSequenceStateIterator(final Sequenze sequence, final SequenceIteratorState<Element> initialState) {
        super(sequence);

        currentState = initialState;
    }

    @Override
    protected SequenceIteratorState<Element> getCurrentState() {
        return currentState;
    }

    @Override
    protected void setCurrentStateToPrevious() {
        currentState = currentState.getPreviousState();
    }

    @Override
    protected void setCurrentStateToNext() {
        currentState = currentState.getNextState();
    }
}
