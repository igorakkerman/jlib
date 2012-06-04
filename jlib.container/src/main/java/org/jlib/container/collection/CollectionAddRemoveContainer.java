package org.jlib.container.collection;

import java.util.Collection;
import java.util.Collections;

import org.jlib.container.AddContainer;
import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.RemoveContainer;
import org.jlib.core.traverser.RemoveIterableTraverser;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link AddContainer}. A
 * {@link CollectionAddRemoveContainer} is backed by a {@link Collection}
 * specified at initialization.
 * 
 * @param <Item>
 *        type of the items held in the {@link Container}
 * 
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
    public void assertContained(final Item item)
    throws IllegalContainerArgumentException {
        getDelegateCollection().add(item);
    }

    @Override
    public void assertContained(final Container<? extends Item> items)
    throws IllegalContainerArgumentException {
        ContainerUtility.assertContained(this, items);
    }

    @Override
    public void assertContained(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException {
        ContainerUtility.assertContained(this, items);
    }

    @Override
    public void assertContained(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException {
        ContainerUtility.assertContained(this, items);
    }

    @Override
    public void add(final Item item) {
        ContainerUtility.add(this, item);
    }

    @Override
    public void add(final Collection<? extends Item> items) {
        getDelegateCollection().addAll(items);
    }

    @Override
    public void add(final Container<? extends Item> items) {
        getDelegateCollection().addAll(getDelegateCollection());
    }

    @Override
    public void add(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
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
    public void remove(final Collection<? extends Item> items) {
        getDelegateCollection().removeAll(items);
    }

    @Override
    public void remove(final Container<? extends Item> items) {
        CollectionUtility.removeAll(getDelegateCollection(), items);
    }

    @Override
    public void remove(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items) {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void retain(final Collection<? extends Item> items) {
        getDelegateCollection().retainAll(items);
    }

    @Override
    public void retain(final Container<? extends Item> items) {
        ContainerUtility.retain(this, items);
    }

    @Override
    public void retain(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.retain(this, items);
    }

    @Override
    public RemoveTraverser<Item> createTraverser() {
        return new RemoveIterableTraverser<>(getDelegateCollection());
    }
}
