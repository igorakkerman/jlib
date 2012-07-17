package org.jlib.container.sequence.index.array.storage;

/**
 * Indexed storage.
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
     * 
     * @throws IndexOutOfBoundsException
     *         if the index is out of the valid range of this
     *         {@link LinearIndexStorage}
     */
    public Item getStoredItem(int index)
    throws IndexOutOfBoundsException;

    /**
     * Replaces the Item stored at the specified index by the specified Item.
     * 
     * @param index
     *        integer specifying the index of the Item
     * 
     * @param newItem
     *        new Item replacing the former
     * 
     * @throws IndexOutOfBoundsException
     *         if the index is out of the valid range of this
     *         {@link LinearIndexStorage}
     */
    public void replaceStoredItem(int index, Item newItem)
    throws IndexOutOfBoundsException;
}
