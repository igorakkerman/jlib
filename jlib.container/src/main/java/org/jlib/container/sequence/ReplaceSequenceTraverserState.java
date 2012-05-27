package org.jlib.container.sequence;

/**
 * State of a {@link ReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceSequenceTraverserState<Item>
extends SequenceTraverserState<Item>, ReplaceSequenceTraverser<Item> {

    /**
     * Returns the {@link SequenceTraverserState} switched to after a call to
     * {@link #replace(Object)}.
     * 
     * @return {@link ReplaceSequenceTraverserState} after a call to
     *         {@link #replace(Object)}
     */
    public ReplaceSequenceTraverserState<Item> getReplacedState();
}
