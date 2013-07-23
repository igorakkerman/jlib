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

package org.jlib.container.sequence.index.array;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.core.storage.LinearIndexStorage;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

import org.jlib.container.ReadContainer;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.IndexSequenceTraverser;
import org.jlib.container.sequence.index.InvalidSequenceIndexException;
import org.jlib.container.sequence.index.NoSuchSequenceItemException;

/**
 * {@link IndexSequence} baked by an array.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ArraySequence<Item>
implements IndexSequence<Item> {
    private LinearIndexStorage<Item> delegate;

    @Override
    public Item get(final int index)
    throws InvalidSequenceIndexException {
        return null;
    }

    @Override
    public int getFirstIndex() {
        return 0;
    }

    @Override
    public int getLastIndex() {
        return 0;
    }

    @Override
    public Item getFirstItem() {
        return null;
    }

    @Override
    public Item getLastItem() {
        return null;
    }

    @Override
    public int getItemIndex(final Item item)
    throws NoSuchSequenceItemException {
        return 0;
    }

    @Override
    public int getLastItemIndex(final Item item)
    throws NoSuchSequenceItemException {
        return 0;
    }

    @Override
    public IndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws InvalidSequenceIndexException {
        return null;
    }

    @Override
    public IndexSequenceTraverser<Item> createTraverser() {
        return null;
    }

    @Override
    public IndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws InvalidSequenceIndexException {
        return null;
    }

    @Override
    public int getItemsCount()
    throws InvalidTraversableStateException {
        return 0;
    }

    @Override
    public boolean isEmpty()
    throws InvalidTraversableStateException {
        return false;
    }

    @Override
    public boolean contains(final Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    @Override
    public boolean contains(final ReadContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    @Override
    public boolean contains(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    @Override
    public boolean containsEqualItems(final ReadContainer<Item> otherContainer) {
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
