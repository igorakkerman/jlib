package org.jlib.container.collection;

import java.util.Collection;
import java.util.Collections;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.ObservedRemoveContainer;
import org.jlib.container.RemoveContainer;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.RemoveIterableTraverser;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link RemoveContainer}
 * ^ {@link Collection} specified at initialization.
 * 
 * @param <Item>
 *        type of the items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public class CollectionRemoveContainer<Item>
extends CollectionContainer<Item>
implements ObservedRemoveContainer<Item> {

    /**
     * Creates a new {@link CollectionRemoveContainer} backed by the specified
     * {@link Collection}.
     * 
     * @param delegateCollection
     *        {@link Collection} backing this {@link CollectionRemoveContainer}
     */
    public CollectionRemoveContainer(final Collection<Item> delegateCollection) {
        super(delegateCollection);
    }

    /**
     * Adds the specified Item to this {@link CollectionRemoveContainer} using
     * the {@link Collection#add(Object)} operation of the delegate
     * {@link Collection}.
     * 
     * @param item
     *        added Item
     * 
     * @throws IllegalContainerDelegateArgumentException
     *         if {@code item} caused an error during the operation of the
     *         delegate {@link Collection}
     * 
     * @throws IllegalContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(final Item item)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        try {
            getDelegateCollection().add(item);
        }
        catch (final IllegalArgumentException exception) {
            throw new IllegalContainerDelegateArgumentException(this, getDelegateCollection(), item,
                                                                "{1}: {2} - add({3})", exception);
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - add({3})",
                                                             exception, item);
        }
    }

    /**
     * Adds the specified Items to this {@link CollectionRemoveContainer} using
     * the {@link Collection#addAll(Collection)} operation of the delegate
     * {@link Collection}.
     * 
     * @param items
     *        {@link Collection} of added Items
     * 
     * @throws IllegalContainerDelegateArgumentException
     *         if an Item in {@code items} caused an error during the operation
     *         of the delegate {@link Collection}
     * 
     * @throws IllegalContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(final Collection<? extends Item> items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        try {
            getDelegateCollection().addAll(items);
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalContainerDelegateStateException(this, getDelegateCollection(),
                                                             "{1}: Collections.addAll({2}, {3})", exception, items);
        }
    }

    /**
     * Adds the specified Items to this {@link CollectionRemoveContainer} using
     * the {@link Collection#addAll(Collection)} operation of the delegate
     * {@link Collection}.
     * 
     * @param items
     *        {@link Container} of added Items
     * 
     * @throws IllegalContainerDelegateArgumentException
     *         if an Item in {@code items} caused an error during the operation
     *         of the delegate {@link Collection}
     * 
     * @throws IllegalContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(final Container<? extends Item> items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        for (final Item item : items)
            getDelegateCollection().add(item);
    }

    /**
     * Adds the specified Items to this {@link CollectionRemoveContainer} using
     * the {@link Collection#addAll(Collection)} operation of the delegate
     * {@link Collection}.
     * 
     * @param items
     *        comma separated sequence of added Items
     * 
     * @throws IllegalContainerDelegateArgumentException
     *         if an Item in {@code items} caused an error during the operation
     *         of the delegate {@link Collection}
     * 
     * @throws IllegalContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        try {
            Collections.addAll(getDelegateCollection(), items);
        }
        catch (final IllegalArgumentException | IllegalStateException exception) {
            throw new IllegalContainerDelegateArgumentException(this, getDelegateCollection(), items,
                                                                "{1}: Collections.addAll({2}, {3})", exception);
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalContainerDelegateStateException(this, getDelegateCollection(),
                                                             "{1}: Collections.addAll({2}, {3})", exception, items);
        }
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerDelegateStateException {
        try {
            final boolean removed = getDelegateCollection().remove(item);

            if (!removed)
                throw new NoSuchItemToRemoveException(this, item);
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - remove({3})",
                                                             exception, item);
        }
    }

    @Override
    public void removeAll()
    throws IllegalContainerDelegateStateException {
        try {
            getDelegateCollection().clear();
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - clear()",
                                                             exception);
        }
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws IllegalContainerDelegateStateException {
        try {
            getDelegateCollection().removeAll(items);
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalContainerDelegateStateException(this, getDelegateCollection(),
                                                             "{1}: {2} - removeAll({3})", exception, items);
        }
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        CollectionUtility.removeAll(getDelegateCollection(), items);
    }

    @Override
    public void remove(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        getDelegateCollection().retainAll(items);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    public void retain(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerDelegateArgumentException, IllegalContainerDelegateStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    public RemoveTraverser<Item> createRemoveTraverser()
    throws IllegalContainerDelegateStateException {
        return new RemoveIterableTraverser<>(getDelegateCollection());
    }

    @Override
    public void remove(final Item item,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException,
    ValueObserverException {
        ContainerUtility.remove(this, item, observers);
    }
}
