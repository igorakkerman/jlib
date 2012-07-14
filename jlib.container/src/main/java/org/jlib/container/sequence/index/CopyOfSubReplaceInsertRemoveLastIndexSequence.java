package org.jlib.container.sequence.index;

import org.jlib.container.Container;

/**
 * {@link SubReplaceIndexSequence} view of the Items stored in another
 * {@link ReplaceIndexSequence} in the specified index range. The Items in this
 * {@link CopyOfSubReplaceInsertRemoveLastIndexSequence} will have the same index as they had in
 * the base {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link CopyOfSubReplaceInsertRemoveLastIndexSequence}
 * 
 * @param <BaseSequence>
 *        type of the base {@link ObservedReplaceInsertIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class CopyOfSubReplaceInsertRemoveLastIndexSequence<Item, BaseSequence extends ObservedReplaceInsertIndexSequence<Item>>
extends SubReplaceIndexSequence<Item, BaseSequence>
implements ObservedReplaceInsertIndexSequence<Item> {

    /**
     * Creates a new {@link CopyOfSubReplaceInsertRemoveLastIndexSequence}.
     * 
     * @param baseSequence
     *        base {@link ReplaceInsertIndexSequence}
     * 
     * @param firstIndex
     *        integer specifying the index of the first Item
     * 
     * @param lastIndex
     *        integer specifying the index of the last Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code firstIndex < baseSequence.getFirstIndex() || lastIndex > baseSequence.getLastIndex()}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code firstIndex > lastIndex}
     */
    public CopyOfSubReplaceInsertRemoveLastIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        super(baseSequence, firstIndex, lastIndex);
    }

    @Override
    public ObservedReplaceInsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new CopyOfSubReplaceInsertRemoveLastIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser() {
        return new DefaultReplaceInsertIndexSequenceTraverser<Item, ObservedReplaceInsertIndexSequence<Item>>(this);
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    public void insert(final int index, final Item newItem) {
        getBaseSequence().insert(index, newItem);
    }

    @Override
    public void insert(final int index, final Container<? extends Item> newItems) {
        getBaseSequence().insert(index, newItems);
    }
}
