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
     * Source Item index range <em>from</em> which and destination Item index
     * <em>to</em> which a portions of {@link LinearIndexStorage} are copied.
     * 
     * @author Igor Akkerman
     */
    public static class Copy {

        /** begin index of the copied range */
        private final int sourceBeginIndex;

        /** copied number of Items */
        private final int itemsCount;

        /** index to which the range is copied */
        private final int targetIndex;

        /**
         * Creates a new {@link Copy}.
         * 
         * @param sourceBeginIndex
         *        integer specifying the begin index of the copied range
         * 
         * @param itemsCount
         *        integer specifying the copied number of Items
         * 
         * @param targetIndex
         *        integer specifying the index to which the range is copied
         */
        public Copy(final int sourceBeginIndex, final int itemsCount, final int targetIndex) {
            super();

            this.sourceBeginIndex = sourceBeginIndex;
            this.itemsCount = itemsCount;
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
         * Returns the copied number of Items.
         * 
         * @return integer specifying the copied number of Items
         */
        public int getItemsCount() {
            return itemsCount;
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
     * Initializes or re-initializes this {@link LinearIndexStorage} copying the
     * specified ranges from .
     * 
     * @param itemsCount
     *        integer specifying the number of Items to store
     * 
     * @param copies
     *        comma separated sequence of {@link Copy} instances
     */
    public void initialize(final int itemsCount, Copy... copies);

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
