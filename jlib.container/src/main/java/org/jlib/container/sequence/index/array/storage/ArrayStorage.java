package org.jlib.container.sequence.index.array.storage;

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
implements LinearIndexStorage<Item> {

    /** array holding the Items */
    private Item[] array;

    /**
     * Creates a new {@link ArrayStorage}.
     */
    public ArrayStorage() {
        super();
    }

    @Override
    public void initialize(final int itemsCount, final Copy... copyDescriptors) {
        final Item[] newArray = createArray(itemsCount);

        copy(array, newArray, copyDescriptors);

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
    public void copy(final Copy... copyDescriptors)
    throws IndexOutOfBoundsException {
        copy(array, array, copyDescriptors);
    }

    /**
     * Performs the specified
     * {@link org.jlib.container.sequence.index.array.storage.LinearIndexStorage.Copy}
     * operations from the specified source to the speified target array of
     * Items.
     * 
     * @param sourceArray
     *        source array of Items
     * 
     * @param targetArray
     *        target array of Items
     * 
     * @param copyDescriptors
     *        comma separated sequence of
     *        {@link org.jlib.container.sequence.index.array.storage.LinearIndexStorage.Copy}
     *        operation descriptors
     * 
     */
    private void copy(final Item[] sourceArray, final Item[] targetArray, final Copy... copyDescriptors) {
        for (final Copy copy : copyDescriptors)
            System.arraycopy(sourceArray, copy.getSourceBeginIndex(), targetArray, copy.getTargetIndex(),
                             copy.getItemsCount());
    }

    @Override
    public int getItemsCount() {
        return array.length;
    }
}
