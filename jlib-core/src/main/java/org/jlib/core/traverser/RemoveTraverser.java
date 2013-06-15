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

/**
 * {@link Traverser} allowing returned Items to be removed.
 *
 * @param <Item>
 *        type of traversed items
 *
 * @author Igor Akkerman
 */
public interface RemoveTraverser<Item>
extends Traverser<Item> {

    /**
     * Removes the last Item returned by this {@link RemoveTraverser}.
     *
     * @throws NoItemToRemoveException
     *         if not called immediately after a call to {@link #getNextItem()}
     *         or an appropriate method
     *
     * @throws InvalidTraversibleStateException
     *         if an error was caused by a delegate used to remove the item
     */
    public void remove()
    throws NoItemToRemoveException, InvalidTraversibleStateException;
}
