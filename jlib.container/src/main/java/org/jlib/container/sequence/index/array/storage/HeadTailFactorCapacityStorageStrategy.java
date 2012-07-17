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
implements LinearIndexStorageCapacityProvider {

    /** factor for the head capacity */
    private final int headCapacityFactor;

    /** factor for the tail capacity */
    private final int tailCapacityFactor;

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
}
