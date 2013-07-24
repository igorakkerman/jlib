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

package org.jlib.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

/**
 * Skeletal implementation of a {@link TraversableContainer}. A concrete TraversableContainer
 * implementation needs only to extend this class and implement the
 * {@link TraversableContainer#iterator()} method. Other methods may be overridden for
 * efficiency reasons.
 *
 * @param <Item>
 *        type of items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public class GodContainer<Item>
extends AbstractObject
implements ToList<Item>,
           Contains<Item>,
           Remove<Item>,
           RemoveByItem<Item>,
           RemoveAll<Item>,
           ObservedRemove<Item>,
           ObservedRemoveByItem<Item>,
           ObservedRemoveAll<Item>,ItemOperation<Item>,Traversable<Item>,
           Iterable<Item> {

    private ToList<Item> delegateToListContainer = /*
     */ DisabledToList.getInstance();

    private ItemsCount<Item> delegateItemsCount = /*
     */ DisabledItemsCountContainer.getInstance();

    private Contains<Item> delegateContainsContainer = /*
     */ DisabledContains.getInstance();

    private Remove<Item> delegateRemove = /*
     */ DisabledRemove.getInstance();

    private RemoveByItem<Item> delegateRemoveByItemContainer = /*
     */ DisabledRemoveByItem.getInstance();

    private RemoveAll<Item> delegateRemoveAll = /*
     */ DisabledRemoveAll.getInstance();

    private ObservedRemove<Item> delegateObservedRemoveContainer = /*
     */ DisabledObservedRemove.getInstance();

    private ObservedRemoveByItem<Item> delegateObservedRemoveByItemContainer = /*
     */ DisabledObservedRemoveByItem.getInstance();

    private ObservedRemoveAll<Item> delegateObservedRemoveAllContainer = /*
     */ DisabledObservedRemoveAll.getInstance();

    public GodContainer() {
        super();
    }

    public ToList<Item> getDelegateToListContainer() {
        return delegateToListContainer;
    }

    public void setDelegateToListContainer(final ToList<Item> delegateToListContainer) {
        this.delegateToListContainer = delegateToListContainer;
    }

    public TraversableContainer<Item> getDelegateTraversableContainer() {
        return delegateTraversableContainer;
    }

    public void setDelegateTraversableContainer(final TraversableContainer<Item> delegateTraversableContainer) {
        this.delegateTraversableContainer = delegateTraversableContainer;
    }

    public Contains<Item> getDelegateContainsContainer() {
        return delegateContainsContainer;
    }

    public void setDelegateContainsContainer(final Contains<Item> delegateContainsContainer) {
        this.delegateContainsContainer = delegateContainsContainer;
    }

    public Remove<Item> getDelegateRemove() {
        return delegateRemove;
    }

    public void setDelegateRemove(final Remove<Item> delegateRemove) {
        this.delegateRemove = delegateRemove;
    }

    public RemoveByItem<Item> getDelegateRemoveByItemContainer() {
        return delegateRemoveByItemContainer;
    }

    public void setDelegateRemoveByItemContainer(final RemoveByItem<Item> delegateRemoveByItemContainer) {
        this.delegateRemoveByItemContainer = delegateRemoveByItemContainer;
    }

    public RemoveAll<Item> getDelegateRemoveAll() {
        return delegateRemoveAll;
    }

    public void setDelegateRemoveAll(final RemoveAll<Item> delegateRemoveAll) {
        this.delegateRemoveAll = delegateRemoveAll;
    }

    public ObservedRemove<Item> getDelegateObservedRemoveContainer() {
        return delegateObservedRemoveContainer;
    }

    public void setDelegateObservedRemoveContainer(
                                                  final ObservedRemove<Item> delegateObservedRemoveContainer) {
        this.delegateObservedRemoveContainer = delegateObservedRemoveContainer;
    }

    public ObservedRemoveByItem<Item> getDelegateObservedRemoveByItemContainer() {
        return delegateObservedRemoveByItemContainer;
    }

    public void setDelegateObservedRemoveByItemContainer(
                                                        final ObservedRemoveByItem<Item> delegateObservedRemoveByItemContainer) {
        this.delegateObservedRemoveByItemContainer = delegateObservedRemoveByItemContainer;
    }

    public ObservedRemoveAll<Item> getDelegateObservedRemoveAllContainer() {
        return delegateObservedRemoveAllContainer;
    }

    public void setDelegateObservedRemoveAllContainer(
                                                     final ObservedRemoveAll<Item> delegateObservedRemoveAllContainer) {
        this.delegateObservedRemoveAllContainer = delegateObservedRemoveAllContainer;
    }

    @Override
    public int getItemsCount()
    throws InvalidTraversableStateException {
        return delegateTraversableContainer.getItemsCount();
    }

    @Override
    public boolean isEmpty()
    throws InvalidTraversableStateException {
        return delegateTraversableContainer.isEmpty();
    }

    @Override
    public boolean hasMatchingProperties(final TraversableContainer<Item> otherContainer) {
        return delegateTraversableContainer.hasMatchingProperties(otherContainer);
    }

    @Override
    public boolean contains(final Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(item);
    }

    @Override
    public boolean contains(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(items);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(items);
    }

    @Override
    public List<Item> toList()
    throws InvalidTraversableStateException {
        return delegateToListContainer.toList();
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidTraversableStateException {
        return delegateToListContainer.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidTraversableStateException {
        return delegateToListContainer.toArray();
    }

    @Override
    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
        return delegateTraversableContainer.containsEqualItems(otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Iterable<Item> collection) {
        return delegateToListContainer.containsEqualItems(collection);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidTraversableStateException {
        delegateObservedRemoveAllContainer.removeAll(observers);
    }

    @Override
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(item, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(observers, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveContainer.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveContainer.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveContainer.retain(observers, items);
    }

    @Override
    public void removeAll()
    throws InvalidTraversableStateException {
        delegateRemoveAll.removeAll();
    }

    @Override
    public void remove(final Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.remove(item);
    }

    @Override
    public void remove(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.remove(items);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.remove(items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.remove(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.remove(items);
    }

    @Override
    public void retain(final Traversable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemove.retain(items);
    }

    @Override
    public void retain(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemove.retain(items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemove.retain(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemove.retain(items);
    }

    @Override
    public Traverser<Item> createTraverser() {
        return delegateTraversableContainer.createTraverser();
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateTraversableContainer.iterator();
    }
}
