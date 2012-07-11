package org.jlib.container.sequence.index;

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.ReplaceSequenceTraverser;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link ReplaceAppendIndexSequence} view of the Items stored in another
 * {@link ReplaceAppendIndexSequence} in the specified index range. The Items in
 * this {@link SubReplaceInsertIndexSequence} will have the same index as they
 * had in the base {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link SubReplaceInsertIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class SubReplaceInsertIndexSequence<Item>
extends SubReplaceIndexSequence<Item>
implements ReplaceInsertIndexSequence<Item> {

    /** base {@link ReplaceInsertIndexSequence} */
    private final ReplaceInsertIndexSequence<Item> baseSequence;

    /**
     * Creates a new {@link SubReplaceInsertIndexSequence}.
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
    public SubReplaceInsertIndexSequence(final ReplaceInsertIndexSequence<Item> baseSequence, final int firstIndex,
                                         final int lastIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        super(baseSequence, firstIndex, lastIndex);

        this.baseSequence = baseSequence;
    }

    @Override
    protected Item getStoredItem(final int index) {
        return baseSequence.get(index);
    }

    @Override
    public ReplaceInsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceInsertIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public ReplaceTraverser<Item> createTraverser() {
        return createTraverser();
    }

    @Override
    public ReplaceSequenceTraverser<Item> createTraverser() {
        return createTraverser();
    }

    @Override
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException {}

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
