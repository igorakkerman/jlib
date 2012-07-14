package org.jlib.container.sequence.index;

import static org.jlib.container.sequence.index.IndexSequenceUtility.assertIndexRangeValid;

/**
 * {@link IndexSequence} view of the Items stored in a base
 * {@link IndexSequence} in the specified index range. The Items in this
 * {@link SubIndexSequence} will have the same index as they had in the base
 * {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link SubIndexSequence}
 * 
 * @param <BaseSequence>
 *        type of the base {@link IndexSequence}
 * 
 * @author Igor Akkerman
 */
public class SubIndexSequence<Item, BaseSequence extends IndexSequence<Item>>
extends AbstractIndexSequence<Item> {

    /** BaseSequence of this {@link SubIndexSequence} */
    private final BaseSequence baseSequence;

    /**
     * Creates a new {@link SubIndexSequence}.
     * 
     * @param baseSequence
     *        base {@link IndexSequence}
     * 
     * @param firstIndex
     *        integer specifying the index of the first Item
     * 
     * @param lastIndex
     *        integer specifying the index of the last Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code firstIndex < baseSequence.getFirstIndex() || lastIndex > baseSequence.getLastIndex()}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code firstIndex > lastIndex}
     */
    public SubIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);

        assertIndexRangeValid(baseSequence, firstIndex, lastIndex);

        this.baseSequence = baseSequence;
    }

    @Override
    protected Item getStoredItem(final int index) {
        return baseSequence.get(index);
    }

    /**
     * Returns the base BaseSequence of this {@link SubIndexSequence}.
     * 
     * @return BaseSequence of this {@link SubIndexSequence}
     */
    protected BaseSequence getBaseSequence() {
        return baseSequence;
    }
}
