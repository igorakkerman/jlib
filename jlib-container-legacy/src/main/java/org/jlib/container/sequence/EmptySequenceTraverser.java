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

package org.jlib.container.operation.sequence;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.NoItemToRemoveException;
import org.jlib.core.traverser.NoItemToReplaceException;
import org.jlib.core.traverser.ObservedRemoveTraverser;
import org.jlib.core.traverser.ObservedReplaceTraverser;
import org.jlib.core.traverser.RemoveTraverser;
import org.jlib.core.traverser.ReplaceTraverser;

import org.jlib.container.operation.sequence.index.IndexSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} of an {@link InitiallyEmptySequence}.
 *
 * @param <Item>
 *        type of items held in the {@link InitiallyEmptySequence}
 *
 * @author Igor Akkerman
 */
public final class EmptySequenceTraverser<Item>
extends AbstractSequenceTraverser<Item, InitiallyEmptySequence<Item>>
implements ObservedRemoveTraverser<Item>,
           ObservedReplaceTraverser<Item>,
           ReplaceTraverser<Item>,
           RemoveTraverser<Item> {

    /** sole {@link EmptySequenceTraverser} instance */
    private static final EmptySequenceTraverser<?> INSTANCE = new EmptySequenceTraverser<>();

    /**
     * Returns the sole instance of this class.
     *
     * @param <Item>
     *        type of the potential {@link InitiallyEmptySequence} items
     *
     * @return sole {@link EmptySequenceTraverser}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequenceTraverser<Item> getInstance() {
        return (EmptySequenceTraverser<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequenceTraverser}.
     */
    private EmptySequenceTraverser() {
        super(EmptySequence.<Item> /**/ getInstance());
    }

    @Override
    public boolean hasPreviousItem() {
        return false;
    }

    @Override
    public boolean hasNextItem() {
        return false;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        throw new NoNextSequenceItemException(getSequence());
    }

    @Override
    public void replace(final Item newItem)
    throws NoItemToReplaceException {
        throw new NoItemToReplaceException(getSequence());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void replace(final Item newItem, final ValueObserver<Item>... removeObservers)
    throws NoItemToReplaceException {
        throw new NoItemToReplaceException(getSequence());
    }

    @Override
    public void remove()
    throws NoItemToRemoveException {
        throw new NoItemToRemoveException(getSequence());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... observers)
    throws NoItemToRemoveException {
        throw new NoItemToRemoveException(getSequence());
    }

    @Override
    public void addReplaceObserver(final ValueObserver<Item> replaceObserver) {
        // intentionally empty: no Item to replace, hence no replace operation to observe
    }

    @Override
    public void addRemoveObserver(final ValueObserver<Item> removeObserver) {
        // intentionally empty: no Item to retain, hence no retain operation to observe
    }
}
