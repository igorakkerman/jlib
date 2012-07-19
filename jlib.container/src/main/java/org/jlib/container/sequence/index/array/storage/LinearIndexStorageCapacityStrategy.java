package org.jlib.container.sequence.index.array.storage;

/**
 * Strategy of capacity provision in a {@link LinearIndexStorage}.
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityStrategy {

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, adding the specified capacity at the head of the
     * {@link LinearIndexStorage}. The indices of all stored Items are
     * incremented, if necessary.
     * 
     * @param fullCapacity
     *        integer specifying the capacity
     * 
     * @param headCapacity
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code fullCapacity < 1 || 
     *                   headCapacity < 0 ||
     *                   headCapacity + linearIndexStorage.getItemsCount() > fullCapacity}
     */
    public void assertCapacityWithHeadHole(final int fullCapacity, final int headCapacity)
    throws LinearIndexStorageException;

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, adding the specified capacity in the middle of the
     * {@link LinearIndexStorage}. The indices of the stored Items stored after
     * the specified middle index are incremented.
     * 
     * @param fullCapacity
     *        integer specifying the capacity
     * 
     * @param middleIndex
     *        integer specifying the hole index
     * 
     * @param middleCapacity
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code fullCapacity < 1 ||
     *                   middleIndex < linearIndexStorage.getFirstIndex() || middleIndex > linearIndexStorage.getLastIndex() || 
     *                   middleCapacity < 0 ||
     *                   linearIndexStorage.getLastItemIndex() + 1 + middleCapacity > fullCapacity}
     */
    public void assertCapacityWithMiddleHole(final int fullCapacity, final int middleIndex, final int middleCapacity)
    throws LinearIndexStorageException;

    /**
     * Asserts that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items, adding the specified capacity at the tail of the
     * {@link LinearIndexStorage}. The indices of all stored Items are left
     * unchanged.
     * 
     * @param fullCapacity
     *        integer specifying the capacity
     * 
     * @param tailCapacity
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code fullCapacity < 1 || 
     *                   tailCapacity < 0 ||
     *                   linearIndexStorage.getLastItemIndex() + 1 + tailCapacity > fullCapacity}
     */
    public void assertCapacityWithTailHole(final int fullCapacity, final int tailCapacity)
    throws LinearIndexStorageException;
}
