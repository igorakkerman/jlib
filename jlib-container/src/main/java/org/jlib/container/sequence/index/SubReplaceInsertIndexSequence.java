package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.core.observer.ValueObserver;

/**
 * {@link SubReplaceIndexSequence} view of the Items stored in another
 * {@link ReplaceIndexSequence} in the specified index range. The Items in this
 * {@link SubReplaceInsertIndexSequence} will have the same index as they had in
 * the base {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link SubReplaceInsertIndexSequence}
 * 
 * @param <BaseSequence>
 *        type of the base {@link ObservedReplaceInsertIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class SubReplaceInsertIndexSequence<Item, BaseSequence extends ObservedReplaceInsertIndexSequence<Item>>
extends SubReplaceIndexSequence<Item, BaseSequence>
implements ObservedReplaceInsertIndexSequence<Item> {

    /**
     * Creates a new {@link SubReplaceInsertIndexSequence}.
     * 
     * @param baseSequence
     *        base {@link ReplaceInsertIndexSequence}
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
    public SubReplaceInsertIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        super(baseSequence, firstIndex, lastIndex);
    }

    @Override
    public void insert(final int index, final Item item) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, item);
    }

    @Override
    public void insert(final int index, final Container<? extends Item> items) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, items);
    }

    @Override
    public void insert(final int index, final Collection<? extends Item> items) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Item... items) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, items);
    }

    @Override
    public ObservedReplaceInsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceInsertIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser() {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this);
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Item item, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, item, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Container<? extends Item> items, final ValueObserver<Item>... observers) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Collection<? extends Item> items, final ValueObserver<Item>... observers) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final ValueObserver<Item>[] observers, final Item... items) {
        IndexSequenceUtility.assertIndexValid(this, index);

        getBaseSequence().insert(index, observers, items);
    }
}