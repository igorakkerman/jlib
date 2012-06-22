package org.jlib.container.sequence;

/**
 * Skeletal implementation of a {@link SequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceTraverser<Item, Sequenze extends Sequence<Item>>
implements SequenceTraverser<Item> {

    /** traversed {@link Sequence} */
    private final Sequenze sequence;

    /**
     * Creates a new {@link AbstractSequenceTraverser}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public AbstractSequenceTraverser(final Sequenze sequence) {
        super();

        this.sequence = sequence;
    }

    /**
     * Returns the traversed {@link Sequence}.
     * 
     * @return traversed {@link Sequence}
     */
    protected Sequenze getSequence() {
        return sequence;
    }
}
