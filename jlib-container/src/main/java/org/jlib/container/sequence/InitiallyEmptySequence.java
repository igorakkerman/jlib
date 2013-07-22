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

import org.jlib.container.Container;
import org.jlib.container.EmptyContainer;
import org.jlib.container.ItemToRemoveNotContainedException;
import org.jlib.container.ObservedRandomAccessRemoveContainer;
import org.jlib.container.ObservedRemoveAllContainer;
import org.jlib.container.ObservedReplaceContainer;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.InvalidTraversibleStateException;
import org.jlib.core.traverser.Traversible;

/**
 * {@link Sequence} that is empty when created.
 *
 * @param <Item>
 *        type of the items
 *
 * @author Igor Akkerman
 */
public abstract class InitiallyEmptySequence<Item>
extends EmptyContainer<Item>
implements Sequence<Item>,
           ObservedReplaceContainer<Item>,
           ObservedRandomAccessRemoveContainer<Item>,
           ObservedRemoveAllContainer<Item> {

    /**
     * Creates a new {@link InitiallyEmptySequence}.
     */
    protected InitiallyEmptySequence() {
        super();
    }

    @Override
    public void remove(final Item item)
    throws ItemToRemoveNotContainedException {
        throw new ItemToRemoveNotContainedException(this, item);
    }

    @Override
    public void removeAll()
    throws ItemToRemoveNotContainedException {
        // intentionally blank
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws ItemToRemoveNotContainedException {
        // intentionally blank
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws ItemToRemoveNotContainedException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws ItemToRemoveNotContainedException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws ItemToRemoveNotContainedException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws ItemToRemoveNotContainedException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Traversible<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws ItemToRemoveNotContainedException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws ItemToRemoveNotContainedException, InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversibleArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidTraversibleStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    public EmptySequenceTraverser<Item> createTraverser() {
        return EmptySequenceTraverser.getInstance();
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}
