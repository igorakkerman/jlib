/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.operation.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import IterableIterator;
import org.jlib.container.iterator.iterator.Iterator;

import org.jlib.container.operation.Container;
import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link Object}. A
 * {@link CollectionContainer} is backed by a {@link Collection} specified at
 * initialization.
 *
 * @param <Item>
 *        type of items held in the {@link Object}
 * @author Igor Akkerman
 */
public class CollectionContainer<Item>
implements Container<Item> {

    private static final long serialVersionUID = 4025909176358714675L;

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
    public int getCount() {
        return delegateCollection.size();
    }

    @Override
    public boolean isEmpty()
    throws InvalidContainerStateException {
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO: create utility method
        return new IterableIterator<>(delegateCollection);
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateCollection.iterator();
    }

    @Override
    public boolean contains(final Item item) {
        return delegateCollection.contains(item);
    }

    public boolean contains(final Container<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return false;
    }

    // implemented for efficiency
    public boolean contains(final Collection<? extends Item> items) {
        return delegateCollection.containsAll(collection);
    }

    @SafeVarargs
    public final boolean contains(final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateCollection.containsAll(toSet());
    }

    @Override
    public Set<Item> toSet() {
        // TODO: transform to default strategy used by an Iterable & ToSet

        final Set<Item> set = new HashSet<>(getCount());

        // TODO: create and use utility method / strategy for copying an Iterable's Items to a given Collection
        for (final Item item : this)
            set.add(item);

        return set;
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidContainerStateException {
        final List<Item> list = new LinkedList<>();

        // TODO: create and use utility method / strategy for copying an Iterable's Items to a given Collection
        for (final Item item : this)
            list.add(item);

        return list;
    }

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
