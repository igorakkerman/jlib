package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceRemoveSequence;

/**
 * {@link ReplaceRemoveSequence}, {@link ReplaceIndexSequence} and
 * {@link RemoveIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceRemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceRemoveIndexSequence<Item>
extends ReplaceRemoveSequence<Item>, ReplaceIndexSequence<Item>, RemoveIndexSequence<Item> {

    @Override
    public ReplaceRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * @return {@link ReplaceRemoveIndexSequenceTraverser} over the Items of
     *         this {@link ReplaceRemoveIndexSequence}
     */
    @Override
    public ReplaceRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * @return {@link ReplaceRemoveIndexSequenceTraverser} over the Items of
     *         this {@link ReplaceRemoveIndexSequence}
     */
    @Override
    public ReplaceRemoveIndexSequenceTraverser<Item> createTraverser(int startIndex);
}
