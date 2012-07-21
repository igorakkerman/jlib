package org.jlib.container.sequence.index.array.storage;

import java.util.Arrays;

import static java.lang.Math.min;
import static java.lang.System.arraycopy;

import static org.jlib.core.array.ArrayUtility.createArray;

/**
 * {@link LinearIndexStorage} based on an array.
 * 
 * @param <Item>
 *        type of the Items stored in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayStorage<Item>
extends AbstractLinearIndexStorage<Item> {

    /** array holding the Items */
    private Item[] delegateArray;

    /**
     * Creates a new {@link ArrayStorage} with the specified capacity.
     * 
     * @param capacity
     *        integer specifying the capacity
     * 
     * @param firstItemIndex
     *        integer specifying the index of the first Item
     * 
     * @param lastItemIndex
     *        integer specifying the index of the last Item
     */
    public ArrayStorage(final int capacity, final int firstItemIndex, final int lastItemIndex) {
        super(capacity, firstItemIndex, lastItemIndex);
    }

    @Override
    protected void initializeDelegate(final int capacity, final int firstItemIndex, final int lastItemIndex,
                                      final ItemsCopy... copyDescriptors) {

        final Item[] newDelegateArray = createArray(capacity);

        for (final ItemsCopy copyDescriptor : copyDescriptors)
            copyItems(delegateArray, newDelegateArray, copyDescriptor);

        delegateArray = newDelegateArray;
    }

    /**
     * Returns the array Item stored at the specified array index.
     * 
     * @param index
     *        integer specifying the array index
     * 
     * @return Item stored at {@code index}
     */
    @Override
    public Item getItem(final int index) {
        return delegateArray[index];
    }

    @Override
    public void replaceItem(final int index, final Item item) {
        delegateArray[index] = item;
    }

    @Override
    public void shiftItems(final ItemsCopy... copyDescriptors)
    throws IndexOutOfBoundsException {
        for (final ItemsCopy copyDescriptor : copyDescriptors) {
            copyItems(delegateArray, delegateArray, copyDescriptor);

            // replace the shifted Items with null
            // @formatter:off
            Arrays.fill(delegateArray, copyDescriptor.getSourceBeginIndex(),
                        min(copyDescriptor.getSourceEndIndex(), copyDescriptor.getTargetIndex()) + 1, /* @ValidNullArgument */ null);
            // @formatter:on
        }
    }

    /**
     * Performs the specified
     * {@link org.jlib.container.sequence.index.array.storage.ItemsCopy}
     * operation from the specified source to the speified target array of
     * Items.
     * 
     * @param sourceArray
     *        source array of Items
     * 
     * @param targetArray
     *        target array of Items
     * 
     * @param copyDescriptor
     *        {@link org.jlib.container.sequence.index.array.storage.ItemsCopy}
     *        operation descriptor
     */
    protected void copyItems(final Item[] sourceArray, final Item[] targetArray, final ItemsCopy copyDescriptor) {
        arraycopy(sourceArray, copyDescriptor.getSourceBeginIndex(), targetArray, copyDescriptor.getTargetIndex(),
                  copyDescriptor.getSourceEndIndex() - copyDescriptor.getSourceEndIndex() + 1);
    }

    @Override
    public int getCapacity() {
        return delegateArray.length;
    }

    @Override
    public ArrayStorage<Item> clone() {
        final ArrayStorage<Item> clonedArrayStorage = (ArrayStorage<Item>) super.clone();

        clonedArrayStorage.delegateArray = delegateArray.clone();

        return clonedArrayStorage;
    }
}
