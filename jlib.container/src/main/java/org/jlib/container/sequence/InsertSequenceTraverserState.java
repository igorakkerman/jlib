package org.jlib.container.sequence;


/**
 * State of an {@link InsertSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertSequenceTraverserState<Item>
extends SequenceTraverserState<Item>, InsertSequenceTraverser<Item> {

    /**
     * Returns the {@link SequenceTraverserState} switched to after
     * {@link #insert(Object)}.
     * 
     * @return {@link InsertSequenceTraverserState} after {@link #insert(Object)}
     */
    public InsertSequenceTraverserState<Item> getInsertState();
}
