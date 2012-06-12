package org.jlib.container.sequence.index.array;

import org.jlib.container.Container;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultReplaceInsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.ReplaceInsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;

import static org.jlib.container.sequence.SequenceUtility.singleton;

/**
 * {@link ReplaceAppendArraySequence} into which Items can be inserted.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendInsertPrependRemoveArraySequence<Item>
extends ReplaceAppendPrependInsertArraySequence<Item>
implements InsertAppendReplaceIndexSequence<Item> {

    /**
     * Creates a new {@link ReplaceAppendInsertPrependRemoveArraySequence} with the
     * specified first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @throws IllegalArgumentException
     *         if {@code lastIndex > firstIndex}
     */
    protected ReplaceAppendInsertPrependRemoveArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void insert(final int index, final Item newItem) {
        insert(index, singleton(newItem));
    }

    @Override
    public void insert(final int index, final Container<? extends Item> newItems) {
        final int insertedItemsCount = newItems.getItemsCount();

        final int newSize = getItemsCount() + insertedItemsCount;
        final int delegateArrayInsertIndex = getDelegateArrayIndex(index);

        assertCapacityWithHole(newSize, delegateArrayInsertIndex, insertedItemsCount);

        int delegateArrayIndex = delegateArrayInsertIndex;
        for (final Item item : newItems)
            replaceDelegateArrayItem(delegateArrayIndex ++, item);

        setLastIndex(getLastIndex() + insertedItemsCount);
    }

    @Override
    public ReplaceInsertIndexSequenceTraverser<Item> createReplaceRemoveTraverser() {
        return createTraverser(getFirstIndex());
    }

    @Override
    public ReplaceInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this, startIndex);
    }
}
