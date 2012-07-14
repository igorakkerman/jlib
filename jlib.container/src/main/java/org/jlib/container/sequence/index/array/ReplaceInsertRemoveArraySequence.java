package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

import org.jlib.container.Container;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceUtility;
import org.jlib.container.sequence.index.DefaultReplaceInsertRemoveIndexSequenceTraverser;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.ObservedReplaceInsertRemoveIndexSequence;
import org.jlib.container.sequence.index.ObservedReplaceInsertRemoveIndexSequenceTraverser;

/**
 * {@link ReplaceInsertArraySequence} to which Items can be added.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceInsertRemoveArraySequence<Item>
extends ReplaceInsertRemoveFirstLastArraySequence<Item>
implements ObservedReplaceInsertRemoveIndexSequence<Item> {

    /**
     * Creates a new uninitialized {@link ReplaceInsertRemoveArraySequence} with
     * the specified first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the initial first index
     * 
     * @param lastIndex
     *        integer specifying the initial last index
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected ReplaceInsertRemoveArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
     * of {@code 0} and the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertRemoveArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
     * of {@code 0} containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with the specified
     * first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
     * of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with the specified
     * first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
     * of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Sequence} of Items to store
     */
    public ReplaceInsertRemoveArraySequence(final Sequence<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveArraySequence} with the specified
     * first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Sequence} of Items to store
     */
    public ReplaceInsertRemoveArraySequence(final int firstIndex, final Sequence<? extends Item> items) {
        super(firstIndex, items);
    }

    // FIXME: implement
    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalSequenceArgumentException, IllegalSequenceStateException {}

    @Override
    public void remove(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {
        SequenceUtility.remove(this, items);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {
        SequenceUtility.remove(this, items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {
        SequenceUtility.remove(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {
        SequenceUtility.remove(this, items);
    }

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalSequenceArgumentException, IllegalSequenceStateException,
    ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {}

    // FIXME: implement
    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser() {
        return new DefaultReplaceInsertRemoveIndexSequenceTraverser<>(this);
    }
}
