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

import org.jlib.core.language.AutoCloneable;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.InvalidTraversibleStateException;

import org.jlib.container.Container;

/**
 * {@link Sequence} delegating all operations to the specified delegate {@link Sequence}.
 * The delegate {@link Sequence} may be altered during the lifetime of the {@link ForwardingSequence}.
 *
 * @param <Item>
 *        type of the items held in the delegate {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ForwardingSequence<Item>
extends AutoCloneable
implements Sequence<Item> {

    /** delegate {@link Sequence} */
    private Sequence<Item> delegateSequence;

    /**
     * Creates a new {@link ForwardingSequence}.
     *
     * @param initialDelegateSequence
     *        initial delegate {@link DelegateSequence}
     */
    public <DelegateSequence extends Sequence<Item>> /*
        */ ForwardingSequence(final DelegateSequence initialDelegateSequence) {

        super();

        delegateSequence = initialDelegateSequence;
    }

    /**
     * Returns the {@link Sequence}.
     *
     * @return {@link Sequence}
     */
    protected Sequence<Item> getDelegateSequence() {
        return delegateSequence;
    }

    /**
     * Registers the {@link ForwardingSequence}.
     *
     * @param delegateSequence
     *        {@link Sequence}
     */
    protected void setDelegateSequence(final Sequence<Item> delegateSequence) {
        this.delegateSequence = delegateSequence;
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateSequence.iterator();
    }

    @Override
    public int getItemsCount()
    throws InvalidTraversibleStateException {
        return delegateSequence.getItemsCount();
    }

    @Override
    public boolean isEmpty()
    throws InvalidTraversibleStateException {
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
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        return delegateSequence.contains(item);
    }

    @Override
    public boolean contains(final Container<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        return delegateSequence.contains(items);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        return delegateSequence.contains(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        return delegateSequence.contains(items);
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidTraversibleStateException {
        return delegateSequence.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidTraversibleStateException {
        return delegateSequence.toArray();
    }

    @Override
    public List<Item> toList() {
        return delegateSequence.toList();
    }

    @Override
    public ForwardingSequenceTraverser<Item> createTraverser() {
        return new ForwardingSequenceTraverser<>(delegateSequence.createTraverser());
    }

    @Override
    @SuppressWarnings("unchecked")
    public ForwardingSequence<Item> clone() {
        return (ForwardingSequence<Item>) super.clone();
    }
}
