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

package org.jlib.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;

public interface JdkAwareContainer<Item>
extends Traversable<Item>,
        Iterable<Item> {

    /**
     * Returns the number of Items in this {@link JdkAwareContainer}.
     *
     * @return integer specifying the number of Items in this {@link JdkAwareContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public int getItemsCount()
    throws InvalidTraversableStateException;

    /**
     * Returns a {@link RandomAccess} {@link List} containing all of the Items
     * of this {@link ReadContainer} in the proper order as returned by this
     * {@link ReadContainer}'s Traverser.
     *
     * @return {@link RandomAccess} {@link List} containing all of the Items of
     *         this {@link ReadContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public List<Item> toList()
    throws InvalidTraversableStateException;

    /**
     * Returns a sequentially traversable {@link List} containing all of the
     * Items of this {@link ReadContainer} in the proper order as returned by this
     * {@link ReadContainer}'s Traverser.
     *
     * @return sequentially traversable {@link List} containing all of the Items
     *         of this {@link ReadContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public List<Item> toSequentialList()
    throws InvalidTraversableStateException;

    /**
     * Returns an array containing all of the Items of this {@link ReadContainer} in
     * the proper order as returned by this {@link ReadContainer}'s Traverser.
     *
     * @return array containing all of the Items of this {@link ReadContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public Item[] toArray()
    throws InvalidTraversableStateException;

    /**
     * Verifies whether the {@link Iterator} instances created by the
     * {@link Iterable#iterator()} methods of this {@link ReadContainer} and the
     * specified {@link Collection} traverse the same number of Items in the
     * same order and all traversed Items are equal. Two Items {@code item1} and
     * {@code item2} are called equal if {@code item1.equals(item2)}.
     *
     *
     * @param collection
     *        compared {@link Collection}
     *
     * @return {@code true} if this {@link ReadContainer} and {@code otherContainer} contain equal Items;
     *         {@code false} otherwise
     */
    public boolean containsEqualItems(Iterable<Item> collection);
}
