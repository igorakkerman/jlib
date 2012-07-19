package org.jlib.container.sequence.index.array.storage;

/**
 * Provider of capacity in a {@link LinearIndexStorage}.
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityStrategy {

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, leaving a hole of the specified size between the
     * existing Items. If necessary, the Items located behind the hole index are
     * moved behind the hole.
     * 
     * @param itemsCount
     *        integer specifying the number of Items
     * 
     * @param holeIndex
     *        integer specifying the hole index
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code itemsCount < 1 ||
     *                   holeIndex < linearIndexStorage.getFirstIndex() || holeIndex > linearIndexStorage.getLastIndex() || 
     *                   holeSize < 0 ||
     *                   holeSize + linearIndexStorage.getItemsCount() > itemsCount}
     */
    public void assertCapacityWithMiddleHole(final int itemsCount, final int holeIndex, final int holeSize)
    throws LinearIndexStorageException;

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, leaving a hole of the specified size in front of the
     * existing Items. The first index of the {@link LinearIndexStorage} is
     * decremented by the hole size. The indices of all existing Items are left
     * unchanged.
     * 
     * @param itemsCount
     *        integer specifying the number of Items
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code itemsCount < 1 || 
     *                   holeSize < 0 ||
     *                   holeSize + linearIndexStorage.getItemsCount() < itemsCount}
     */
    public void assertCapacityWithHeadHole(final int itemsCount, final int holeSize)
    throws LinearIndexStorageException;

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, leaving a hole of the specified size behind the existing
     * Items. The last index of the {@link LinearIndexStorage} is incremented by
     * the hole size. The indices of all existing Items are left unchanged.
     * 
     * @param itemsCount
     *        integer specifying the number of Items
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code itemsCount < 1 || 
     *                   holeSize < 0 ||
     *                   linearIndexStorage.getItemsCount() + holeSize < itemsCount}
     */
    public void assertCapacityWithTailHole(final int itemsCount, final int holeSize)
    throws LinearIndexStorageException;
}
