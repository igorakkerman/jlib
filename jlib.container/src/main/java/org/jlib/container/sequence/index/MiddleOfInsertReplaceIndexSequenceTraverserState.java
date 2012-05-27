package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.InsertSequenceTraverserState;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link MiddleOfIndexSequenceTraverserState} of a
 * {@link ReplaceIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfInsertReplaceIndexSequenceTraverserState<Item, Sequenze extends InsertSequence<Item> & ReplaceSequence<Item> & IndexSequence<Item>>
extends MiddleOfReplaceIndexSequenceTraverserState<Item, Sequenze>
implements InsertSequenceTraverserState<Item> {

    /**
     * Creates a new {@link MiddleOfInsertReplaceIndexSequenceTraverserState}.
     */
    public MiddleOfInsertReplaceIndexSequenceTraverserState() {
        super();
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getReplacedState() {
        return this;
    }
}
