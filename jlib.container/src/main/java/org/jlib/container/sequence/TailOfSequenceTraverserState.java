package org.jlib.container.sequence;

/**
 * {@link SequenceTraverserState} when a {@link SequenceTraverser} has reached
 * the tail of the non-empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class TailOfSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link TailOfSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public TailOfSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean hasNextItem() {
        return false;
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        throw new NoNextSequenceItemException(getSequence());
    }

    @Override
    public SequenceTraverserState<Item> getNextState() {
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return true;
    }
}
