package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.sequence.ObservedRemoveSequence;
import org.jlib.container.sequence.ObservedRemoveSequenceTraverser;
import org.jlib.container.sequence.RemoveSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.ObservedRemoveTraverser;

/**
 * {@link ReplaceArraySequence} to which Items can be added.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendRemoveArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements ObservedRemoveSequence<Item> {

    /**
     * {@link IndexSequenceCreator} of {@link ReplaceAppendRemoveArraySequence}
     * insstances
     */
    private static final IndexSequenceCreator<?, ? extends ReplaceAppendRemoveArraySequence<?>> CREATOR =
        new IndexSequenceCreator<Object, ReplaceAppendRemoveArraySequence<Object>>() {

            @Override
            public ReplaceAppendRemoveArraySequence<Object> createSequence(final int firstIndex, final int lastIndex)
            throws InvalidSequenceIndexRangeException {
                return new ReplaceAppendRemoveArraySequence<Object>(firstIndex, lastIndex);
            }
        };

    /**
     * Returns the {@link IndexSequenceCreator} of
     * {@link ReplaceAppendRemoveArraySequence} instances.
     * 
     * @return {@link IndexSequenceCreator} of
     *         {@link ReplaceAppendRemoveArraySequence} instances
     */
    @SuppressWarnings("unchecked")
    public static <Item> IndexSequenceCreator<Item, ? extends ReplaceAppendRemoveArraySequence<Item>> getCreator() {
        return (IndexSequenceCreator<Item, ReplaceAppendRemoveArraySequence<Item>>) CREATOR;
    }

    /**
     * Creates a new {@link ReplaceAppendRemoveArraySequence} with the specified
     * first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @throws IllegalArgumentException
     *         if {@code lastIndex > firstIndex}
     */
    protected ReplaceAppendRemoveArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    // FIXME: implement
    @Override
    public RemoveSequenceTraverser<Item> createRemoveTraverser() {
        return null;
    }

    // FIXME: implement
    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    public void removeAll()
    throws IllegalContainerStateException {}

    // FIXME: implement
    @Override
    public void remove(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    public void remove(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    public void remove(final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public ObservedRemoveSequenceTraverser<Item> createRemoveTraverser(final ValueObserver<Item>... observers) {
        return null;
    }

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws IllegalContainerStateException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException,
    ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {}

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public ObservedRemoveTraverser<Item> createObservedRemoveTraverser(final ValueObserver<Item>... observers) {
        return null;
    }
}
