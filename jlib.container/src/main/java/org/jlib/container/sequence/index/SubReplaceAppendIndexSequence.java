package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.ReplaceSequenceTraverser;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link ReplaceAppendIndexSequence} view of the Items stored in another
 * {@link ReplaceAppendIndexSequence} in the specified index range. The Items in
 * this {@link SubReplaceAppendIndexSequence} will have the same index as they
 * had in the base {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link SubReplaceAppendIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class SubReplaceAppendIndexSequence<Item>
extends SubReplaceIndexSequence<Item>
implements ReplaceAppendIndexSequence<Item> {

    /** base {@link ReplaceIndexSequence} */
    private final ReplaceAppendIndexSequence<Item> baseSequence;

    /**
     * Creates a new {@link SubReplaceAppendIndexSequence}.
     * 
     * @param baseSequence
     *        base {@link ReplaceIndexSequence} and {@link AppendSequence}
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
    public SubReplaceAppendIndexSequence(final ReplaceAppendIndexSequence<Item> baseSequence, final int firstIndex,
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
    public ReplaceAppendIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceAppendIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public ReplaceTraverser<Item> createReplaceTraverser() {
        return createReplaceIndexSequenceTraverser();
    }

    @Override
    public ReplaceSequenceTraverser<Item> createReplaceSequenceTraverser() {
        return createReplaceIndexSequenceTraverser();
    }

    @Override
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException {}

    @Override
    public ReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser() {
        return new DefaultReplaceIndexSequenceTraverser<Item, SubReplaceAppendIndexSequence<Item>>(this);
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceTraverser<Item, SubReplaceAppendIndexSequence<Item>>(this, startIndex);
    }
}
