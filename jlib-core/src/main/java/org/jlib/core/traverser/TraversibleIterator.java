/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

package org.jlib.core.traverser;

import java.util.Iterator;

import org.jlib.core.iterator.AbstractIterator;

/**
 * {@link Iterator} over the Items of a {@link Traversible}.
 * 
 * @param <Item>
 *        type of items of the {@link Traversible}
 * 
 * @param <Travble>
 *        type of the traversed {@link Traversible}
 * 
 * @author Igor Akkerman
 */
public class TraversibleIterator<Item, Travble extends Traversible<Item>>
extends AbstractIterator<Item> {

    /** delegate {@link Traverser} */
    private Traverser<Item> delegateTraverser;

    /**
     * Creates a new {@link TraversibleIterator}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    public TraversibleIterator(final Travble traversible) {
        super();

        createTraverser(traversible);
    }

    /**
     * <p>
     * Registers a newly createTraverser} for the specified
     * {@link Traversible} as delegate for this {@link TraversibleIterator}.
     * </p>
     * <p>
     * This method mmust be overridden by subclasses using parametric
     * polymorphism to register the concrete {@link Traverser} in a property of
     * the concrete type.
     * </p>
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    protected void createTraverser(final Travble traversible) {
        setTraverser(traversible.createTraverser());
    }

    /**
     * <p>
     * Registers the specified {@link Traverser} as delegate for this
     * {@link TraversibleIterator}.
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
        return delegateTraverser.isNextItemAccessible();
    }

    @Override
    public Item next() {
        return delegateTraverser.getNextItem();
    }
}
