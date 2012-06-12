package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.sequence.InsertSequenceTraverser;
import org.jlib.container.sequence.RemoveSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultReplaceInsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.InsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.RemoveIndexSequenceTraverser;
import org.jlib.container.sequence.index.ReplaceInsertIndexSequence;
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
public class ReplaceAppendRemoveTailInsertArraySequence<Item>
extends ReplaceAppendRemoveHeadTailArraySequence<Item>
implements ReplaceInsertIndexSequence<Item> {

    /**
     * Creates a new {@link ReplaceAppendRemoveTailInsertArraySequence} with the
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
    protected ReplaceAppendRemoveTailInsertArraySequence(final int firstIndex, final int lastIndex) {
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
    public ReplaceInsertIndexSequenceTraverser<Item> createReplaceInsertIndexSequenceTraverser() {
        return createReplaceInsertIndexSequenceTraverser(getFirstIndex());
    }

    @Override
    public ReplaceInsertIndexSequenceTraverser<Item> createReplaceInsertIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    public InsertIndexSequenceTraverser<Item> createInsertIndexSequenceTraverser()
    throws SequenceIndexOutOfBoundsException {
        return createReplaceInsertIndexSequenceTraverser();
    }

    @Override
    public InsertIndexSequenceTraverser<Item> createInsertIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return createReplaceInsertIndexSequenceTraverser();
    }

    @Override
    public InsertSequenceTraverser<Item> createInsertSequenceTraverser() {
        return createReplaceInsertIndexSequenceTraverser();
    }

    @Override
    public void remove(final int index) {}

    @Override
    public RemoveIndexSequenceTraverser<Item> createRemoveIndexSequenceTraverser() {
        return createReplaceInsertIndexSequenceTraverser();
    }

    @Override
    public RemoveIndexSequenceTraverser<Item> createRemoveIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return null;
    }

    @Override
    public RemoveSequenceTraverser<Item> createRemoveTraverser() {
        return null;
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void removeAll()
    throws IllegalContainerStateException {}

    @Override
    public void remove(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void remove(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void remove(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    @Override
    public void retain(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}
}
