package org.jlib.container.sequence.index.array.storage;

/**
 * Storage of <em>n</em> items indexed from <em>0</em> to <em>n-1</em>.
 * 
 * @param <Item>
 *        type of the Items stored in the {@link LinearIndexStorage}
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorage<Item> {

    /**
     * Descriptor of an Item copy operation specifying a source Item index range
     * <em>from</em> which and destination Item index <em>to</em> which a
     * specified amount of {@link LinearIndexStorage} Items is copied.
     * 
     * @author Igor Akkerman
     */
    public static class Copy {

        /** begin index of the copied range */
        private final int sourceBeginIndex;

        /** end index of the copied range */
        private final int sourceEndIndex;

        /** index to which the range is copied */
        private final int targetIndex;

        /**
         * Creates a new {@link Copy}.
         * 
         * @param sourceBeginIndex
         *        integer specifying the begin index of the copied range
         * 
         * @param sourceEndIndex
         *        integer specifying the end index of the copied range
         * 
         * @param targetIndex
         *        integer specifying the index to which the range is copied
         */
        public Copy(final int sourceBeginIndex, final int sourceEndIndex, final int targetIndex) {
            super();

            this.sourceBeginIndex = sourceBeginIndex;
            this.sourceEndIndex = sourceEndIndex;
            this.targetIndex = targetIndex;
        }

        /**
         * Returns the begin index of the copied range.
         * 
         * @return integer specifying the begin index of the copied range
         */
        public int getSourceBeginIndex() {
            return sourceBeginIndex;
        }

        /**
         * Returns the end index of the copied range.
         * 
         * @return integer specifying the end index of the copied range
         */
        public int getSourceEndIndex() {
            return sourceEndIndex;
        }

        /**
         * Returns the index to which the range is copied.
         * 
         * @return integer specifying the index to which the range is copied
         */
        public int getTargetIndex() {
            return targetIndex;
        }
    }

    /**
     * Initializes or re-initializes this {@link LinearIndexStorage} performing
     * the copy operations on its Items as specified by a number of {@link Copy}
     * descritors. Their source indices reference the Item indices
     * <em>before</em>, their target indices the Item indices <em>after</em> the
     * operation. The Items stored at the former indices are not overwritten and
     * can be reused in each specified {@link Copy} operation.
     * 
     * @param capacity
     *        integer specifying the capacity
     * 
     * @param copyDescriptors
     *        comma separated sequence of {@link Copy} descriptors
     */
    public void initialize(final int capacity, Copy... copyDescriptors);

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
     * defined by the specified {@link Copy} descriptors. Their source indices
     * reference the Item indices <em>before</em>, their target indices the Item
     * indices <em>after</em> the operation. The Items stored at the former
     * indices are overwritten by each specified {@link Copy} operation. Shifted
     * Items are overwritten by {@code null}.
     * 
     * @param copyDescriptors
     *        comma separated sequence of {@link Copy} descriptors
     * 
     * @throws IndexOutOfBoundsException
     *         if a {@link Copy} descriptor specifies a copy operation on an
     *         index outside the valid bounds
     */
    public void shiftItems(Copy... copyDescriptors)
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
}
