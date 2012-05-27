package org.jlib.container.sequence;


/**
 * State of a {@link RemoveSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveSequenceTraverserState<Item>
extends SequenceTraverserState<Item>, RemoveSequenceTraverser<Item> {

    /**
     * Returns the {@link SequenceTraverserState} switched to after
     * {@link #remove()}.
     * 
     * @return {@link RemoveSequenceTraverserState} after {@link #remove()}
     */
    public RemoveSequenceTraverserState<Item> getRemoveState();
}
