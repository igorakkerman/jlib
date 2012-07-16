package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.OperatorException;
import org.jlib.core.observer.ValueObserver;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.ObservedRemoveFirstSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SoleItemNotRemoveableException;
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
public class ReplaceInsertRemoveFirstLastArraySequence<Item>
extends ReplaceInsertRemoveLastArraySequence<Item>
implements ObservedRemoveFirstSequence<Item> {

    /**
     * Creates a new uninitialized
     * {@link ReplaceInsertRemoveFirstLastArraySequence} with the specified
     * first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the initial first index
     * 
     * @param lastIndex
     *        integer specifying the initial last index
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} and the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertRemoveFirstLastArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveFirstLastArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    public void removeFirstItem() {
        final int firstIndex = getFirstIndex();

        if (firstIndex == getLastIndex())
            throw new SoleItemNotRemoveableException(this);

        setFirstIndex(firstIndex + 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeFirstItem(final ValueObserver<Item>... observers) {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate()
            throws OperatorException {
                try {
                    removeFirstItem();
                }
                catch (final SoleItemNotRemoveableException exception) {
                    throw new OperatorException("removeFirstItem {0}", exception);
                }
            }
        },

        getStoredItem(getFirstIndex()), observers);
    }
}
