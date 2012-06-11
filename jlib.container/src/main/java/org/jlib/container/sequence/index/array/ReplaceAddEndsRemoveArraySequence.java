package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.Sequence;
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
public class ReplaceAddEndsRemoveArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements ReplaceAddEndsRemoveIndexSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link ReplaceAddEndsRemoveArraySequence}
     * insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAddEndsRemoveArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAddEndsRemoveArraySequence<Object>>() {

            @Override
            public ReplaceAddEndsRemoveArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAddEndsRemoveArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAddEndsRemoveArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link ReplaceAddEndsRemoveArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ReplaceAddEndsRemoveArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAddEndsRemoveArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAddEndsRemoveArraySequence} with the
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
    protected ReplaceAddEndsRemoveArraySequence(final int firstIndex, final int lastIndex) {
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
