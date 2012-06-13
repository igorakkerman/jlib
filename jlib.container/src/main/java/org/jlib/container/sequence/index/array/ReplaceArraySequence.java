package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.ObservedReplaceSequenceTraverser;
import org.jlib.container.sequence.ReplaceSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.ObservedReplaceIndexSequence;
import org.jlib.container.sequence.index.ObservedReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.ReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link ArraySequence} allowing its Items to be replaced.
 * 
 * @param <Item>
 *        type of the items of the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceArraySequence<Item>
extends ArraySequence<Item>
implements ObservedReplaceIndexSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link ReplaceArraySequence} insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceArraySequence<Object>>() {

            @Override
            public ReplaceArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of {@link ReplaceArraySequence}
     * instances.
     * 
     * @return {@link IndexSequenceCreator} of {@link ReplaceArraySequence}
     * 
     *         instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ? extends ReplaceArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceArraySequence}.
     * 
     * @param firstIndex
     *        first index of this {@link ReplaceArraySequence}
     * 
     * @param lastIndex
     *        last index of this {@link ReplaceArraySequence}
     */
    protected ReplaceArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    // raising visibility from protected to public
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException {
        super.replace(index, newItem);
    }

    @Override
    @SafeVarargs
    // raising visibility from protected to public
    public final void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException {
        super.replace(index, newItem, observers);
    }

    /**
     * Replaces the Item stored in the delegate array at the specified index.
     * 
     * @param itemArrayIndex
     *        integer specifying the index of the Item in the array
     * 
     * @param newItem
     *        replacing Item
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    protected final void replaceDelegateArrayItem(final Item newItem, final int itemArrayIndex,
                                                  final ValueObserver<Item>... observers)
    throws RuntimeException {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate() {
                replaceDelegateArrayItem(itemArrayIndex, newItem);
            }
        },

        newItem, observers);
    }

    @Override
    public ReplaceTraverser<Item> createReplaceTraverser() {
        return createObservedReplaceIndexSequenceTraverser();
    }

    @Override
    public ReplaceSequenceTraverser<Item> createReplaceSequenceTraverser() {
        return createObservedReplaceIndexSequenceTraverser();
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser() {
        return createObservedReplaceIndexSequenceTraverser();
    }

    @Override
    public ReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return createObservedReplaceIndexSequenceTraverser(startIndex);
    }

    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createObservedReplaceIndexSequenceTraverser()
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceTraverser<>(this);
    }

    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createObservedReplaceIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceSequenceTraverser<Item> createReplaceSequenceTraverser(final ValueObserver<Item>... observers) {
        return createObservedReplaceIndexSequenceTraverser();
    }
}
