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

import org.jlib.container.sequence.index.IndexSequenceTraverser;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.NoItemToRemoveException;

/**
 * {@link IndexSequenceTraverser} of an {@link EmptySequence}.
 *
 * @param <Item>
 *        type of items held in the {@link EmptySequence}
 *
 * @author Igor Akkerman
 */
public class EmptySequenceTraverser<Item>
extends AbstractSequenceTraverser<Item, EmptySequence<Item>>
implements ObservedReplaceRemoveSequenceTraverser<Item> {

    /** sole {@link EmptySequenceTraverser} instance */
    private static final EmptySequenceTraverser<?> INSTANCE = new EmptySequenceTraverser<>();

    /**
     * Returns the sole instance of this class.
     *
     * @param <Item>
     *        type of the potential {@link EmptySequence} items
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
    protected EmptySequenceTraverser() {
        super(EmptySequence.<Item>getInstance());
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return false;
    }

    @Override
    public boolean isNextItemAccessible() {
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
    throws NoSequenceItemToReplaceException {
        throw new NoSequenceItemToReplaceException(getSequence());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void replace(final Item newItem, final ValueObserver<Item>... removeObservers)
    throws NoSequenceItemToReplaceException {
        throw new NoSequenceItemToReplaceException(getSequence());
    }

    @Override
    public void remove()
    throws NoItemToRemoveException {
        throw new NoSequenceItemToRemoveException(getSequence());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... observers)
    throws NoSequenceItemToRemoveException {
        throw new NoSequenceItemToRemoveException(getSequence());
    }

    @Override
    public void addReplaceObserver(final ValueObserver<Item> replaceObserver) {
        // intentionally empty: no Item to replace, hence no replace operation to observe
    }

    @Override
    public void addRemoveObserver(final ValueObserver<Item> removeObserver) {
        // intentionally empty: no Item to remove, hence no remove operation to observe
    }
}
