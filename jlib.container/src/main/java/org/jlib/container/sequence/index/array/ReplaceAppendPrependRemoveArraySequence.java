package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.RemoveIndexSequence;

/**
 * {@link ReplaceAppendArraySequence} from which Items can be removed at its
 * ends, that is, its head and tail.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendPrependRemoveArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements RemoveIndexSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of
     * {@link ReplaceAppendPrependRemoveArraySequence} insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAppendPrependRemoveArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAppendPrependRemoveArraySequence<Object>>() {

            @Override
            public ReplaceAppendPrependRemoveArraySequence<Object> createSequence(final int firstIndex,
                                                                                  final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAppendPrependRemoveArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAppendPrependRemoveArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link ReplaceAppendPrependRemoveArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ReplaceAppendPrependRemoveArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAppendPrependRemoveArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAppendPrependRemoveArraySequence} with the
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
    protected ReplaceAppendPrependRemoveArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void removeFirstItem() {
        setFirstIndex(getFirstIndex() + 1);
    }

    @Override
    public void removeLastItem() {
        setLastIndex(getLastIndex() - 1);
    }
}
