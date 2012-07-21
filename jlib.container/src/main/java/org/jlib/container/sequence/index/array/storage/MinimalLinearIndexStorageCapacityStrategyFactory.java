package org.jlib.container.sequence.index.array.storage;

/**
 * {@link LinearIndexStorageCapacityStrategy} creating
 * {@link MinimalLinearIndexStorageCapacityStrategy} instances.
 * 
 * @author Igor Akkerman
 */
public class MinimalLinearIndexStorageCapacityStrategyFactory
implements LinearIndexStorageCapacityStrategyFactory {

    /** sole {@link MinimalLinearIndexStorageCapacityStrategyFactory} instance */
    private static final MinimalLinearIndexStorageCapacityStrategyFactory INSTANCE =
        new MinimalLinearIndexStorageCapacityStrategyFactory();

    /**
     * Returns the sole {@link MinimalLinearIndexStorageCapacityStrategyFactory}
     * instance.
     * 
     * @return sole {@link MinimalLinearIndexStorageCapacityStrategyFactory}
     *         instance
     */
    public static MinimalLinearIndexStorageCapacityStrategyFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new {@link MinimalLinearIndexStorageCapacityStrategyFactory}
     * instance.
     */
    private MinimalLinearIndexStorageCapacityStrategyFactory() {
        super();
    }

    @Override
    public <Item> LinearIndexStorageCapacityStrategy createLinearIndexStorageCapacityStrategy(final LinearIndexStorage<Item> storage) {
        return new MinimalLinearIndexStorageCapacityStrategy<>(storage);
    }
}
