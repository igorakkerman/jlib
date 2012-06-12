package org.jlib.container.collection;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.AbstractContainer;
import org.jlib.container.Container;
import org.jlib.core.traverser.IterableTraverser;
import org.jlib.core.traverser.Traverser;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link Container}. A
 * {@link CollectionContainer} is backed by a {@link Collection} specified at
 * initialization.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * @author Igor Akkerman
 */
public class CollectionContainer<Item>
extends AbstractContainer<Item> {

    /** adapted and backed {@link Collection} */
    private final Collection<Item> delegateCollection;

    /**
     * Creates a new {@link ContainerCollection} backed by the specified
     * {@link Collection}.
     * 
     * @param delegateCollection
     *        {@link Collection} backing this {@link CollectionContainer}
     */
    public CollectionContainer(final Collection<Item> delegateCollection) {
        this.delegateCollection = delegateCollection;
    }

    // implemented for efficiency
    @Override
    public int getItemsCount() {
        return delegateCollection.size();
    }

    @Override
    public Traverser<Item> createTraverser() {
        return new IterableTraverser<>(this);
    }

    // implemented for efficiency
    @Override
    public Iterator<Item> iterator() {
        return delegateCollection.iterator();
    }

    // implemented for efficiency
    @Override
    public boolean isContaining(final Item item) {
        return delegateCollection.contains(item);
    }

    // implemented for efficiency
    @Override
    public boolean isContaining(final Collection<? extends Item> collection) {
        return delegateCollection.containsAll(collection);
    }

    // implemented for efficiency
    @Override
    @SuppressWarnings("unchecked")
    public Item[] toArray() {
        return (Item[]) delegateCollection.toArray();
    }

    /**
     * Returns the {@link Collection} adapted and backed by this
     * {@link CollectionContainer}.
     * 
     * @return delegate {@link Collection} of this {@link CollectionContainer}
     */
    protected Collection<Item> getDelegateCollection() {
        return delegateCollection;
    }
}
