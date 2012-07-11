package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.sequence.ObservedRemoveSequence;
import org.jlib.container.sequence.ObservedReplaceRemoveSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

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
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException {}

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
    public void removeAll()
    throws IllegalContainerStateException {
        SequenceUtility.remove(this);
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
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser() {
        return null;
    }

    // FIXME: implement
    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser(final ValueObserver<Item>... observers) {
        return null;
    }
}
