package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverserState;
import org.jlib.core.reference.NoValueSetException;

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
     * to {@link #getPreviousItem()}.
     * 
     * @return {@link IndexSequenceTraverserState} after
     *         {@link #getPreviousItem()}
     */
    @Override
    public IndexSequenceTraverserState<Item> getPreviousState();

    /**
     * Returns the {@link IndexSequenceTraverserState} switched to after a call
     * to {@link #getNextItem()}.
     * 
     * @return {@link IndexSequenceTraverserState} after {@link #getNextItem()}
     */
    @Override
    public IndexSequenceTraverserState<Item> getNextState();

    /**
     * Returns the index of the last Item accessed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @return integer specifying the index of the last accessed Item
     * 
     * @throws NoValueSetException
     *         if no Item has been accessed yet
     */
    public int getLastAccessedItemIndex()
    throws NoValueSetException;
}
