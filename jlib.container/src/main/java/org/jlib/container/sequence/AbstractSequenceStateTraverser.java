package org.jlib.container.sequence;


/**
 * Skeletal implementation of a {@link SequenceTraverser} using
 * {@link SequenceTraverserState} instances.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceStateTraverser<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze> {

    /**
     * Creates a new {@link AbstractSequenceStateTraverser}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    protected AbstractSequenceStateTraverser(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public final boolean hasPrevious() {
        return getCurrentState().hasPrevious();
    }

    @Override
    public final Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        final Item previousItem = getCurrentState().getPreviousItem();

        setCurrentStateToPrevious();

        return previousItem;
    }

    @Override
    public final boolean hasNextItem() {
        return getCurrentState().hasNextItem();
    }

    @Override
    public final Item getNextItem()
    throws NoNextSequenceItemException {
        final Item nextItem = getCurrentState().getNextItem();

        setCurrentStateToNext();

        return nextItem;
    }

    /**
     * Returns the current {@link SequenceTraverserState} of this
     * {@link AbstractSequenceStateTraverser}.
     * 
     * @return current {@link SequenceTraverserState}
     */
    protected abstract SequenceTraverserState<Item> getCurrentState();

    /**
     * Registers the current {@link SequenceTraverserState} of this
     * {@link AbstractSequenceStateTraverser} to the
     * {@link SequenceTraverserState} returned by
     * {@code getCurrentState().getPreviousState()}.
     */
    protected abstract void setCurrentStateToPrevious();

    /**
     * Registers the current {@link SequenceTraverserState} of this
     * {@link AbstractSequenceStateTraverser} to the
     * {@link SequenceTraverserState} returned by
     * {@code getCurrentState().getNextState()}.
     */
    protected abstract void setCurrentStateToNext();
}
