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

package org.jlib.container.collection;

import org.jlib.container.AbstractContainer;
import org.jlib.container.Container;
import org.jlib.core.traverser.IterableTraverser;
import org.jlib.core.traverser.Traverser;

import java.util.Collection;
import java.util.Iterator;

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
    public boolean contains(final Item item) {
        return delegateCollection.contains(item);
    }

    // implemented for efficiency
    @Override
    public boolean contains(final Collection<? extends Item> collection) {
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
