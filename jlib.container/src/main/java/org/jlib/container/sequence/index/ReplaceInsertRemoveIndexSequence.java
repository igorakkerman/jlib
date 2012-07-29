package org.jlib.container.sequence.index;

/**
 * {@link ReplaceInsertIndexSequence}, {@link InsertRemoveIndexSequence}, and
 * {@link ReplaceRemoveIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceInsertRemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertRemoveIndexSequence<Item>
extends ReplaceInsertIndexSequence<Item>, InsertRemoveIndexSequence<Item>, ReplaceRemoveIndexSequence<Item> {

    @Override
    public ReplaceInsertRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * @return {@link ReplaceInsertRemoveIndexSequenceTraverser} over the Items
     *         of this {@link ReplaceInsertRemoveIndexSequence}
     */
    @Override
    public ReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * @return {@link ReplaceInsertRemoveIndexSequenceTraverser} over the Items
     *         of this {@link ReplaceInsertRemoveIndexSequence}
     */
    @Override
    public ReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser(int startIndex);
}
