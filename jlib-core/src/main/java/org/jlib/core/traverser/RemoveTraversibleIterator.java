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

/**
 * {@link Iterator} over the Items of a {@link RemoveTraversible}.
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
    private RemoveTraverser<Item> delegateTraverser;

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
     * <p>
     * Registers the specified {@link RemoveTraverser} as delegate for this
     * {@link RemoveTraversibleIterator}.
     * </p>
     * <p>
     * Subclasses must re-implement (not override!) this method registering the
     * concrete {@link RemoveTraverser} in a property of the concrete type AND
     * calling THIS method using {@code super.setTraverser(delegateTraverser)}.
     * </p>
     * 
     * @param delegateTraverser
     *        delegate {@link Traverser}
     */
    protected void setTraverser(final RemoveTraverser<Item> delegateTraverser) {
        super.setTraverser(delegateTraverser);

        this.delegateTraverser = delegateTraverser;
    }

    @Override
    protected void createTraverser(final Travble traversible) {
        setTraverser(traversible.createTraverser());
    }

    @Override
    public void remove() {
        delegateTraverser.remove();
    }
}
