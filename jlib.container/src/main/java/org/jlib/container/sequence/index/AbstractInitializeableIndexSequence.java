package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.IllegalSequenceSizeException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceUtility;
import org.jlib.core.observer.ValueObserver;

/**
 * {@link AbstractIndexSequence} that can be initialized.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractInitializeableIndexSequence<Item>
extends AbstractIndexSequence<Item> {

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence}.
     * 
     * @param firstIndex
     *        integer specifying the initial minimum index of this
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code  lastIndex < firstIndex}
     */
    protected AbstractInitializeableIndexSequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * specified Items. That is, the index of the first Item of the specified
     * sequence in this Sequence is 0. The fixed size of the
     * {@link AbstractInitializeableIndexSequence} is the size of the specified
     * sequence.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final Item... items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * specified Items having a specified first index. That is, the index of the
     * first Item of the specified sequence in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified sequence.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param items
     *        comma separated sequence of Items to store s
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final int firstIndex, final Item... items) {
        this(firstIndex, firstIndex + items.length - 1);

        final int lastIndex = getLastIndex();

        for (int index = firstIndex, arrayItemIndex = 0; index <= lastIndex; index ++, arrayItemIndex ++)
            replace(index, items[arrayItemIndex]);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with a first
     * index of {@code 0} and the specified size.
     * 
     * @param size
     *        integer specifying the size of the new
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @throws IllegalSequenceSizeException
     *         if {@code size < 1}
     */
    protected AbstractInitializeableIndexSequence(final int size)
    throws IllegalSequenceSizeException {
        this(0, SequenceUtility.getValidatedSequenceSize(size) - 1);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Container of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     */
    protected AbstractInitializeableIndexSequence(final Container<? extends Item> items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Java Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Collection of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     */

    protected AbstractInitializeableIndexSequence(final Collection<? extends Item> items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container having a specified first index. That is,
     * the index of the first Item of the specified collection in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}. The first Item of
     *        {@code collection} is stored at this index of the newly created
     *        {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        Container of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     */

    protected AbstractInitializeableIndexSequence(final int firstIndex, final Container<? extends Item> items) {
        this(firstIndex, firstIndex + items.getItemsCount() - 1);

        int index = firstIndex;

        for (final Item item : items)
            replaceStoredItem(index ++, item);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container having a specified first index. That is,
     * the index of the first Item of the specified collection in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}. The first Item of
     *        {@code collection} is stored at this index of the newly created
     *        {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        {@link Collection} containing the Items for the
     *        {@link AbstractInitializeableIndexSequence}
     */

    protected AbstractInitializeableIndexSequence(final int firstIndex, final Collection<? extends Item> items) {
        this(firstIndex, firstIndex + items.size() - 1);

        int index = firstIndex;

        for (final Item item : items)
            replaceStoredItem(index ++, item);
    }

    /**
     * <p>
     * Creates a new {@link IndexSequence} containing the specified Integer
     * Items having a specified first index. That is, the index of the first
     * Item of the specified sequence in the newly created {@link IndexSequence}
     * can be specified. The fixed size of the newly created
     * {@link IndexSequence} is the size of the specified sequence.
     * </p>
     * // easier to use (needs the static import of the factory method(s))
     * IndexSequence&lt;Integer&gt; integerSequence = createIntegerSequence(1,
     * 2, 3, 4, 5);
     * 
     * IndexSequence&lt;Integer&gt; integerSequence =
     * createIntegerSequenceFrom(1, 1, 2, 3, 4, 5); }
     * 
     * @param firstIndex
     *        integer specifying the minimum index
     * 
     * @param items
     *        comma separated sequence of {@link Integer} Items to store
     * 
     * @return new {@link IndexSequence} of {@link Integer} Items
     */
    public static AbstractInitializeableIndexSequence<Integer> createIntegerAbstractInitializeableIndexSequenceFrom(final int firstIndex,
                                                                                                                    final Integer... items) {
        return createIntegerAbstractInitializeableIndexSequenceFrom(firstIndex, items);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Integer Items
     * having a first index of {@code 0}. The fixed size of the {@link Sequence}
     * is the size of the specified sequence.
     * 
     * @param items
     *        comma separated sequence of {@link Integer} items to store
     * 
     * @return the newly created {@link Sequence}
     */
    public static AbstractInitializeableIndexSequence<Integer> createIntegerAbstractInitializeableIndexSequence(final Integer... items) {
        return createIntegerAbstractInitializeableIndexSequenceFrom(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * specified Items. That is, the index of the first Item of the specified
     * sequence in this Sequence is 0. The fixed size of the
     * {@link AbstractInitializeableIndexSequence} is the size of the specified
     * sequence.
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the insertion
     *        of Items
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final ValueObserver<Item>[] observers, final Item... items) {
        this(0, observers, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * specified Items having a specified first index. That is, the index of the
     * first Item of the specified sequence in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified sequence.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the insertion
     *        of Items
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final int firstIndex, final ValueObserver<Item>[] observers,
                                                  final Item... items) {
        this(firstIndex, firstIndex + items.length - 1);

        final int lastIndex = getLastIndex();

        for (int index = firstIndex, arrayItemIndex = 0; index <= lastIndex; index ++, arrayItemIndex ++)
            replace(index, items[arrayItemIndex], observers);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Container of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the insertion of Items
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final Container<? extends Item> items,
                                                  final ValueObserver<Item>... observers) {
        this(0, items, observers);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Java Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Collection of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the insertion of Items
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final Collection<? extends Item> items,
                                                  final ValueObserver<Item>... observers) {
        this(0, items, observers);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container having a specified first index. That is,
     * the index of the first Item of the specified collection in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}. The first Item of
     *        {@code collection} is stored at this index of the newly created
     *        {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        Container of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the insertion of Items
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final int firstIndex, final Container<? extends Item> items,
                                                  final ValueObserver<Item>... observers) {

        this(firstIndex, firstIndex + items.getItemsCount() - 1);

        int index = firstIndex;

        for (final Item item : items)
            replaceStoredItem(index ++, item, observers);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container having a specified first index. That is,
     * the index of the first Item of the specified collection in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}. The first Item of
     *        {@code collection} is stored at this index of the newly created
     *        {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        {@link Collection} containing the Items for the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the insertion of Items
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final int firstIndex, final Collection<? extends Item> items,
                                                  final ValueObserver<Item>... observers) {

        this(firstIndex, firstIndex + items.size() - 1);

        int index = firstIndex;

        for (final Item item : items)
            replaceStoredItem(index ++, item, observers);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItem
     *        Item to store
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    protected void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, newItem);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItem
     *        Item to store
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    @SuppressWarnings("unchecked")
    protected void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, newItem, observers);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * expecting the index to be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @param newItem
     *        Item to store
     */
    protected abstract void replaceStoredItem(final int index, final Item newItem);

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * expecting the index to be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @param newItem
     *        Item to store
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} in {@code observers} throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    protected abstract void replaceStoredItem(final int index, final Item newItem, ValueObserver<Item>... observers)
    throws RuntimeException;
}
