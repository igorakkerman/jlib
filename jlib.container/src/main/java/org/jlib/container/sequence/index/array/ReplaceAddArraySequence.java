package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.sequence.AddSequence;
import org.jlib.container.sequence.Sequence;
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
public class ReplaceAddArraySequence<Item>
extends ReplaceArraySequence<Item>
implements AddSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link ReplaceAddArraySequence}
     * insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAddArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAddArraySequence<Object>>() {

            @Override
            public ReplaceAddArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAddArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAddArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of {@link ReplaceAddArraySequence}
     *         instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ? extends ReplaceAddArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAddArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAddArraySequence} with the specified first
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
    protected ReplaceAddArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void add(final Item item) {
        addAll(singleton(item));
    }

    @Override
    public void addAll(final Container<? extends Item> items) {
        final int addedItemsCount = items.getSize();

        assertCapacity(getSize() + addedItemsCount);

        int itemArrayIndex = getSize();

        for (final Item item : items)
            replaceDelegateArrayItem(itemArrayIndex ++, item);

        setLastIndex(getLastIndex() + addedItemsCount);
    }

    @Override
    public void addAll(final Collection<? extends Item> items) {
        ContainerUtility.addAll(this, items);
    }

    @Override
    @SafeVarargs
    public final void addAll(final Item... items) {
        ContainerUtility.addAll(this, items);
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser() {
        return new DefaultReplaceIndexSequenceTraverser<Item, ReplaceAddArraySequence<Item>>(this);
    }
}
