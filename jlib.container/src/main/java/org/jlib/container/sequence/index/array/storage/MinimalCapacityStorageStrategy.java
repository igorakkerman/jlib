package org.jlib.container.sequence.index.array.storage;

import java.util.Arrays;

import static java.lang.Math.min;

import org.jlib.container.sequence.index.array.storage.LinearIndexStorage.Copy;

/**
 * {@link LinearIndexStorageCapacityStrategy} providing just as much capacity as
 * requested.
 * 
 * @param <Item>
 *        type of the {@link LinearIndexStorage} Items
 * 
 * @author Igor Akkerman
 */
public class MinimalCapacityStorageStrategy<Item>
implements LinearIndexStorageCapacityStrategy {

    /** {@link LinearIndexStorage} holding the Items */
    private final LinearIndexStorage<Item> storage;

    /**
     * Creates a new {@link MinimalCapacityStorageStrategy}.
     * 
     * @param storage
     *        referenced {@link LinearIndexStorage}
     */
    public MinimalCapacityStorageStrategy(final LinearIndexStorage<Item> storage) {
        super();

        this.storage = storage;
    }

    @Override
    public void assertHeadCapacity(final int headCapacity)
    throws LinearIndexStorageException {
        if (headCapacity < 0)
            throw new LinearIndexStorageException(storage, "headCapacity = {1} < 1; storage = '{0}'", headCapacity);

        final int requiredCapacity = headCapacity + storage.getItemsCount();

        final Copy copyDescriptor = new Copy(storage.getFirstItemIndex(), storage.getItemsCount(), headCapacity);

        if (requiredCapacity <= storage.getCapacity()) {
            if (storage.getFirstItemIndex() < headCapacity)
                storage.copy(copyDescriptor);
        }
        else
            storage.initialize(requiredCapacity, copyDescriptor);
    }

    @Override
    public void assertTailCapacity(final int tailCapacity)
    throws LinearIndexStorageException {
        if (tailCapacity < 0)
            throw new LinearIndexStorageException(storage, "tailCapacity = {1} < 1; storage = '{0}'", tailCapacity);

        final Copy copyDescriptor = new Copy(storage.getFirstItemIndex(), storage.getItemsCount(), 0);

        final int requiredCapacity = storage.getItemsCount() + tailCapacity;

        if (requiredCapacity <= storage.getCapacity()) {
            if (storage.getCapacity() - storage.getLastItemIndex() + 1 <= tailCapacity)
                storage.copy(copyDescriptor);
        }
        else
            storage.initialize(requiredCapacity, copyDescriptor);
    }

    @Override
    public void assertMiddleCapacity(final int middleCapacity, final int middleIndex)
    throws LinearIndexStorageException {
        if (middleCapacity < 0)
            throw new LinearIndexStorageException(storage, "middleCapacity = {1} < 1; storage = '{0}'", middleCapacity);
        
        if (middleIndex < storage.getFirstItemIndex())
            throw new LinearIndexStorageException(storage, "middleIndex = {1} > {2} = firstIndex; storage = '{0}'", middleIndex, storage.getFirstItemIndex());
            
        if (middleIndex > storage.getLastItemIndex())
            throw new LinearIndexStorageException(storage, "middleIndex = {1} < {2} = lastIndex; storage = '{0}'", middleIndex, storage.getLastItemIndex());
        
        final int requiredCapacity = storage.getItemsCount() + middleCapacity;

//        final Copy copyDescriptorLeft = new Copy(storage.getFirstItemIndex(), storage.getLastItemIndex() - middleIndex + 1, middleIndex + middleCapacity);
        final Copy copyDescriptorRight = new Copy(storage.getFirstItemIndex(), storage.getLastItemIndex() - middleIndex + 1, middleIndex + middleCapacity);

        if (requiredCapacity <= storage.getCapacity()) {
            if (storage.getLastItemIndex() - 1 <= middleCapacity)
                storage.copy(copyDescriptor);
        }
        else
            storage.initialize(requiredCapacity, copyDescriptor);

        
        
        
        
        firstItemEffectiveIndex = min(holeIndex, holeSize)
        
        assertFullCapacityValid(itemsCount);
        assertIndexValid(holeIndex);
        
        if (holeSize < 0)
            throw new Illegaldue.redat

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

//    /**
//     * Asserts that the specified effective Item index is within the effective
//     * index bounds.
//     * 
//     * @param effectiveIndex
//     *        integer specifying the effective Item index
//     * 
//     * @throws IndexOutOfBoundsException
//     *         if {@code effectiveIndex} is not within the previously specified
//     *         bounds
//     */
//    private void assertEffectiveIndexInBounds(final int effectiveIndex) {
//        if (effectiveIndex < firstItemEffectiveIndex || effectiveIndex > lastItemEffectiveIndex)
//            throw new InvalidEffectiveIndexException(effectiveIndex, firstItemEffectiveIndex, lastItemEffectiveIndex);
//    }

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

    /**
     * Asserts that the specified capacity is valid.
     * 
     * @param itemsCount
     *        integer specifying the number of Items to fit
     * 
     * @throws LinearIndexStorageException
     *         if {@code itemsCount < 1}
     */
    private void assertFullCapacityValid(final int itemsCount) {
        if (itemsCount < 1)
            throw new LinearIndexStorageException(storage, "itemsCount = {1} < 1; storage = '{0}'", itemsCount);
    }

    /**
     * Asserts that the specified hole size is valid.
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if {@code holeSize < 1}
     */
    private void assertPartCapacityValid(final int holeSize) {
        if (holeSize < 0)
            throw new LinearIndexStorageException(storage, "holeSize = {1} < 1; storage = '{0}'", holeSize);
    }

}
