package org.jlib.container.sequence.index.array.storage;

/**
 * Strategy of capacity provision in a {@link LinearIndexStorage}.
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityStrategy {

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items at the head of the {@link LinearIndexStorage}. The
     * indices of the stored Items are incremented, if necessary.
     * 
     * @param headCapacity
     *        integer specifying the head capacity
     * 
     * @throws LinearIndexStorageException
     *         if {@code headCapacity < 0}
     */
    public void ensureHeadCapacity(final int headCapacity)
    throws LinearIndexStorageException;

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items betweeen the existing stored Items. The indices of the
     * Items stored after the specified split index are incremented.
     * 
     * @param middleCapacity
     *        integer specifying the middle capacity
     * 
     * @param splitIndex
     *        integer specifying the split index
     * 
     * @throws LinearIndexStorageException
     *         if {@code middleCapacity < 0 || 
     *                   middleIndex < linearIndexStorage.getFirstIndex() || 
     *                   middleIndex > linearIndexStorage.getLastIndex()}
     */
    public void ensureMiddleCapacity(final int middleCapacity, final int splitIndex)
    throws LinearIndexStorageException;

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items behind the existing stored Items. The indices of all
     * stored Items are left unchanged.
     * 
     * @param tailCapacity
     *        integer specifying the tail capacity
     * 
     * @throws LinearIndexStorageException
     *         if {@code tailCapacity < 0}
     */
    public void ensureTailCapacity(final int tailCapacity)
    throws LinearIndexStorageException;
}
