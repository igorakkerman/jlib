package org.jlib.container.sequence;

import org.jlib.core.traverser.TraverserState;

/**
 * State of a {@link SequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceTraverserState<Item>
extends TraverserState<Item>, SequenceTraverser<Item> {

    /**
     * Returns the {@link SequenceTraverserState} switched to after a call to
     * {@link #getPreviousItem()}.
     * 
     * @return {@link SequenceTraverserState} after {@link #getPreviousItem()}
     */
    public SequenceTraverserState<Item> getPreviousState();

    /**
     * Returns the {@link SequenceTraverserState} switched to after a call to
     * {@link #getNextItem()}.
     * 
     * @return {@link SequenceTraverserState} after {@link #getNextItem()}
     */
    @Override
    public SequenceTraverserState<Item> getNextState();
}
