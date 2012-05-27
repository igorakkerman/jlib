package org.jlib.container.collection;

import java.util.Collection;
import java.util.Collections;

import org.jlib.container.AddContainer;
import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.RemoveContainer;
import org.jlib.container.RemoveTraverser;

import static org.jlib.core.array.ArrayUtility.iterable;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link AddContainer}. A
 * {@link CollectionAddRemoveContainer} is backed by a {@link Collection}
 * specified at initialization.
 * 
 * @param <Item>
 *        type of the items held in the {@link Container}
 * @author Igor Akkerman
 */
public class CollectionAddRemoveContainer<Item>
extends CollectionContainer<Item>
implements AddContainer<Item>, RemoveContainer<Item> {

    /**
     * Creates a new {@link CollectionAddRemoveContainer} backed by the
     * specified {@link Collection}.
     * 
     * @param delegateCollection
     *        {@link Collection} backing this
     *        {@link CollectionAddRemoveContainer}
     */
    public CollectionAddRemoveContainer(final Collection<Item> delegateCollection) {
        super(delegateCollection);
    }

    @Override
    public void add(final Item item) {
        getDelegateCollection().add(item);
    }

    @Override
    public void addAll(final Collection<? extends Item> items) {
        getDelegateCollection().addAll(items);
    }

    @Override
    public void addAll(final Container<? extends Item> items) {
        getDelegateCollection().addAll(getDelegateCollection());
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        Collections.addAll(getDelegateCollection(), items);
    }

    @Override
    public void remove(final Item item)
    throws IllegalArgumentException {
        final boolean removed = getDelegateCollection().remove(item);

        if (!removed)
            throw new IllegalArgumentException(item.toString());
    }

    @Override
    public void removeAll() {
        getDelegateCollection().clear();
    }

    @Override
    public void removeAll(final Collection<? extends Item> items) {
        getDelegateCollection().removeAll(items);
    }

    @Override
    public void removeAll(final Container<? extends Item> items) {
        CollectionUtility.removeAll(getDelegateCollection(), items);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.removeAll(this, iterable(items));
    }

    @Override
    public void removeAll(final Iterable<? extends Item> items) {
        ContainerUtility.removeAll(this, items);
    }

    @Override
    public void retainAll(final Collection<? extends Item> items) {
        getDelegateCollection().retainAll(items);
    }

    @Override
    public void retainAll(final Container<? extends Item> items) {
        ContainerUtility.retainAll(this, items);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.retainAll(this, items);
    }

    @Override
    public RemoveTraverser<Item> createTraverser() {
        return new RemoveIterableTraverser<>(getDelegateCollection());
    }

}
