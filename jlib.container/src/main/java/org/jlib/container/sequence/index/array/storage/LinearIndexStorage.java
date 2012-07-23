package org.jlib.container.sequence.index.array.storage;

/**
 * Storage of <em>n</em> items indexed from <em>0</em> to <em>n-1</em>.
 * 
 * @param <Item>
 *        type of the Items stored in the {@link LinearIndexStorage}
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorage<Item>
extends Cloneable {

    /**
     * Initializes or re-initializes this {@link LinearIndexStorage} performing
     * the copy operations on its Items as specified by a number of
     * {@link ItemsCopy} descritors. Their source indices reference the Item
     * indices <em>before</em>, their target indices the Item indices
     * <em>after</em> the operation. The Items stored at the former indices are
     * not overwritten and can be reused in each specified {@link ItemsCopy}
     * operation.
     * 
     * @param capacity
     *        integer specifying the capacity
     * 
     * @param firstItemIndex
     *        integer specifying the index of the first Item
     * 
     * @param lastItemIndex
     *        integer specifying the index of the last Item
     * 
     * @param copyDescriptors
     *        comma separated sequence of {@link ItemsCopy} descriptors
     * 
     * @throws LinearIndexStorageException
     *         if {@code firstItemIndex < 0 ||
     *                   lastItemIndex < firstItemIndex || 
     *                   lastItemIndex > capacity - 1 ||
     *                   count(firstItemIndex, lastItemIndex) > capacity}
     */
    public void initialize(final int capacity, final int firstItemIndex, final int lastItemIndex,
                           ItemsCopy... copyDescriptors);

    /**
     * Returns the Item stored at the specified index.
     * 
     * @param index
     *        integer specifying the index of the Item
     * 
     * @return Item stored at {@code index}
     * 
     * @throws IndexOutOfBoundsException
     *         if the index is out of the valid bounds of this
     *         {@link LinearIndexStorage}
     */
    public Item getItem(int index)
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
     *         if the index is out of the valid bounds of this
     *         {@link LinearIndexStorage}
     */
    public void replaceItem(int index, Item newItem)
    throws IndexOutOfBoundsException;

    /**
     * Shifts the Items within this {@link LinearIndexStorage} as defined
     * defined by the specified {@link ItemsCopy} descriptors. Their source
     * indices reference the Item indices <em>before</em>, their target indices
     * the Item indices <em>after</em> the operation. The Items stored at the
     * former indices are overwritten by each specified {@link ItemsCopy}
     * operation. Shifted Items are overwritten by {@code null}.
     * 
     * @param copyDescriptors
     *        comma separated sequence of {@link ItemsCopy} descriptors
     * 
     * @throws IndexOutOfBoundsException
     *         if a {@link ItemsCopy} descriptor specifies a copy operation on
     *         an index outside the valid bounds
     */
    public void shiftItems(ItemsCopy... copyDescriptors)
    throws IndexOutOfBoundsException;

    /**
     * Returns the index of the first Item.
     * 
     * @return integer specifying the index of the first Item
     */
    public int getFirstItemIndex();

    /**
     * Registers the index of the first Item.
     * 
     * @param firstItemIndex
     *        integer specifying the index of the first Item
     */
    public void setFirstItemIndex(int firstItemIndex);

    /**
     * Increments the index of the first Item by the specified value.
     * 
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementFirstItemIndex(int increment);

    /**
     * Increments the index of the last Item by the specified value.
     * 
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementLastItemIndex(int increment);

    /**
     * Returns the index of the last Item.
     * 
     * @return integer specifying the index of the last Item
     */
    public int getLastItemIndex();

    /**
     * Registers the index of the last Item.
     * 
     * @param lastItemIndex
     *        integer specifying the index of the last Item
     */
    public void setLastItemIndex(int lastItemIndex);

    /**
     * Returns the number of stored Items.
     * 
     * @return integer spacifying the number of stored Items
     */
    public int getItemsCount();

    /**
     * Returns the capacity, that is, number of storable Items.
     * 
     * @return integer specifying the capacity
     */
    public int getCapacity();

    /**
     * Returns the tail capacity, that is, the number of storable Items behind
     * the last Item.
     * 
     * @return integer specifying the tail capacity
     */
    public int getTailCapacity();

    /**
     * Creates a copy of this {@link LinearIndexStorage}.
     * 
     * @return cloned {@link LinearIndexStorage}
     */
    public LinearIndexStorage<Item> clone();
}
