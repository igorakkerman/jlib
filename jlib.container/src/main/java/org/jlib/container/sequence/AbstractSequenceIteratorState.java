package org.jlib.container.sequence;

/**
 * Skeletal implementation of a {@link SequenceTraverserState}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze>
implements SequenceTraverserState<Item> {

    // unifying class

    /**
     * Creates a new {@link AbstractSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public AbstractSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }
}
