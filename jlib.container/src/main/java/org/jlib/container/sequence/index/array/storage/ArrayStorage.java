package org.jlib.container.sequence.index.array.storage;

import static org.jlib.core.array.ArrayUtility.createArray;

/**
 * {@link LinearIndexStorage} using an array.
 * 
 * TODO: add more precise comment
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
    public void initialize(final int itemsCount, final Copy... copies) {
        final Item[] newArray = createArray(itemsCount);

        for (final Copy copy : copies)
            System.arraycopy(array, copy.getSourceBeginIndex(), newArray, copy.getTargetIndex(),
                             copy.getSourceEndIndex() - copy.getSourceBeginIndex() + 1);

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
    public Item getStoredItem(final int index) {
        return array[index];
    }

    @Override
    public void replaceStoredItem(final int index, final Item item) {
        array[index] = item;
    }
}
