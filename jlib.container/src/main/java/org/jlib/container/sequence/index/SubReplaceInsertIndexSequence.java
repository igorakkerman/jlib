package org.jlib.container.sequence.index;

import java.util.Collection;
import java.util.Collections;

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;
import org.jlib.core.observer.ValueObserver;

import org.jlib.container.AppendAware;
import org.jlib.container.Container;
import org.jlib.container.ObservedPrependAware;
import org.jlib.container.PrependAware;
import org.jlib.container.sequence.IllegalSequenceArgumentException;

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

    private final AppendAware<Item> appendState;

    private final PrependAware<Item> prependState;

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

        prependState = baseSequence.getFirstIndex() == firstIndex
            ? new ObservedPrependAware<Item>() {

                @Override
                public final void prepend(final Item item)
                throws IllegalJlibArgumentException, IllegalJlibStateException {
                    getBaseSequence().prepend(item);
                }

                @Override
                public final void prepend(final Container<? extends Item> items)
                throws IllegalJlibArgumentException, IllegalJlibStateException {
                    getBaseSequence().prepend(items);
                }

                @Override
                public final void prepend(final Collection<? extends Item> items)
                throws IllegalJlibArgumentException, IllegalJlibStateException {
                    getBaseSequence().prepend(items);
                }

                @Override
                @SafeVarargs
                public final void prepend(final Item... items)
                throws IllegalJlibArgumentException, IllegalJlibStateException {
                    getBaseSequence().prepend(items);
                }

                @Override
                @SafeVarargs
                public final void prepend(final Item item, final ValueObserver<Item>... observers)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {
                    getBaseSequence().prepend(item, observers);
                }

                @Override
                public final void prepend(final Container<? extends Item> items, final ValueObserver<Item>... observers)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {
                    getBaseSequence().prepend(items, observers);
                }

                @Override
                @SafeVarargs
                public final void prepend(final Collection<? extends Item> items,
                                          final ValueObserver<Item>... observers)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {
                    getBaseSequence().prepend(items, observers);
                }

                @Override
                @SafeVarargs
                public final void prepend(final ValueObserver<Item>[] observers, final Item... items)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {
                    getBaseSequence().prepend(observers, items);
                }

            }
            : new ObservedPrependAware<Item>() {

                @Override
                public final void prepend(final Item item)
                throws IllegalJlibArgumentException, IllegalJlibStateException {}

                @Override
                public final void prepend(final Container<? extends Item> items)
                throws IllegalJlibArgumentException, IllegalJlibStateException {}

                @Override
                public final void prepend(final Collection<? extends Item> items)
                throws IllegalJlibArgumentException, IllegalJlibStateException {}

                @Override
                @SafeVarargs
                public final void prepend(final Item... items)
                throws IllegalJlibArgumentException, IllegalJlibStateException {}

                @Override
                @SafeVarargs
                public final void prepend(final Item item, final ValueObserver<Item>... observers)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {}

                @Override
                @SafeVarargs
                public final void prepend(final Container<? extends Item> items, final ValueObserver<Item>... observers)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {}

                @Override
                @SafeVarargs
                public final void prepend(final Collection<? extends Item> items,
                                          final ValueObserver<Item>... observers)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {}

                @Override
                @SafeVarargs
                public final void prepend(final ValueObserver<Item>[] observers, final Item... items)
                throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException {}
            };
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
    public void append(final Item item)
    throws IllegalSequenceArgumentException {
        appendState.append(item);
        setFirstIndex(getFirstIndex() + 1);
    }

//    setFirstIndex(getFirstIndex() - 1);
//    setFirstIndex(getFirstIndex() - items.getItemsCount());
//    setFirstIndex(getFirstIndex() - items.size());
//    setFirstIndex(getFirstIndex() - items.length);
//    setFirstIndex(getFirstIndex() - 1);
//    setFirstIndex(getFirstIndex() - items.getItemsCount());
//    setFirstIndex(getFirstIndex() - items.size());
//    setFirstIndex(getFirstIndex() - items.length);

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void append(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    public void append(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    public void append(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    public void append(final Item... items)
    throws IllegalSequenceArgumentException {}

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Item item, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        append(Collections.singleton(item), observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        append((Iterable<? extends Item>) items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        append((Iterable<? extends Item>) items, observers);
    }

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final Item item, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    public void prepend(final Item item)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    public void prepend(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    public void prepend(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final Item... items)
    throws IllegalSequenceArgumentException {}

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
}
