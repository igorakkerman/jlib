package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverserState;

/**
 * State of an {@link IndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface IndexSequenceTraverserState<Item>
extends SequenceTraverserState<Item>, IndexSequenceTraverser<Item> {

    /**
     * Returns the {@link IndexSequenceTraverserState} switched to after a call
     * to {@link #previous()}.
     * 
     * @return {@link IndexSequenceTraverserState} after {@link #previous()}
     */
    @Override
    public IndexSequenceTraverserState<Item> getPreviousState();

    /**
     * Returns the {@link IndexSequenceTraverserState} switched to after a call
     * to {@link #next()}.
     * 
     * @return {@link IndexSequenceTraverserState} after {@link #next()}
     */
    @Override
    public IndexSequenceTraverserState<Item> getNextState();

}
