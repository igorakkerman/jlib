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
 * Provider of Items in a specified order.
 *
 * @param <Item>
 *        type of items provided by the {@link Traverser}
 *
 * @author Igor Akkerman
 */
public interface Traverser<Item> {

    /**
     * Returns whether this {@link Traverser} has a next Item.
     *
     * @return {@code true} if there is a next Item; {@code false} otherwise
     */
    public boolean hasNextItem();

    /**
     * Returns the next Item traversed by this {@link Traverser}.
     *
     * @return next Item
     *
     * @throws NoNextItemException
     *         if this {@link Traverser} has no next Item
     */
    public Item getNextItem()
    throws NoNextItemException;
}
