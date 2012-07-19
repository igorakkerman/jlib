package org.jlib.container.sequence.index.array.storage;

/**
 * Provider of capacity in a {@link LinearIndexStorage}.
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityStrategy {

    /**
     * Asserts that the {@link LinearIndexStorage} fits the specified number of
     * Items.
     * 
     * @param itemsCount
     *        integer specifying the number of Items
     */
    public void assertCapacity(int itemsCount);

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, leaving a hole of the specified size between the Items.
     * If necessary, the Items located behind the hole index are moved behind
     * the hole.
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
     *                   holeIndex + holeSize > itemsCount}
     */
    public void assertCapacityWithMiddleHole(final int itemsCount, final int holeIndex, final int holeSize)
    throws LinearIndexStorageException;

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, leaving a hole of the specified size between the Items.
     * If necessary, the Items located behind the hole index are moved behind
     * the hole.
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
     *                   holeIndex + holeSize > itemsCount}
     */
    public void assertCapacityWithHeadHole(final int itemsCount, final int holeSize)
    throws LinearIndexStorageException;
}
