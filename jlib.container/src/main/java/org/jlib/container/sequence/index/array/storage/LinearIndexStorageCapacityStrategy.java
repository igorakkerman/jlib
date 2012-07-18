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
     * Asserts that the {@link LinearIndexStorage} fits the specified number of
     * Items.
     * 
     * @param itemsCount
     *        integer specifying the number of Items
     * 
     * @param holeIndex
     *        integer specifying the insert index
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws InvalidLinearIndexStorageCapacityException
     *         if
     *         {@code expectedCapacity < 1 || holeIndex + holeSize > expectedCapacity}
     */
    public void assertCapacityWithHole(final int itemsCount, final int holeIndex, final int holeSize)
    throws InvalidLinearIndexStorageCapacityException;
}
