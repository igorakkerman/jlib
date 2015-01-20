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

package org.jlib.container.operation.legacy;

import org.jlib.core.iterator.NoNextItemException;
import org.jlib.core.iterator.NoPreviousItemException;
import org.jlib.core.iterator.Iterator;
import org.jlib.core.iterator.TwoWayIterator;

import org.jlib.container.operation.sequence.InitiallyEmptySequence;

/**
 * Singleton {@link Iterator} of an {@link Empty}.
 *
 * @param <Item>
 *        type of items potentially provided by the
 *        {@link EmptyContainerIterator}
 *
 * @author Igor Akkerman
 */
public final class EmptyContainerIterator<Item>
implements TwoWayIterator<Item> {

    /** sole {@link EmptyContainerIterator} instance */
    private static final EmptyContainerIterator<?> INSTANCE = new EmptyContainerIterator<>();

    /**
     * Returns the sole instance of this class.
     *
     * @param <Item>
     *        type of the potential {@link InitiallyEmptySequence} items
     *
     * @return sole {@link EmptyContainerIterator}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptyContainerIterator<Item> getInstance() {
        return (EmptyContainerIterator<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyContainerIterator}.
     */
    private EmptyContainerIterator() {
        super();
    }

    @Override
    public boolean hasPreviousItem() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        throw new NoPreviousItemException(Empty.getInstance());
    }

    @Override
    public Item next()
    throws NoNextItemException {
        throw new NoNextItemException(Empty.getInstance());
    }
}
