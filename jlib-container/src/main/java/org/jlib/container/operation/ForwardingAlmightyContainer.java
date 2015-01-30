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

package org.jlib.container.operation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jlib.container.operation.containsadapter.IterativeContainsAdapter;

import org.jlib.corefunctions.ApplicationObject;
import org.jlib.operator.observer.ValueObserver;
import org.jlib.operator.observer.ValueObserverException;

/**
 * Skeletal implementation of a container. A concrete IterableContainer
 * implementation needs only to extend this class and implement the
 * {@link Iterable#iterator()} method. Other methods may be overridden for
 * efficiency reasons.
 *
 * @param <Item>
 *        type of items held in the {@link Object}
 *
 * @author Igor Akkerman
 */
public class ForwardingAlmightyContainer<Item>
extends ApplicationObject
implements AlmightyContainer<Item> {

    private final AlmightyContainer<Item> disabledAlmightyContainer = new AlmightyContainer<Item>() {

        @Override
        public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
            */ boolean contains(final ContainsIterable items)
        throws InvalidContainerArgumentException, InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public int count()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public boolean isEmpty()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Iterator<Item> iterator() {
            throw new ForbiddenCastException(this);
        }

        @SuppressWarnings("DuplicateThrows")
        @SafeVarargs
        @Override
        public final <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(final ContainsIterable items, final ValueObserver<Item>... observers)
        throws ItemToRemoveNotContainedException, InvalidContainerArgumentException, InvalidContainerStateException,
               ValueObserverException {
            throw new ForbiddenCastException(this);
        }

        @SafeVarargs
        @Override
        public final void removeAll(final ValueObserver<Item>... observers)
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(final ContainsIterable items)
        throws InvalidContainerArgumentException, InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void removeAll()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Item[] toArray()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public List<Item> toRandomAccessList()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public List<Item> toSequentialList()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Set<Item> toSet()
        throws InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public boolean contains(final Item item)
        throws InvalidContainerArgumentException, InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void remove(final Item item)
        throws InvalidContainerArgumentException, InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void retain(final IterativeContainsAdapter<Item> items)
        throws InvalidContainerArgumentException, InvalidContainerStateException {
            throw new ForbiddenCastException(this);
        }

        @SafeVarargs
        @Override
        public final void retain(final Iterable<Item> items, final ValueObserver<Item>... observers)
        throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
            throw new ForbiddenCastException(this);
        }
    };

    private ToArray<Item> delegateToArray = disabledAlmightyContainer;

    private ToSequentialList<Item> delegateToSequentialList = disabledAlmightyContainer;

    private ObservedRetain<Item> delegateObservedRetain = disabledAlmightyContainer;

    private ToSet<Item> delegateToSet = disabledAlmightyContainer;

    private IsEmpty<Item> delegateIsEmpty = disabledAlmightyContainer;

    private Retain<Item> delegateRetain = disabledAlmightyContainer;

    private ObservedRemoveAll<Item> delegateObservedRemoveAll = disabledAlmightyContainer;

    private RemoveAll<Item> delegateRemoveAll = disabledAlmightyContainer;

    private ToRandomAccessList<Item> delegateToRandomAccessList = disabledAlmightyContainer;

    private Count<Item> delegateCount = disabledAlmightyContainer;

    private RemoveSingleByValue<Item> delegateRemoveSingleByValue = disabledAlmightyContainer;

    private RemoveMultipleByValue<Item> delegateRemoveMultipleByValue = disabledAlmightyContainer;

    private ObservedRemoveMultiple<Item> delegateObservedRemoveMultiple = disabledAlmightyContainer;

    private ContainsSingle<Item> delegateContainsSingle = disabledAlmightyContainer;

    private ContainsMultiple<Item> delegateContainsMultiple = disabledAlmightyContainer;

    private Iterable<Item> delegateIterable = disabledAlmightyContainer;

    @Override
    public void removeAll()
    throws InvalidContainerStateException {
        delegateRemoveAll.removeAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidContainerStateException {
        delegateObservedRemoveAll.removeAll(observers);
    }

    @Override
    public boolean isEmpty()
    throws InvalidContainerStateException {
        return delegateIsEmpty.isEmpty();
    }

    @Override
    public Set<Item> toSet()
    throws InvalidContainerStateException {
        return delegateToSet.toSet();
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidContainerStateException {
        return delegateToSequentialList.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidContainerStateException {
        return delegateToArray.toArray();
    }

    @Override
    public int count()
    throws InvalidContainerStateException {
        return delegateCount.count();
    }

    @Override
    public List<Item> toRandomAccessList()
    throws InvalidContainerStateException {
        return delegateToRandomAccessList.toRandomAccessList();
    }

    @Override
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ boolean contains(final ContainsIterable items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateContainsMultiple.contains(items);
    }

    @Override
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(final ContainsIterable items, final ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidContainerArgumentException, InvalidContainerStateException,
           ValueObserverException {
        delegateObservedRemoveMultiple.remove(items, observers);
    }

    @Override
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(final ContainsIterable items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        delegateRemoveMultipleByValue.remove(items);
    }

    @Override
    public void remove(final Item item)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        delegateRemoveSingleByValue.remove(item);
    }

    @Override
    public boolean contains(final Item item)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateContainsSingle.contains(item);
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateIterable.iterator();
    }

    public void setDelegateToArray(final ToArray<Item> delegateToArray) {
        this.delegateToArray = delegateToArray;
    }

    public void setDelegateToSequentialList(final ToSequentialList<Item> delegateToSequentialList) {
        this.delegateToSequentialList = delegateToSequentialList;
    }

    public void setDelegateObservedRetain(final ObservedRetain<Item> delegateObservedRetain) {
        this.delegateObservedRetain = delegateObservedRetain;
    }

    public void setDelegateToSet(final ToSet<Item> delegateToSet) {
        this.delegateToSet = delegateToSet;
    }

    public void setDelegateIsEmpty(final IsEmpty<Item> delegateIsEmpty) {
        this.delegateIsEmpty = delegateIsEmpty;
    }

    public void setDelegateRetain(final Retain<Item> delegateRetain) {
        this.delegateRetain = delegateRetain;
    }

    public void setDelegateObservedRemoveAll(final ObservedRemoveAll<Item> delegateObservedRemoveAll) {
        this.delegateObservedRemoveAll = delegateObservedRemoveAll;
    }

    public void setDelegateRemoveAll(final RemoveAll<Item> delegateRemoveAll) {
        this.delegateRemoveAll = delegateRemoveAll;
    }

    public void setDelegateToRandomAccessList(final ToRandomAccessList<Item> delegateToRandomAccessList) {
        this.delegateToRandomAccessList = delegateToRandomAccessList;
    }

    public void setDelegateCount(final Count<Item> delegateCount) {
        this.delegateCount = delegateCount;
    }

    public void setDelegateRemoveMultipleByValue(final RemoveMultipleByValue<Item> delegateRemoveMultipleByValue) {
        this.delegateRemoveMultipleByValue = delegateRemoveMultipleByValue;
    }

    public void setDelegateObservedRemoveMultiple(final ObservedRemoveMultiple<Item> delegateObservedRemoveMultiple) {
        this.delegateObservedRemoveMultiple = delegateObservedRemoveMultiple;
    }

    public void setDelegateContainsMultiple(final ContainsMultiple<Item> delegateContainsMultiple) {
        this.delegateContainsMultiple = delegateContainsMultiple;
    }

    public void setDelegateIterable(final Iterable<Item> delegateIterable) {
        this.delegateIterable = delegateIterable;
    }

    public void setDelegateRemoveSingleByValue(final RemoveSingleByValue<Item> delegateRemoveSingleByValue) {
        this.delegateRemoveSingleByValue = delegateRemoveSingleByValue;
    }

    public void setDelegateContainsSingle(final ContainsSingle<Item> delegateContainsSingle) {
        this.delegateContainsSingle = delegateContainsSingle;
    }

    @Override
    public void retain(final IterativeContainsAdapter<Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        delegateRetain.retain(items);
    }

    @SafeVarargs
    @Override
    public final void retain(final Iterable<Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        delegateObservedRetain.retain(items, observers);
    }

}
