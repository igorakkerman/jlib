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

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;

import java.util.Collection;

/**
 * {@link Object} to which Items can be appended.
 *
 * @param <Item>
 *        type of the appendable items
 *
 * @author Igor Akkerman
 */
public interface ItemAppendAware<Item> {

    /**
     * Appends the specified Item to this {@link ItemAppendAware}.
     *
     * @param item
     *        Item to append
     *
     * @throws IllegalJlibArgumentException
     *         if some property of {@code item} prevents it from being appended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void append(final Item item)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Appends all Items contained by the specified {@link Container} to this
     * {@link ItemAppendAware}.
     *
     * @param items
     *        {@link Container} containing the Items to append
     *
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being appended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void append(final Container<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Appends all Items contained by the specified {@link Collection} to this
     * {@link ItemAppendAware}.
     *
     * @param items
     *        {@link Collection} containing the Items to append
     *
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being appended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void append(final Collection<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Appends all specified Items to this {@link ItemAppendAware}.
     *
     * @param items
     *        comma separated sequence of Items to append
     *
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being appended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void append(final Item... items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;
}
