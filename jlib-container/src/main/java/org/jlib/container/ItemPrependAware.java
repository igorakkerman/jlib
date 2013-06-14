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
 * {@link Object} to which Items can be prepended.
 *
 * @param <Item>
 *        type of the prependable items
 *
 * @author Igor Akkerman
 */
public interface ItemPrependAware<Item> {

    /**
     * Prepends the specified Item to this {@link ItemPrependAware}.
     *
     * @param item
     *        Item to prepend
     *
     * @throws IllegalJlibArgumentException
     *         if some property of {@code item} prevents it from being prepended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void prepend(final Item item)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Prepends all Items contained by the specified {@link Container} to this
     * {@link ItemPrependAware}.
     *
     * @param items
     *        {@link Container} containing the Items to prepend
     *
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void prepend(final Container<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Prepends all Items contained by the specified {@link Collection} to this
     * {@link ItemPrependAware}.
     *
     * @param items
     *        {@link Collection} containing the Items to prepend
     *
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void prepend(final Collection<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Prepends all specified Items to this {@link ItemPrependAware}.
     *
     * @param items
     *        comma separated sequence of Items to prepend
     *
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended
     *
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void prepend(final Item... items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;
}
