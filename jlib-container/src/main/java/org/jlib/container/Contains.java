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

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;

public interface Contains<Item>
extends ItemOperation<Item> {

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
    public boolean contains(Traversable<? extends Item> items)
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
    public boolean contains(Iterable<? extends Item> items)
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
}
