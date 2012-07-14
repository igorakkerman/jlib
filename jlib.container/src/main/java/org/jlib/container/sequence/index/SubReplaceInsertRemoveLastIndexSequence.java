package org.jlib.container.sequence.index;

import org.jlib.core.observer.ValueObserver;

import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.SoleItemNotRemoveableException;

/**
 * {@link SubReplaceIndexSequence} view of the Items stored in another
 * {@link ReplaceIndexSequence} in the specified index range. The Items in this
 * {@link SubReplaceInsertRemoveLastIndexSequence} will have the same index as
 * they had in the base {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the
 *        {@link SubReplaceInsertRemoveLastIndexSequence}
 * 
 * @param <BaseSequence>
 *        type of the base {@link ObservedReplaceInsertIndexSequence}
 * 
 * @author Igor Akkerman
 */

// FIXME: RemoveLast/First hat keine SubSequence, weil das keinen Sinn macht
public class SubReplaceInsertRemoveLastIndexSequence<Item, BaseSequence extends ObservedReplaceInsertRemoveLastIndexSequence<Item>>
extends SubReplaceInsertIndexSequence<Item, BaseSequence>
implements ObservedReplaceInsertRemoveLastIndexSequence<Item> {

    /**
     * Creates a new {@link SubReplaceInsertRemoveLastIndexSequence}.
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
    public SubReplaceInsertRemoveLastIndexSequence(final BaseSequence baseSequence, final int firstIndex,
                                                   final int lastIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        super(baseSequence, firstIndex, lastIndex);
    }

    @Override
    public ObservedReplaceInsertRemoveLastIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceInsertRemoveLastIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public void removeLastItem()
    throws IllegalSequenceStateException {
        getBaseSequence().removeLastItem();
    }

    @Override
    public void removeLastItem(final ValueObserver<Item>... observers)
    throws SoleItemNotRemoveableException {}
}
