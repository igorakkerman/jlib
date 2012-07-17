package org.jlib.container.sequence.index.array.storage;

/**
 * {@link LinearIndexStorage} parametrized with capacity factors for head and
 * tail buffers.
 * 
 * TODO: add more precise comment
 * 
 * @param <Item>
 *        type of the Items stored in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayStorage<Item>
implements LinearIndexStorage<Item> {

    /** array holding the Items */
    private Item[] array;

    /** array index of the first Item */
    private int firstItemArrayIndex;

    /** array index of the last Item */
    private int lastItemArrayIndex;

    /** effective index of the first Item */
    private int firstItemEffectiveIndex;

    /** effective index of the last Item */
    private int lastItemEffectiveIndex;

    @Override
    public Item getStoredItem(final int effectiveIndex) {
        assertEffectiveIndexInBounds(effectiveIndex);

        return getArrayItem(getArrayIndex(effectiveIndex));
    }

    /**
     * Returns the array Item stored at the specified array index.
     * 
     * @param arrayIndex
     *        integer specifying the array index
     * 
     * @return Item stored at {@code arrayIndex}
     */
    protected Item getArrayItem(final int arrayIndex) {
        return array[arrayIndex];
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

    @Override
    public void replaceStoredItem(final int effectiveIndex, final Item item) {}

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
