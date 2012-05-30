package org.jlib.container.sequence.index;

import org.jlib.container.sequence.HeadOfSequenceTraverserState;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.reference.InitializedValueHolder;
import org.jlib.core.reference.NoValueSetException;
import org.jlib.core.reference.UninitializedValueHolder;
import org.jlib.core.reference.ValueHolder;

/**
 * {@link HeadOfSequenceTraverserState} for an {@link IndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class HeadOfIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends HeadOfSequenceTraverserState<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /** {@link ValueHolder} for the index of the last accessed Item */
    private ValueHolder<Integer> lastAccessedItemIndexHolder;

    /**
     * Creates a new {@link HeadOfIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public HeadOfIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);

        lastAccessedItemIndexHolder = new UninitializedValueHolder<Integer>() {

            @Override
            public void set(final Integer index) {
                lastAccessedItemIndexHolder = new InitializedValueHolder<Integer>(index);
            }
        };
    }

    @Override
    public int getPreviousItemIndex()
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public IndexSequenceTraverserState<Item> getPreviousState() {
        return this;
    }

    @Override
    public int getNextItemIndex() {
        return getSequence().getFirstIndex();
    }

    @Override
    public Item getNextItem() {
        return getSequence().getFirstItem();
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
}
