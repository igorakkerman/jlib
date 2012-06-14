package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.EmptyContainer;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.sequence.index.ReplaceIndexSequence;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.BidirectionalTraverser;
import org.jlib.core.traverser.ObservedRemoveTraverser;
import org.jlib.core.traverser.ReplaceTraverser;

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
    public EmptySequenceTraverser<Item> createSequenceTraverser() {
        return EmptySequenceTraverser.getInstance();
    }

    @Override
    public BidirectionalTraverser<Item> createBidirectionalTraverser() {
        return createSequenceTraverser();
    }

    @Override
    public ReplaceTraverser<Item> createReplaceTraverser() {
        return createSequenceTraverser();
    }

    @Override
    public ObservedReplaceSequenceTraverser<Item> createReplaceSequenceTraverser() {
        return createSequenceTraverser();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceSequenceTraverser<Item> createReplaceSequenceTraverser(final ValueObserver<Item>... observers) {
        return createSequenceTraverser();
    }

    @Override
    public RemoveSequenceTraverser<Item> createRemoveTraverser() {
        return createSequenceTraverser();
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
    public ObservedRemoveSequenceTraverser<Item> createRemoveTraverser(final ValueObserver<Item>... observers) {
        return new EmptySequenceTraverser<>();
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
    @SuppressWarnings("unchecked")
    public ObservedRemoveTraverser<Item> createObservedRemoveTraverser(final ValueObserver<Item>... observers) {
        return createSequenceTraverser();
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}
