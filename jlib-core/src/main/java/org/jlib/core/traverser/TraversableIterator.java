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

import org.jlib.core.iterator.AbstractIterator;

import java.util.Iterator;

/**
 * {@link Iterator} over the Items of a {@link Traversable}.
 *
 * @param <Item>
 *        type of items of the {@link Traversable}
 *
 * @param <Travble>
 *        type of the traversed {@link Traversable}
 *
 * @author Igor Akkerman
 */
public class TraversableIterator<Item, Travble extends Traversable<Item>>
extends AbstractIterator<Item> {

    /** delegate {@link Traverser} */
    private Traverser<Item> delegateTraverser;

    /**
     * Creates a new {@link TraversableIterator}.
     *
     * @param traversable
     *        traversed {@link Traversable}
     */
    public TraversableIterator(final Travble traversable) {
        super();

        createTraverser(traversable);
    }

    /**
     * <p>
     * Registers a newly created delegate {@link Traverser} for the specified
     * {@link Traversable}.
     * </p>
     * <p>
     * This method must be overridden by subclasses using parametric
     * polymorphism to register the concrete {@link Traverser} in a property of
     * the concrete type.
     * </p>
     *
     * @param traversable
     *        traversed {@link Traversable}
     */
    protected void createTraverser(final Travble traversable) {
        setTraverser(traversable.createTraverser());
    }

    /**
     * <p>
     * Registers the specified {@link Traverser} as delegate for this
     * {@link TraversableIterator}.
     * </p>
     * <p>
     * Subclasses must re-implement (not override!) this method registering the
     * concrete {@link Traverser} in a property of the concrete type AND calling
     * THIS method using {@code super.setTraverser(delegateTraverser)}.
     * </p>
     *
     * @param delegateTraverser
     *        delegate {@link Traverser}
     */
    protected final void setTraverser(final Traverser<Item> delegateTraverser) {
        this.delegateTraverser = delegateTraverser;
    }

    @Override
    public boolean hasNext() {
        return delegateTraverser.hasNextItem();
    }

    @Override
    public Item next() {
        return delegateTraverser.getNextItem();
    }
}
