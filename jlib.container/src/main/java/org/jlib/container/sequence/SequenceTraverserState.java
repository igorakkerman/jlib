package org.jlib.container.sequence;

import org.jlib.core.iterator.TraverserState;

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
     * {@link #previous()}.
     * 
     * @return {@link SequenceTraverserState} after {@link #previous()}
     */
    public SequenceTraverserState<Item> getPreviousState();

    /**
     * Returns the {@link SequenceTraverserState} switched to after a call to
     * {@link #next()}.
     * 
     * @return {@link SequenceTraverserState} after {@link #next()}
     */
    @Override
    public SequenceTraverserState<Item> getNextState();
}
