package org.jlib.container.sequence.index.array.storage;

/**
 * Array storage using a specific strategy.
 * 
 * @param <Item>
 *        type of the Items stored in the array
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorage<Item> {

    /**
     * Returns the Item stored at the specified index.
     * 
     * @param index
     *        integer specifying the index of the Item
     * 
     * @return Item stored at {@code index}
     */
    public Item getStoredItem(int index);

    /**
     * Replaces the Item stored at the specified index by the specified Item.
     * 
     * @param index
     *        integer specifying the index of the Item
     * 
     * @param newItem
     *        new Item replacing the former
     */
    public void replaceStoredItem(int index, Item newItem);
}
