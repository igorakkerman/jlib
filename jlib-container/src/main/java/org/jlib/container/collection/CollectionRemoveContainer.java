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

import java.util.Collection;

import org.jlib.container.ObservedRetainItemsByTraversable;
import org.jlib.container.RetainItemsByTraversable;

/**
 * Adapter allowing the {@link Collection} specified at initialization to be
 * used as a {@link RetainItemsByTraversable}. A {@link CollectionRemoveContainer} is not
 * an {@link ObservedRetainItemsByTraversable} as internal {@link Collection} operations
 * may be used for modification and these cannot be observed.
 *
 * @param <Item>
 *        type of the items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public class CollectionRemoveContainer<Item>
/*extends CollectionOperation<Item>
implements RemoveItemByItem<Item>,
           RemoveAllItems<Item> */{
//
//    /**
//     * Creates a new {@link CollectionRemoveContainer} backed by the specified
//     * {@link Collection}.
//     *
//     * @param delegateCollection
//     *        {@link Collection} backing this {@link CollectionRemoveContainer}
//     */
//    public CollectionRemoveContainer(final Collection<Item> delegateCollection) {
//        super(delegateCollection);
//    }
//
//    /**
//     * Adds the specified Item to this {@link CollectionRemoveContainer} using
//     * the {@link Collection#add(Object)} operation of the delegate
//     * {@link Collection}.
//     *
//     * @param item
//     *        added Item
//     *
//     * @throws InvalidContainerDelegateArgumentException
//     *         if {@code item} caused an error during the operation of the
//     *         delegate {@link Collection}
//     *
//     * @throws InvalidContainerDelegateStateException
//     *         if an error occured during the operation of the delegate
//     *         {@link Collection}
//     */
//    public void add(final Item item)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        try {
//            getDelegateCollection().add(item);
//        }
//        catch (final InvalidArgumentException exception) {
//            throw new InvalidContainerDelegateArgumentException(this, getDelegateCollection(), message(item),
//                                                                exception);
//        }
//        catch (final UnsupportedOperationException exception) {
//            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(), message(item), exception);
//        }
//    }
//
//    /**
//     * Adds the specified Items to this {@link CollectionRemoveContainer} using
//     * the {@link Collection#addAll(Collection)} operation of the delegate
//     * {@link Collection}.
//     *
//     * @param items
//     *        {@link Collection} of added Items
//     *
//     * @throws InvalidContainerDelegateArgumentException
//     *         if an Item in {@code items} caused an error during the operation
//     *         of the delegate {@link Collection}
//     *
//     * @throws InvalidContainerDelegateStateException
//     *         if an error occured during the operation of the delegate
//     *         {@link Collection}
//     */
//    public void add(final Collection<? extends Item> items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        try {
//            getDelegateCollection().addAll(items);
//        }
//        catch (final UnsupportedOperationException exception) {
//            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(),
//                                                             message("addAll: {0}", items), exception);
//        }
//    }
//
//    /**
//     * Adds the specified Items to this {@link CollectionRemoveContainer} using
//     * the {@link Collection#addAll(Collection)} operation of the delegate
//     * {@link Collection}.
//     *
//     * @param items
//     *        {@link TraversableContainer} of added Items
//     *
//     * @throws InvalidContainerDelegateArgumentException
//     *         if an Item in {@code items} caused an error during the operation
//     *         of the delegate {@link Collection}
//     *
//     * @throws InvalidContainerDelegateStateException
//     *         if an error occured during the operation of the delegate
//     *         {@link Collection}
//     */
//    public void add(final TraversableContainer<? extends Item> items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        for (final Item item : items)
//            getDelegateCollection().add(item);
//    }
//
//    /**
//     * Adds the specified Items to this {@link CollectionRemoveContainer} using
//     * the {@link Collection#addAll(Collection)} operation of the delegate
//     * {@link Collection}.
//     *
//     * @param items
//     *        comma separated sequence of added Items
//     *
//     * @throws InvalidContainerDelegateArgumentException
//     *         if an Item in {@code items} caused an error during the operation
//     *         of the delegate {@link Collection}
//     *
//     * @throws InvalidContainerDelegateStateException
//     *         if an error occured during the operation of the delegate
//     *         {@link Collection}
//     */
//    @SuppressWarnings("unchecked")
//    public void add(final Item... items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        try {
//            Collections.addAll(getDelegateCollection(), items);
//        }
//        catch (final InvalidArgumentException | InvalidStateException exception) {
//            throw new InvalidContainerDelegateArgumentException(this, getDelegateCollection(),
//                                                                message("addAll: {0}", Arrays.toString(items)),
//                                                                exception);
//        }
//        catch (final UnsupportedOperationException exception) {
//            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(),
//                                                             message("addAll: {0}", items), exception);
//        }
//    }
//
//    @Override
//    public void removeItem(final Item item)
//    throws ItemToRemoveNotContainedException, InvalidContainerDelegateStateException {
//        try {
//            final boolean removed = getDelegateCollection().removeItem(item);
//
//            if (! removed)
//                throw new ItemToRemoveNotContainedException(this, item);
//        }
//        catch (final UnsupportedOperationException exception) {
//            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(),
//                                                             message("removeItem: {0}", item), exception);
//        }
//    }
//
//    @Override
//    public void removeAllItems()
//    throws InvalidContainerDelegateStateException {
//        try {
//            getDelegateCollection().clear();
//        }
//        catch (final UnsupportedOperationException exception) {
//            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(), message("removeAllItems"),
//                                                             exception);
//        }
//    }
//
//    @Override
//    public void removeItem(final Collection<? extends Item> items)
//    throws InvalidContainerDelegateStateException {
//        try {
//            getDelegateCollection().removeAllItems(items);
//        }
//        catch (final UnsupportedOperationException exception) {
//            throw new InvalidContainerDelegateStateException(this, getDelegateCollection(),
//                                                             message("removeItem: {0}", items),
//                                                             exception);
//        }
//    }
//
//    @Override
//    public void removeItem(final TraversableContainer<? extends Item> items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        CollectionUtility.removeAllItems(getDelegateCollection(), items);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void removeItem(final Item... items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        ContainerUtility.removeItem(this, items);
//    }
//
//    @Override
//    public void removeItem(final Iterable<? extends Item> items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        ContainerUtility.removeItem(this, items);
//    }
//
//    @Override
//    public void retainItems(final Collection<? extends Item> items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        getDelegateCollection().retainAll(items);
//    }
//
//    @Override
//    public void retainItems(final Traversable<? extends Item> items)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        ContainerUtility.retainItems(this, iterable(items));
//    }
//
//    @Override
//    public void retainItems(final TraversableContainer<? extends Item> items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        ContainerUtility.retainItems(this, items);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void retainItems(final Item... items)
//    throws InvalidContainerDelegateArgumentException, InvalidContainerDelegateStateException {
//        ContainerUtility.retainItems(this, items);
//    }
//
//    @Override
//    public RemoveTraverser<Item> createTraverser()
//    throws InvalidContainerDelegateStateException {
//        return new RemoveIterableTraverser<>(getDelegateCollection());
//    }
}
