package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceUtility;
import org.jlib.container.sequence.index.DefaultReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.ReplaceIndexSequenceTraverser;

import static org.jlib.container.sequence.SequenceUtility.singleton;

/**
 * {@link ReplaceArraySequence} to which Items can be added.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendArraySequence<Item>
extends ReplaceArraySequence<Item>
implements AppendSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link ReplaceAppendArraySequence}
     * insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAppendArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAppendArraySequence<Object>>() {

            @Override
            public ReplaceAppendArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAppendArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAppendArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link ReplaceAppendArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ? extends ReplaceAppendArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAppendArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAppendArraySequence} with the specified first
     * and last indices.
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
    protected ReplaceAppendArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void append(final Item item) {
        append(singleton(item));
    }

    @Override
    public void append(final Container<? extends Item> items) {
        final int addedItemsCount = items.getSize();

        assertCapacity(getSize() + addedItemsCount);

        int itemArrayIndex = getSize();

        for (final Item item : items)
            replaceDelegateArrayItem(itemArrayIndex ++, item);

        setLastIndex(getLastIndex() + addedItemsCount);
    }

    @Override
    public void append(final Collection<? extends Item> items) {
        SequenceUtility.append(this, items);
    }

    @Override
    @SafeVarargs
    public final void append(final Item... items) {
        SequenceUtility.append(this, items);
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser() {
        return new DefaultReplaceIndexSequenceTraverser<Item, ReplaceAppendArraySequence<Item>>(this);
    }
}
