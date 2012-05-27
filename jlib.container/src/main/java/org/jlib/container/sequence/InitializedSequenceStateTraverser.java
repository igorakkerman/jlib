package org.jlib.container.sequence;

/**
 * {@link SequenceTraverser} using {@link SequenceTraverserState} instances.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class InitializedSequenceStateTraverser<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceStateTraverser<Item, Sequenze> {

    /** current {@link SequenceTraverserState} */
    private SequenceTraverserState<Item> currentState;

    /**
     * Creates a new {@link InitializedSequenceStateTraverser} for the specified
     * initial {@link SequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     * 
     * @param initialState
     *        initial {@link SequenceTraverserState}
     */
    public InitializedSequenceStateTraverser(final Sequenze sequence, final SequenceTraverserState<Item> initialState) {
        super(sequence);

        currentState = initialState;
    }

    @Override
    protected SequenceTraverserState<Item> getCurrentState() {
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
