package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AbstractSequenceTraverser;
import org.jlib.container.sequence.NoNextSequenceItemException;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.reference.InitializedValueHolder;
import org.jlib.core.reference.NoValueSetException;
import org.jlib.core.reference.UninitializedValueHolder;
import org.jlib.core.reference.ValueHolder;

/**
 * Skeletal implementation of an {@link IndexSequenceTraverserState}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link IndexSequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /** {@link ValueHolder} for the index of the last accessed Item */
    private ValueHolder<Integer> lastAccessedItemIndexHolder;

    /**
     * Creates a new {@link AbstractIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public AbstractIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);

        lastAccessedItemIndexHolder = new UninitializedValueHolder<Integer>() {

            @Override
            public void set(final Integer index) {
                lastAccessedItemIndexHolder = new InitializedValueHolder<Integer>(index);
            }
        };
    }

    @Override
    public int getLastAccessedItemIndex()
    throws NoValueSetException {
        return lastAccessedItemIndexHolder.get();
    }

    /**
     * Registers the index of the last Item accessed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @param lastAccessedItemIndex
     *        integer specifying the index
     */
    protected void setLastAccessedItemIndex(final int lastAccessedItemIndex) {
        lastAccessedItemIndexHolder.set(lastAccessedItemIndex);
    }

    @Override
    public final Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        setLastAccessedItemIndex(getPreviousItemIndex());

        return doGetPreviousItem();
    }

    /**
     * Returns the previous Item in the {@link IndexSequence} traversed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @return previous Item in the {@link IndexSequence}
     * 
     * @throws NoPreviousSequenceItemException
     *         if there is no previous Item
     */
    protected abstract Item doGetPreviousItem()
    throws NoPreviousSequenceItemException;

    @Override
    public final Item getNextItem()
    throws NoNextSequenceItemException {
        setLastAccessedItemIndex(getNextItemIndex());

        return doGetNextItem();
    }

    /**
     * Returns the next Item in the {@link IndexSequence} traversed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @return next Item in the {@link IndexSequence}
     * 
     * @throws NoNextSequenceItemException
     *         if there is no next Item
     */
    protected abstract Item doGetNextItem()
    throws NoNextSequenceItemException;
}
