package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.EmptyContainer;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
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
implements ObservedReplaceSequence<Item>, ObservedRemoveSequence<Item> {

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
        ContainerUtility.removeAll(this);
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws NoSuchItemToRemoveException {
        ContainerUtility.removeAll(this);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws NoSuchItemToRemoveException, IllegalContainerStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        ContainerUtility.remove(this, item, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        ContainerUtility.remove(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        ContainerUtility.remove(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException {
        ContainerUtility.remove(observers, this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws IllegalContainerStateException {
        ContainerUtility.removeAll(this, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        ContainerUtility.remove(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        ContainerUtility.remove(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        ContainerUtility.remove(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        ContainerUtility.retain(this, observers, items);
    }

    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser() {
        return EmptySequenceTraverser.getInstance();
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}
