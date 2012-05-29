package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequenceTraverserState;
import org.jlib.container.sequence.Sequence;

/**
 * {@link TailOfIndexSequenceTraverserState} targeting a
 * {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class TailOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends TailOfIndexSequenceTraverserState<Item, Sequenze>
implements ReplaceIndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link TailOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public TailOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public ReplaceSequenceTraverserState<Item> getReplacedState() {
        return this;
    }
}
