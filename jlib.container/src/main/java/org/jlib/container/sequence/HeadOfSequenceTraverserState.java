package org.jlib.container.sequence;

/**
 * {@link SequenceTraverserState} when a {@link SequenceTraverser} is at the
 * head of the non-empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class HeadOfSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link HeadOfSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public HeadOfSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Item previous()
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public SequenceTraverserState<Item> getPreviousState() {
        return this;
    }

    @Override
    public boolean hasNextItem() {
        return true;
    }
}
