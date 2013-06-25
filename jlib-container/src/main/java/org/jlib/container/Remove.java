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

import org.jlib.container.traverser.InvalidTraversibleArgumentException;
import org.jlib.container.traverser.InvalidTraversibleStateException;
import org.jlib.container.traverser.RemoveTraversible;
import org.jlib.container.traverser.Traversible;

import java.util.Collection;

/**
 * {@link Container} allowing Items to be removed.
 *
 * @param <Item>
 *        type of items held in the {@link Container}
 *
 * @author Igor Akkerman
 */
public interface Remove<Item>
extends RemoveTraversible<Item> {

    /**
     * Removes the specified Item of this {@link Remove}.
     *
     * @param item
     *        Item to remove
     *
     * @throws NoSuchItemToRemoveException
     *         if this {@link Remove} does not contain {@code Item}
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Removes all Items contained by the specified {@link Container} from this
     * {@link Remove}.
     *
     * @param items
     *        {@link Container} containing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Container<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link Remove}.
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Collection<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link Remove}.
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Iterable<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Removes all specified Items from this {@link Remove}.
     *I
     * @param items
     *        comma separated sequence of Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException;

    /**
     * Removes all Items from this {@link Remove}
     * <em>except</em> the Items contained by the specified {@link Traversible}.
     *
     * @param items
     *        {@link Traversible} containing the Items to retain
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void retain(final Traversible<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all Items from this {@link Remove}
     * <em>except</em> the Items contained by the specified {@link Container}.
     *
     * @param items
     *        {@link Container} containing the Items to retain
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void retain(final Container<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all Items from this {@link Remove}
     * <em>except</em> the Items contained by the specified {@link Collection}.
     *
     * @param items
     *        {@link Collection} containing the Items to retain
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void retain(final Collection<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all Items from this {@link Remove}
     * <em>except</em> the specified Items.
     *
     * @param items
     *        comma separated sequence of Items to retain
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;
}
