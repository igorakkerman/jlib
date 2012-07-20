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
    private Item[] array;

    /**
     * Creates a new {@link ArrayStorage}.
     */
    public ArrayStorage() {
        super();
    }

    @Override
    public void initialize(final int capacity, final Copy... copyDescriptors) {
        final Item[] newArray = createArray(capacity);

        for (final Copy copyDescriptor : copyDescriptors)
            copyItems(array, newArray, copyDescriptor);

        array = newArray;
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
        return array[index];
    }

    @Override
    public void replaceItem(final int index, final Item item) {
        array[index] = item;
    }

    @Override
    public void shiftItems(final Copy... copyDescriptors)
    throws IndexOutOfBoundsException {
        for (final Copy copyDescriptor : copyDescriptors) {
            copyItems(array, array, copyDescriptor);
            // @formatter:off
            Arrays.fill(array, copyDescriptor.getSourceBeginIndex(),
                        min(copyDescriptor.getSourceEndIndex(), copyDescriptor.getTargetIndex()) + 1, /* @ValidNullArgument */ null);
            // @formatter:on
        }
    }

    /**
     * Performs the specified
     * {@link org.jlib.container.sequence.index.array.storage.LinearIndexStorage.Copy}
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
     *        {@link org.jlib.container.sequence.index.array.storage.LinearIndexStorage.Copy}
     *        operation descriptor
     */
    protected void copyItems(final Item[] sourceArray, final Item[] targetArray, final Copy copyDescriptor) {
        arraycopy(sourceArray, copyDescriptor.getSourceBeginIndex(), targetArray, copyDescriptor.getTargetIndex(),
                  copyDescriptor.getSourceEndIndex() - copyDescriptor.getSourceEndIndex() + 1);
    }

    @Override
    public int getCapacity() {
        return array.length;
    }
}
