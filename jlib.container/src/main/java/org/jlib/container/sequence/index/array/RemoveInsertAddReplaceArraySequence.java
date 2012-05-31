package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultRemoveInsertAddReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.RemoveInsertAddReplaceIndexSequence;
import org.jlib.container.sequence.index.RemoveInsertReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;

/**
 * {@link AddReplaceArraySequence} into which Items can be inserted.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class RemoveInsertAddReplaceArraySequence<Item>
extends InsertEndsRemoveAddReplaceArraySequence<Item>
implements RemoveInsertAddReplaceIndexSequence<Item> {

    /**
     * Creates a new {@link RemoveInsertAddReplaceArraySequence} with the
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
    protected RemoveInsertAddReplaceArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public RemoveInsertReplaceIndexSequenceTraverser<Item> createTraverser() {
        return createTraverser(getFirstIndex());
    }

    @Override
    public RemoveInsertReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultRemoveInsertAddReplaceIndexSequenceTraverser<Item, RemoveInsertAddReplaceArraySequence<Item>>(
                                                                                                                        this,
                                                                                                                        startIndex);
    }
}
