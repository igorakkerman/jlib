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

import org.jlib.core.traverser.Traverser;
import org.jlib.core.traverser.Traversible;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * Container of items.
 *
 * @param <Item>
 *        type of items held in the {@link Container}
 *
 * @author Igor Akkerman
 */
public interface Container<Item>
extends Traversible<Item>, Iterable<Item>, Cloneable {

    /**
     * Returns the number of Items in this {@link Container}.
     *
     * @return integer specifying the number of Items in this {@link Container}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public int getItemsCount()
    throws InvalidContainerStateException;

    /**
     * Verifies whether this {@link Container} contains no Items.
     *
     * @return {@code true} if this {@link Container} contains no Items;
     *         {@code false} otherwise
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public boolean isEmpty()
    throws InvalidContainerStateException;

    /**
     * Verifies whether this {@link Container} contains the specified Object.
     *
     * @param item
     *        Item to verify
     *
     * @return {@code true} if this {@link Container} contains {@code object};
     *         {@code false} otherwise
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public boolean contains(final Item item)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Verifies whether this {@link Container} contains all of the Items in the
     * specified Container.
     *
     * @param items
     *        Container containing the Items to verify
     *
     * @return {@code true} if this {@link Container} contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public boolean contains(final Container<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Verifies whether this {@link Container} contains all of the Items in the
     * specified Collection.
     *
     * @param items
     *        {@link Collection} containing the Items to verify
     *
     * @return {@code true} if this {@link Container} contains all of the Items
     *         contained by {@code collection}; {@code false} otherwise
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public boolean contains(final Collection<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Verifies whether this {@link Container} contains all of the specified
     * Items.
     *
     * @param items
     *        comma separated sequence of Items to verify
     *
     * @return {@code true} if this {@link Container} contains all of the
     *         {@code objects}; {@code false} otherwise
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Returns a {@link RandomAccess} {@link List} containing all of the Items
     * of this {@link Container} in the proper order as returned by this
     * {@link Container}'s Traverser.
     *
     * @return {@link RandomAccess} {@link List} containing all of the Items of
     *         this {@link Container}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public List<Item> toList()
    throws InvalidContainerStateException;

    /**
     * Returns a sequentially traversible {@link List} containing all of the
     * Items of this {@link Container} in the proper order as returned by this
     * {@link Container}'s Traverser.
     *
     * @return sequentially traversible {@link List} containing all of the Items
     *         of this {@link Container}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public List<Item> toSequentialList()
    throws InvalidContainerStateException;

    /**
     * Returns an array containing all of the Items of this {@link Container} in
     * the proper order as returned by this {@link Container}'s Traverser.
     *
     * @return array containing all of the Items of this {@link Container}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public Item[] toArray()
    throws InvalidContainerStateException;

    /**
     * Verifies whether this {@link Container} is equal to the specified
     * {@link Object}. This is true if all of the following conditions are
     * satisfied:
     *
     * <ul>
     * <li>this {@link Container} and the specified {@link Object} are instances
     * of the same class</li>
     * <li>this {@link Container} and the specified {@link Object} contain equal
     * Items, as verified by {@link #containsEqualItems(Container)}</li>
     * </ul>
     *
     * @param otherObject
     *        Object to compare to this Container
     *
     * @return {@code true} if all of the conditions stated above are satisfied;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(/* @Nullable */Object otherObject);

    /**
     * Verifies whether the {@link Traverser} instances created by the
     * {@link #createTraverser()} methods of this {@link Container} and the
     * specified {@link Container} traverse the same number of Items in the same
     * order and all traversed Items are equal. Two Items {@code item1} and
     * {@code item2} are called equal if {@code item1.equals(item2)}.
     *
     * @param otherContainer
     *        compared {@link Container}
     *
     * @return {@code true} if this {@link Container} and {@code otherContainer}
     *         contain equal Items; {@code false} otherwise
     */
    public boolean containsEqualItems(final Container<Item> otherContainer);

    /**
     * Verifies whether the {@link Iterator} instances created by the
     * {@link Iterable#iterator()} methods of this {@link Container} and the
     * specified {@link Collection} traverse the same number of Items in the
     * same order and all traversed Items are equal. Two Items {@code item1} and
     * {@code item2} are called equal if {@code item1.equals(item2)}.
     *
     * @param collection
     *        compared {@link Collection}
     *
     * @return {@code true} if this {@link Container} and {@code otherContainer}
     *         contain equal Items; {@code false} otherwise
     */
    public boolean containsEqualItems(final Collection<Item> collection);

    /**
     * Creates a copy of this {@link Container}.
     *
     * @return cloned {@link Container}
     */
    public Container<Item> clone();
}
