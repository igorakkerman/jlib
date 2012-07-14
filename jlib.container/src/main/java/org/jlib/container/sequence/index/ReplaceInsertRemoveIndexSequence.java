package org.jlib.container.sequence.index;

/**
 * {@link ReplaceInsertIndexSequence} and {@link RemoveIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceInsertRemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertRemoveIndexSequence<Item>
extends ReplaceInsertIndexSequence<Item>, RemoveIndexSequence<Item> {

    @Override
    public ReplaceInsertRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * {@inheritDoc}
     * 
     * @return {@link ReplaceInsertRemoveIndexSequenceTraverser} over the Items
     *         of this {@link ReplaceInsertRemoveIndexSequence}
     */
    @Override
    public ReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * {@inheritDoc}
     * 
     * @return {@link ReplaceInsertRemoveIndexSequenceTraverser} over the Items
     *         of this {@link ReplaceInsertRemoveIndexSequence}
     */
    @Override
    public ReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser(int startIndex);
}
