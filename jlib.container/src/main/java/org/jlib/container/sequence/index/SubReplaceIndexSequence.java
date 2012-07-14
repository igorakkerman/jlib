package org.jlib.container.sequence.index;

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;

/**
 * {@link ReplaceIndexSequence} view of the Items stored in another
 * {@link ReplaceIndexSequence} in the specified index range. The Items in this
 * {@link SubReplaceIndexSequence} will have the same index as they had in the
 * base {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link SubReplaceIndexSequence}
 * 
 * @param <BaseSequence>
 *        type of the base {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class SubReplaceIndexSequence<Item, BaseSequence extends ReplaceIndexSequence<Item>>
extends SubIndexSequence<Item, BaseSequence>
implements ReplaceIndexSequence<Item> {

    /**
     * Creates a new {@link SubReplaceIndexSequence}.
     * 
     * @param baseSequence
     *        BaseSequence of this {@link SubReplaceIndexSequence}
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
    public SubReplaceIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        super(baseSequence, firstIndex, lastIndex);
    }

    @Override
    public ReplaceIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().replace(index, newItem);
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser() {
        return new DefaultReplaceIndexSequenceTraverser<>(this);
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceTraverser<>(this, startIndex);
    }
}
