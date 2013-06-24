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

package org.jlib.core.traverser;

import java.util.Iterator;

/**
 * {@link Iterator} over the Items of a {@link Traversible} and a {@link RemoveTraversible}.
 *
 * @param <Item>
 *        type of Items of the {@link RemoveTraversible}
 *
 * @param <Travble>
 *        type of the traversed {@link RemoveTraversible}
 *
 * @author Igor Akkerman
 */
public class RemoveTraversibleIterator<Item, Travble extends RemoveTraversible<Item>>
extends TraversibleIterator<Item, Travble> {

    /** delegate {@link RemoveTraverser} */
    private RemoveTraverser delegateTraverser;

    /**
     * Creates a new {@link RemoveTraversibleIterator}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     */
    public RemoveTraversibleIterator(final Travble traversible) {
        super(traversible);
    }

    /**
     * Registers the specified {@link RemoveTraverser} as delegate for this {@link RemoveTraversibleIterator}.
     *
     * @param delegateTraverser
     *        delegate {@link Traverser}
     */
    protected final void setRemoveTraverser(final RemoveTraverser delegateTraverser) {
        this.delegateTraverser = delegateTraverser;
    }

    @Override
    protected void createTraverser(final Travble traversible) {
        final Traverser<Item> traverser = traversible.createTraverser();

        setTraverser(traverser);

        // safe cast since traversible.createTraverser returns a Traverser<Item> AND a RemoveTraverser
        setRemoveTraverser((RemoveTraverser) traverser);
    }

    @Override
    public void remove() {
        delegateTraverser.remove();
    }
}
