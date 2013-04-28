package org.jlib.container.sequence.index.array.storage;

/**
 * Descriptor of an Item copy operation specifying a source Item index range
 * <em>from</em> which and destination Item index <em>to</em> which a
 * specified amount of Items is copied.
 * 
 * @author Igor Akkerman
 */
public class ItemsCopy {

    /** begin index of the copied range */
    private final int sourceBeginIndex;

    /** end index of the copied range */
    private final int sourceEndIndex;

    /** index to which the range is copied */
    private final int targetIndex;

    /**
     * Creates a new {@link ItemsCopy}.
     * 
     * @param sourceBeginIndex
     *        integer specifying the begin index of the copied range
     * 
     * @param sourceEndIndex
     *        integer specifying the end index of the copied range
     * 
     * @param targetIndex
     *        integer specifying the index to which the range is copied
     */
    public ItemsCopy(final int sourceBeginIndex, final int sourceEndIndex, final int targetIndex) {
        super();

        this.sourceBeginIndex = sourceBeginIndex;
        this.sourceEndIndex = sourceEndIndex;
        this.targetIndex = targetIndex;
    }

    /**
     * Returns the begin index of the copied range.
     * 
     * @return integer specifying the begin index of the copied range
     */
    public int getSourceBeginIndex() {
        return sourceBeginIndex;
    }

    /**
     * Returns the end index of the copied range.
     * 
     * @return integer specifying the end index of the copied range
     */
    public int getSourceEndIndex() {
        return sourceEndIndex;
    }

    /**
     * Returns the index to which the range is copied.
     * 
     * @return integer specifying the index to which the range is copied
     */
    public int getTargetIndex() {
        return targetIndex;
    }
}