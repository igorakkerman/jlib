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

package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jlib.core.system.AbstractCloneable;

import org.jlib.container.Container;
import org.jlib.container.InvalidContainerArgumentException;
import org.jlib.container.InvalidContainerStateException;

/**
 * {@link Sequence} delegating all operations to the specified delegate {@link Sequence}.
 * The delegate {@link Sequence} may be altered during the lifetime of the {@link DelegatingSequence}.
 *
 * @param <Item>
 *        type of the items held in the delegate {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class DelegatingSequence<Item, DelegateSequence extends Sequence<Item>>
extends AbstractCloneable
implements Sequence<Item> {

    /** delegate {@link DelegateSequence} */
    private DelegateSequence delegateSequence;

    /**
     * Creates a new {@link DelegatingSequence}.
     *
     * @param initialDelegateSequence
     *        initial delegate {@link DelegateSequence}
     */
    public DelegatingSequence(final DelegateSequence initialDelegateSequence) {
        super();

        delegateSequence = initialDelegateSequence;
    }

    /**
     * Returns the {@link DelegateSequence}.
     *
     * @return {@link DelegateSequence}
     */
    protected DelegateSequence getDelegateSequence() {
        return delegateSequence;
    }

    /**
     * Registers the {@link DelegatingSequence}.
     *
     * @param delegateSequence
     *        {@link DelegateSequence}
     */
    protected void setDelegateSequence(final DelegateSequence delegateSequence) {
        this.delegateSequence = delegateSequence;
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateSequence.iterator();
    }

    @Override
    public int getItemsCount()
    throws InvalidContainerStateException {
        return delegateSequence.getItemsCount();
    }

    @Override
    public boolean isEmpty()
    throws InvalidContainerStateException {
        return delegateSequence.isEmpty();
    }

    @Override
    public boolean containsEqualItems(final Container<Item> otherContainer) {
        return delegateSequence.containsEqualItems(otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Collection<Item> collection) {
        return delegateSequence.containsEqualItems(collection);
    }

    @Override
    public boolean contains(final Item item)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateSequence.contains(item);
    }

    @Override
    public boolean contains(final Container<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateSequence.contains(items);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateSequence.contains(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        return delegateSequence.contains(items);
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidContainerStateException {
        return delegateSequence.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidContainerStateException {
        return delegateSequence.toArray();
    }

    @Override
    public List<Item> toList() {
        return delegateSequence.toList();
    }

    @Override
    public DelegatingSequenceTraverser<Item> createTraverser() {
        return new DelegatingSequenceTraverser<>(delegateSequence);
    }

    @Override
    @SuppressWarnings("unchecked")
    public DelegatingSequence<Item, DelegateSequence> clone() {
        return (DelegatingSequence<Item, DelegateSequence>) super.clone();
    }
}
