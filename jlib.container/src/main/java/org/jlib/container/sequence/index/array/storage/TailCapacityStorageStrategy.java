package org.jlib.container.sequence.index.array.storage;

import java.util.Arrays;

import static java.lang.Math.min;

import org.jlib.container.sequence.index.array.storage.LinearIndexStorage.Copy;

/**
 * {@link LinearIndexStorage} parametrized with capacity factors for head and
 * tail buffers.
 * 
 * TODO: add more precise comment
 * 
 * @param <Item>
 *        type of the Items stored in the {@link LinearIndexStorage}
 * 
 * @author Igor Akkerman
 */
public class TailCapacityStorageStrategy<Item>
implements LinearIndexStorageCapacityStrategy {

    /** {@link LinearIndexStorage} holding the Items */
    private final LinearIndexStorage<Item> storage;

    /** effective index of the first Item */
    private int firstItemEffectiveIndex;

    /** effective index of the last Item */
    private int lastItemEffectiveIndex;

    /**
     * Creates a new {@link TailCapacityStorageStrategy}.
     * 
     * @param storage
     *        referenced {@link LinearIndexStoragWe}
     */
    public TailCapacityStorageStrategy(final LinearIndexStorage<Item> storage) {
        super();

        this.storage = storage;
    }

    // FIXME: implement
    @Override
    public void assertCapacity(final int itemsCount)
    throws LinearIndexStorageException {
        assertCapacityValid(itemsCount);

        if (storage.getItemsCount() >= itemsCount)
            return;

        storage.initialize(itemsCount, new Copy(0, getEffectiveItemsCount(), 0));
    }

    @Override
    public void assertCapacityWithHole(final int itemsCount, final int holeIndex, final int holeSize)
    throws LinearIndexStorageException {
        
        if (itemsCount < 1)
            throw new LinearIndexStorageException(storage, "itemsCount = {1} < 1; storage='{0}'", itemsCount);
        
        if (holeIndex < firstItem)
            
        firstItemEffectiveIndex = min(holeIndex, holeSize)
        
        assertCapacityValid(itemsCount);
        assertIndexValid(holeIndex);
        
        if (holeSize < 0)
            throw new Illegal

        // @formatter:off
        if (getEffectiveItemsCount() + holeSize > expectedCapacity)
            throw new InvalidLinearIndexStorageCapacityException
                (this, expectedCapacity, "{0}: getSize() + items.length == {2} + {3} > {1} == expectedCapacity",
                 getEffectiveItemsCount(), holeSize);
        // @formatter:on

        final Item[] originalDelegateArray = delegateArray;

        if (delegateArray.length < expectedCapacity) {
            delegateArray = createArray(expectedCapacity);

            System.arraycopy(originalDelegateArray, 0, delegateArray, 0, holeArrayIndex);
        }

        System.arraycopy(originalDelegateArray, holeArrayIndex, delegateArray, holeArrayIndex + holeSize,
                         getEffectiveItemsCount() - holeArrayIndex);

        Arrays.fill(delegateArray, getEffectiveItemsCount() + expectedCapacity, delegateArray.length, null);
    }

    private int getEffectiveItemsCount() {
        return lastItemEffectiveIndex - firstItemEffectiveIndex + 1;
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

}
