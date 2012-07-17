package org.jlib.container.sequence.index.array.storage;

/**
 * Provider of capacity in a {@link LinearIndexStorage}.
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityProvider {

    /**
     * Asserts that the specified number of Items fit in the
     * {@link LinearIndexStorage}.
     * 
     * @param itemsCount
     *        integer specifying the number of Items
     */
    public void assertCapacity(int itemsCount);
}
