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

package org.jlib.container.legacy;

import org.jlib.core.traverser.NoNextItemException;
import org.jlib.core.traverser.NoPreviousItemException;
import org.jlib.core.traverser.Traverser;
import org.jlib.core.traverser.TwoWayTraverser;

import org.jlib.container.sequence.InitiallyEmptySequence;

/**
 * Singleton {@link Traverser} of an {@link Empty}.
 *
 * @param <Item>
 *        type of items potentially provided by the
 *        {@link EmptyContainerTraverser}
 *
 * @author Igor Akkerman
 */
public final class EmptyContainerTraverser<Item>
implements TwoWayTraverser<Item> {

    /** sole {@link EmptyContainerTraverser} instance */
    private static final EmptyContainerTraverser<?> INSTANCE = new EmptyContainerTraverser<>();

    /**
     * Returns the sole instance of this class.
     *
     * @param <Item>
     *        type of the potential {@link InitiallyEmptySequence} items
     *
     * @return sole {@link EmptyContainerTraverser}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptyContainerTraverser<Item> getInstance() {
        return (EmptyContainerTraverser<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyContainerTraverser}.
     */
    private EmptyContainerTraverser() {
        super();
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
    throws NoPreviousItemException {
        throw new NoPreviousItemException(Empty.getInstance());
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        throw new NoNextItemException(Empty.getInstance());
    }
}
