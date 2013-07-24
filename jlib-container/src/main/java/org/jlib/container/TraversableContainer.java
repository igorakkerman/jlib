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

import javax.annotation.Nullable;

import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

/**
 * Readable container of {@link Item}s.
 *
 * @param <Item>
 *        type of items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public interface TraversableContainer<Item>
extends Container<Item>,
        Traversable<Item>,
        Iterable<Item> {

    /**
     * Returns the number of Items in this {@link TraversableContainer}.
     *
     * @return integer specifying the number of Items in this {@link TraversableContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public int getItemsCount()
    throws InvalidTraversableStateException;

    /**
     * Verifies whether this {@link TraversableContainer} contains no Items.
     *
     * @return {@code true} if this {@link TraversableContainer} contains no Items;
     *         {@code false} otherwise
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public boolean isEmpty()
    throws InvalidTraversableStateException;

    /**
     * <p>
     * Verifies whether additional properties of this {@link TraversableContainer} match those of the specified
     * {@link TraversableContainer} providing a prerequisite for equality.
     * </p>
     * <p>
     * The implementation in {@link AbstractTraversableContainer} verifies the number of contained {@link Item}s, as provided
     * by {@link #getItemsCount()}.
     * </p>
     *
     * @param otherContainer
     *        {@link TraversableContainer} compared to this {@link TraversableContainer}
     *
     * @return {@code true} if the additional properties are prerequisites for equality; {@code false} otherwise
     */
    public boolean hasMatchingProperties(TraversableContainer<Item> otherContainer);

    /**
     * Verifies whether the {@link Traverser} instances created by the {@link #createTraverser()} methods of this
     * {@link TraversableContainer} and the specified {@link TraversableContainer} traverse the same number of Items in the same order and
     * all traversed Items are equal. Two Items {@code item1} and {@code item2} are called equal if
     * {@code item1.equals(item2)}.
     *
     * @param otherContainer
     *        compared {@link TraversableContainer}
     *
     * @return {@code true} if this {@link TraversableContainer} and {@code otherContainer}contain equal Items;
     *         {@code false} otherwise
     */
    public boolean containsEqualItems(TraversableContainer<Item> otherContainer);

    /**
     * <p>
     * Verifies whether this {@link TraversableContainer} is equal to the specified {@link Object}. This is true if all of the
     * following conditions are satisfied:
     * </p>
     * <ul>
     * <li>this {@link TraversableContainer} and the specified {@link Object} are instances of the same class</li>
     * <li>this {@link TraversableContainer} and the specified {@link Container} contain equal {@link Item}s, as verified by
     * {@link #containsEqualItems(TraversableContainer)}</li>
     * <li>this {@link TraversableContainer} and the specified {@link Container} contain equal metadata, as verified by
     * {@link #containsEqualItems(TraversableContainer)}</li>
     * </ul>
     *
     * @param otherObject
     *        Object to compare to this TraversableContainer
     *
     * @return {@code true} if all of the conditions stated above are satisfied;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(@Nullable Object otherObject);

    /**
     * Returns the hash code of this {@link TraversableContainer} confirming to {@link #equals(Object)}.
     *
     * @return integer specifying the hash code
     */
    @Override
    public int hashCode();
}
