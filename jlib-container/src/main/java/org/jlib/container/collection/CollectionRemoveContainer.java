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

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.ObservedRemove;
import org.jlib.container.Remove;
import org.jlib.container.RemoveAll;
import org.jlib.core.language.InvalidArgumentException;
import org.jlib.container.traverser.RemoveIterableTraverser;
import org.jlib.container.traverser.RemoveTraverser;

import java.util.Collection;
import java.util.Collections;

/**
 * Adapter allowing the {@link Collection} specified at initialization to be
 * used as a {@link Remove}. A {@link CollectionRemoveContainer} is not
 * an {@link ObservedRemove} as internal {@link Collection} operations
 * may be used for modification and these cannot be observed.
 *
 * @param <Item>
 *        type of the items held in the {@link Container}
 *
 * @author Igor Akkerman
 */
public class CollectionRemoveContainer<Item>
extends CollectionContainer<Item>
implements RemoveAll<Item> {

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
     * @throws InvalidContainerDelegateArgumentException
     *         if {@code item} caused an error during the operation of the
     *         delegate {@link Collection}
     *
     * @throws InvalidContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(final Item item)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        try {
            getDelegateCollection().add(item);
        }
        catch (final InvalidArgumentException exception) {
            throw new InvalidContainerDelegateArgumentException(this, getDelegateCollection(), item,
                                                                "{1}: {2} - add({3})", exception);
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - add({3})",
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
     * @throws InvalidContainerDelegateArgumentException
     *         if an Item in {@code items} caused an error during the operation
     *         of the delegate {@link Collection}
     *
     * @throws InvalidContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(final Collection<? extends Item> items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        try {
            getDelegateCollection().addAll(items);
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(),
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
     * @throws InvalidContainerDelegateArgumentException
     *         if an Item in {@code items} caused an error during the operation
     *         of the delegate {@link Collection}
     *
     * @throws InvalidContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    public void add(final Container<? extends Item> items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
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
     * @throws InvalidContainerDelegateArgumentException
     *         if an Item in {@code items} caused an error during the operation
     *         of the delegate {@link Collection}
     *
     * @throws InvalidContainerDelegateStateException
     *         if an error occured during the operation of the delegate
     *         {@link Collection}
     */
    @SuppressWarnings("unchecked")
    public void add(final Item... items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        try {
            Collections.addAll(getDelegateCollection(), items);
        }
        catch (final InvalidArgumentException | InvalidStateException exception) {
            throw new InvalidContainerDelegateArgumentException(this, getDelegateCollection(), items,
                                                                "{1}: Collections.addAll({2}, {3})", exception);
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(),
                                                             "{1}: Collections.addAll({2}, {3})", exception, items);
        }
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, InvalidContainerDelegateStateException {
        try {
            final boolean removed = getDelegateCollection().remove(item);

            if (! removed)
                throw new NoSuchItemToRemoveException(this, item);
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - remove({3})",
                                                             exception, item);
        }
    }

    @Override
    public void removeAll()
    throws InvalidContainerDelegateStateException {
        try {
            getDelegateCollection().clear();
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - clear()",
                                                             exception);
        }
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws InvalidContainerDelegateStateException {
        try {
            getDelegateCollection().removeAll(items);
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(), "{1}: {2} - removeAll({3})",
                                                             exception, items);
        }
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        CollectionUtility.removeAll(getDelegateCollection(), items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        getDelegateCollection().retainAll(items);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    public RemoveTraverser<Item> createTraverser()
    throws InvalidContainerDelegateStateException {
        return new RemoveIterableTraverser<>(getDelegateCollection());
    }
}
