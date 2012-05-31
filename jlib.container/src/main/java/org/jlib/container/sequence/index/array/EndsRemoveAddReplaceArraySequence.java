package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.EndsRemoveAddReplaceIndexSequence;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;

/**
 * {@link AddReplaceArraySequence} from which Items can be removed at its ends,
 * that is, its head and tail.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EndsRemoveAddReplaceArraySequence<Item>
extends AddReplaceArraySequence<Item>
implements EndsRemoveAddReplaceIndexSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link EndsRemoveAddReplaceArraySequence}
     * insstances
     */
    private static final IndexSequenceCreator<?, ? extends EndsRemoveAddReplaceArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, EndsRemoveAddReplaceArraySequence<Object>>() {

            @Override
            public EndsRemoveAddReplaceArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new EndsRemoveAddReplaceArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link EndsRemoveAddReplaceArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link EndsRemoveAddReplaceArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ? extends EndsRemoveAddReplaceArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, EndsRemoveAddReplaceArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link EndsRemoveAddReplaceArraySequence} with the
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
    protected EndsRemoveAddReplaceArraySequence(final int firstIndex, final int lastIndex) {
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
