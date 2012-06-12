package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.RemoveHeadSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SoleItemNotRemoveableException;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;

/**
 * {@link ReplaceAppendArraySequence} from which Items can be removed at its
 * ends, that is, its head and tail.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendRemoveHeadTailArraySequence<Item>
extends ReplaceAppendRemoveTailArraySequence<Item>
implements RemoveHeadSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of
     * {@link ReplaceAppendRemoveHeadTailArraySequence} insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAppendRemoveHeadTailArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAppendRemoveHeadTailArraySequence<Object>>() {

            @Override
            public ReplaceAppendRemoveHeadTailArraySequence<Object> createSequence(final int firstIndex,
                                                                                   final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAppendRemoveHeadTailArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAppendRemoveHeadTailArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link ReplaceAppendRemoveHeadTailArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ReplaceAppendRemoveHeadTailArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAppendRemoveHeadTailArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAppendRemoveHeadTailArraySequence} with the
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
    protected ReplaceAppendRemoveHeadTailArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void removeFirstItem() {
        final int firstIndex = getFirstIndex();

        if (firstIndex == getLastIndex())
            throw new SoleItemNotRemoveableException(this);

        setFirstIndex(firstIndex + 1);
    }
}
