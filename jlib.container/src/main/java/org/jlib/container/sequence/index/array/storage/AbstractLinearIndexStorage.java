package org.jlib.container.sequence.index.array.storage;

/**
 * Skeletal implementation of a {@link LinearIndexStorage}.
 * 
 * @param <Item>
 *        type of the Items stored in the {@link AbstractLinearIndexStorage}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractLinearIndexStorage<Item>
implements LinearIndexStorage<Item> {

    /** array index of the first Item */
    private Integer firstItemIndex;

    /** array index of the last Item */
    private Integer lastItemIndex;

    /**
     * Creates a new {@link AbstractLinearIndexStorage}.
     */
    public AbstractLinearIndexStorage() {
        super();
    }

    @Override
    public int getFirstItemIndex() {
        return firstItemIndex;
    }

    @Override
    public void setFirstItemIndex(final int firstItemIndex) {
        this.firstItemIndex = firstItemIndex;
    }

    @Override
    public int getLastItemIndex() {
        return lastItemIndex;
    }

    @Override
    public void setLastItemIndex(final int lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    @Override
    public int getItemsCount() {
        return lastItemIndex - firstItemIndex + 1;
    }
}
