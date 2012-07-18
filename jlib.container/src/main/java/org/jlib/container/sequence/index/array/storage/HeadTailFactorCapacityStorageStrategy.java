package org.jlib.container.sequence.index.array.storage;

/**
 * {@link LinearIndexStorage} parametrized with capacity factors for head and
 * tail buffers.
 * 
 * TODO: add more precise comment
 * 
 * @param <Item>
 *        type of the Items stored in the {@link LinearIndexStorage}
 * 
 * @deprecated assertCapacity needs to be implemented first
 * 
 * @author Igor Akkerman
 */
@Deprecated
public class HeadTailFactorCapacityStorageStrategy<Item>
implements LinearIndexStorageCapacityStrategy {

    /** factor for the head capacity */
    private final int headCapacityFactor;

    /** factor for the tail capacity */
    private final int tailCapacityFactor;

    /** array index of the first Item */
    private int firstItemArrayIndex;

    /** array index of the last Item */
    private int lastItemArrayIndex;

    /** effective index of the first Item */
    private int firstItemEffectiveIndex;

    /** effective index of the last Item */
    private int lastItemEffectiveIndex;

    /**
     * Creates a new {@link HeadTailFactorCapacityStorageStrategy}.
     * 
     * @param headCapacityFactor
     *        integer specifying the factor for the head capacity
     * 
     * @param tailCapacityFactor
     *        integer specifying the factor for the tail capacity
     * 
     */
    public HeadTailFactorCapacityStorageStrategy(final int headCapacityFactor, final int tailCapacityFactor) {
        super();

        if (headCapacityFactor < 0)
            throw new InvalidCapacityFactorException("headCapacityFactor", headCapacityFactor);

        if (tailCapacityFactor < 0)
            throw new InvalidCapacityFactorException("tailCapacityFactor", tailCapacityFactor);

        this.headCapacityFactor = headCapacityFactor;
        this.tailCapacityFactor = tailCapacityFactor;
    }

    // FIXME: implement
    @Override
    public void assertCapacity(final int itemsCount) {
        throw new UnsupportedOperationException("not implemnted [" + tailCapacityFactor + ", " + headCapacityFactor +
                                                "]");
    }

    @Override
    public Item getStoredItem(final int index) {
        assertEffectiveIndexInBounds(index);

        return getArrayItem(getArrayIndex(index));
    }

    /**
     * Asserts that the specified effective Item index is within the effective
     * index bounds.
     * 
     * @param effectiveIndex
     *        integer specifying the effective Item index
     * 
     * @throws IndexOutOfBoundsException
     *         if {@code effectiveIndex} is not within the previously specified
     *         bounds
     */
    private void assertEffectiveIndexInBounds(final int effectiveIndex) {
        if (effectiveIndex < firstItemEffectiveIndex || effectiveIndex > lastItemEffectiveIndex)
            throw new InvalidEffectiveIndexException(effectiveIndex, firstItemEffectiveIndex, lastItemEffectiveIndex);
    }

    /**
     * Returns the corresponding array Item index for the specified effective
     * Item index.
     * 
     * @param effectiveIndex
     *        integer specifying the effective Item index
     * 
     * @return integer specifying the array Item index
     */
    private int getArrayIndex(final int effectiveIndex) {
        final int relativeIndex = effectiveIndex - firstItemEffectiveIndex;

        return firstItemArrayIndex + relativeIndex;
    }

    // FIXME: implement
    @Override
    public void assertCapacity(final int itemsCount) {}
}
