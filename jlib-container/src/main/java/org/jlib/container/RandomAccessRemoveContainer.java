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

import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.InvalidTraversibleStateException;

/**
 * {@link RemoveContainer} allowing its Items to be removed by random access to
 * each specified Item.
 *
 * @param <Item>
 *        type of items held in the {@link Container}
 *
 * @author Igor Akkerman
 */
public interface RandomAccessRemoveContainer<Item> {

    /**
     * Removes the specified Item from this {@link RandomAccessRemoveContainer}.
     *
     * @param item
     *        {@link Item} to remove
     *
     * @throws ItemToRemoveNotContainedException
     *         if this {@link RandomAccessRemoveContainer} does not contain
     *         {@code Item}
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void remove(Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all Items contained by the specified {@link Container} from this
     * {@link RandomAccessRemoveContainer}.
     *
     * @param items
     *        {@link Container} containing the Items to remove
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void remove(Container<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link RandomAccessRemoveContainer}.
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void remove(Collection<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link RandomAccessRemoveContainer}.
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    public void remove(Iterable<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Removes all specified Items from this {@link RandomAccessRemoveContainer}
     * .
     *
     * @param items
     *        comma separated sequence of Items to remove
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void remove(Item... items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException;
}
