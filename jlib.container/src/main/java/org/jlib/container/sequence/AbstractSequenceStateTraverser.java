package org.jlib.container.sequence;

import java.util.NoSuchItemException;

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
    public final Item previous()
    throws NoSuchItemException {
        final Item previousItem = getCurrentState().previous();

        setCurrentStateToPrevious();

        return previousItem;
    }

    @Override
    public final boolean hasNext() {
        return getCurrentState().hasNext();
    }

    @Override
    public final Item next()
    throws NoSuchItemException {
        final Item nextItem = getCurrentState().next();

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
