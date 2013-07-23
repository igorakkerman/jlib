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

import javax.annotation.Nullable;

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

/**
 * Readable container of {@link Item}s.
 *
 * @param <Item>
 *        type of items held in the {@link ReadContainer}
 *
 * @author Igor Akkerman
 */
public interface ReadContainer<Item>
extends Traversable<Item>,
        Iterable<Item> {

    /**
     * Returns the number of Items in this {@link ReadContainer}.
     *
     * @return integer specifying the number of Items in this {@link ReadContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public int getItemsCount()
    throws InvalidTraversableStateException;

    /**
     * Verifies whether this {@link ReadContainer} contains no Items.
     *
     * @return {@code true} if this {@link ReadContainer} contains no Items;
     *         {@code false} otherwise
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public boolean isEmpty()
    throws InvalidTraversableStateException;

    /**
     * Verifies whether this {@link ReadContainer} contains the specified Object.
     *
     * @param item
     *        Item to verify
     *
     * @return {@code true} if this {@link ReadContainer} contains {@code object};
     *         {@code false} otherwise
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public boolean contains(Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Verifies whether this {@link ReadContainer} contains all of the Items in the
     * specified ReadContainer.
     *
     * @param items
     *        ReadContainer containing the Items to verify
     *
     * @return {@code true} if this {@link ReadContainer} contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public boolean contains(ReadContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Verifies whether this {@link ReadContainer} contains all of the Items in the
     * specified Collection.
     *
     * @param items
     *        {@link Collection} containing the Items to verify
     *
     * @return {@code true} if this {@link ReadContainer} contains all of the Items
     *         contained by {@code collection}; {@code false} otherwise
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public boolean contains(Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Verifies whether this {@link ReadContainer} contains all of the specified
     * Items.
     *
     * @param items
     *        comma separated sequence of Items to verify
     *
     * @return {@code true} if this {@link ReadContainer} contains all of the
     *         {@code objects}; {@code false} otherwise
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public boolean contains(Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * <p>
     * Verifies whether this {@link ReadContainer} is equal to the specified {@link Object}. This is true if all of the
     * following conditions are satisfied:
     * </p>
     * <ul>
     * <li>this {@link ReadContainer} and the specified {@link Object} are instances
     * of the same class</li>
     * <li>this {@link ReadContainer} and the specified {@link Object} contain equal
     * Items, as verified by {@link #containsEqualItems(ReadContainer)}</li>
     * </ul>
     *
     * @param otherObject
     *        Object to compare to this ReadContainer
     *
     * @return {@code true} if all of the conditions stated above are satisfied;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(@Nullable Object otherObject);

    /**
     * Returns the hash code of this {@link ReadContainer} confirming to {@link #equals(Object)}.
     *
     * @return integer specifying the hash code
     */
    @Override
    public int hashCode();

    /**
     * Verifies whether the {@link Traverser} instances created by the {@link #createTraverser()} methods of this
     * {@link ReadContainer} and the specified {@link ReadContainer} traverse the same number of Items in the same order and
     * all traversed Items are equal. Two Items {@code item1} and {@code item2} are called equal if
     * {@code item1.equals(item2)}.
     *
     * @param otherContainer
     *        compared {@link ReadContainer}
     *
     * @return {@code true} if this {@link ReadContainer} and {@code otherContainer}contain equal Items;
     *         {@code false} otherwise
     */
    public boolean containsEqualItems(ReadContainer<Item> otherContainer);
}
