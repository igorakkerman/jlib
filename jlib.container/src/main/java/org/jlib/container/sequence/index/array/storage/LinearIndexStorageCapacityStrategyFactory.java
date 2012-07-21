package org.jlib.container.sequence.index.array.storage;

/**
 * Abstract factory for {@link LinearIndexStorageCapacityStrategy} instances.
 * 
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityStrategyFactory {

    /**
     * Creates a new {@link LinearIndexStorageCapacityStrategy}.
     * 
     * @param <Item>
     *        type of the Items stored in {@code storage}
     * 
     * @param storage
     *        referenced {@link LinearIndexStorage}
     * 
     * @return newly created {@link LinearIndexStorageCapacityStrategy}
     */
    public <Item> LinearIndexStorageCapacityStrategy createLinearIndexStorageCapacityStrategy(LinearIndexStorage<Item> storage);
}
