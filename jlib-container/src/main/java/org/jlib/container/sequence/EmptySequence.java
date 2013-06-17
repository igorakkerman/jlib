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

import org.jlib.container.Container;
import org.jlib.container.EmptyContainer;
import org.jlib.container.InvalidContainerArgumentException;
import org.jlib.container.InvalidContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.ObservedRandomAccessRemove;
import org.jlib.container.ObservedRemoveAll;
import org.jlib.container.sequence.index.ReplaceIndexSequence;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.exception.observer.ValueObserverException;

import java.util.Collection;

/**
 * Empty {@link Sequence}.
 *
 * @param <Item>
 *        type of the items
 *
 * @author Igor Akkerman
 */
public class EmptySequence<Item>
extends EmptyContainer<Item>
implements ObservedReplaceSequence<Item>, ObservedRemoveSequence<Item>, ObservedRandomAccessRemove<Item>,
           ObservedRemoveAll<Item> {

    /** sole instance of this class */
    private static final EmptySequence<?> INSTANCE = new EmptySequence<>();

    /**
     * Returns the sole instance of this class.
     *
     * @param <Item>
     *        type of potential items potentially held in this
     *        {@link EmptySequence}
     *
     * @return sole {@link ReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequence<Item> getInstance() {
        return (EmptySequence<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequence}.
     */
    protected EmptySequence() {
        super();
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException {
        throw new NoSuchItemToRemoveException(this, item);
    }

    @Override
    public void removeAll()
    throws NoSuchItemToRemoveException {
        // intentionally blank
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws NoSuchItemToRemoveException {
        // intentionally blank
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws NoSuchItemToRemoveException, InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws NoSuchItemToRemoveException, InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws NoSuchItemToRemoveException, InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws NoSuchItemToRemoveException, InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws NoSuchItemToRemoveException, InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws NoSuchItemToRemoveException, InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws InvalidSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidSequenceArgumentException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidContainerStateException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        // intentionally blank
    }

    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser() {
        return EmptySequenceTraverser.getInstance();
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}
