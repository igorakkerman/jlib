package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertRemoveSequence;

/**
 * {@link InsertRemoveSequence}, {@link InsertIndexSequence} and
 * {@link RemoveIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link InsertRemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertRemoveIndexSequence<Item>
extends InsertRemoveSequence<Item>, InsertIndexSequence<Item>, RemoveIndexSequence<Item> {

    @Override
    public InsertRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * @return {@link InsertRemoveIndexSequenceTraverser} over the Items of this
     *         {@link InsertRemoveIndexSequence}
     */
    @Override
    public InsertRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * @return {@link InsertRemoveIndexSequenceTraverser} over the Items of this
     *         {@link InsertRemoveIndexSequence}
     */
    @Override
    public InsertRemoveIndexSequenceTraverser<Item> createTraverser(int startIndex);
}
