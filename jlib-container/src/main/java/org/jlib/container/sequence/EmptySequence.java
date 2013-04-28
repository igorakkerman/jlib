package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

import org.jlib.container.Container;
import org.jlib.container.EmptyContainer;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.ObservedRandomAccessRemoveContainer;
import org.jlib.container.ObservedRemoveAllContainer;
import org.jlib.container.sequence.index.ReplaceIndexSequence;

/**
 * Empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items
 * 
 * @author Igor Akkerman
 */
public class EmptySequence<Item>
extends EmptyContainer<Item>
implements ObservedReplaceSequence<Item>, ObservedRemoveSequence<Item>, ObservedRandomAccessRemoveContainer<Item>,
ObservedRemoveAllContainer<Item> {

    /** sole instance of this class */
    private static final EmptySequence<?> INSTANCE = new EmptySequence<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @param <Item>
     *        type of potential items potentially held in this
     *        {@link EmptySequence}
     * 
     * @return sole {@link ReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequence<Item> getInstance() {
        return (EmptySequence<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequence}.
     */
    protected EmptySequence() {
        super();
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException {
        throw new NoSuchItemToRemoveException(this, item);
    }

    @Override
    public void removeAll()
    throws NoSuchItemToRemoveException {
        // intentionally blank
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws NoSuchItemToRemoveException {
        // intentionally blank
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws IllegalContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser() {
        return EmptySequenceTraverser.getInstance();
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}
