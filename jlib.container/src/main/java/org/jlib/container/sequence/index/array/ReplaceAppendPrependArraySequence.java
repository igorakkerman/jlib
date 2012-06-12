package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.PrependSequence;
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
public class ReplaceAppendPrependArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements PrependSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link ReplaceAppendPrependArraySequence}
     * insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAppendPrependArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAppendPrependArraySequence<Object>>() {

            @Override
            public ReplaceAppendPrependArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAppendPrependArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAppendPrependArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link ReplaceAppendPrependArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ReplaceAppendPrependArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAppendPrependArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAppendPrependArraySequence} with the
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
    protected ReplaceAppendPrependArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }
}
