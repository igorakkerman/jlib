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

package org.jlib.container.sequence;

import org.jlib.container.Container;
import org.jlib.container.ItemPrependAware;

import java.util.Collection;

/**
 * {@link Sequence} to which Items can be prepended.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface PrependSequence<Item>
extends Sequence<Item>, ItemPrependAware<Item> {

    /**
     * @throws InvalidSequenceArgumentException
     *         if some property of {@code item} prevents it from being
     *         prepended, for instance, if it is already contained
     *
     * @throws InvalidSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    public void prepend(final Item item)
    throws InvalidSequenceArgumentException;

    /**
     * @throws InvalidSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     *
     * @throws InvalidSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    public void prepend(final Container<? extends Item> items)
    throws InvalidSequenceArgumentException;

    /**
     * @throws InvalidSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     *
     * @throws InvalidSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    public void prepend(final Collection<? extends Item> items)
    throws InvalidSequenceArgumentException;

    /**
     * @throws InvalidSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     *
     * @throws InvalidSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final Item... items)
    throws InvalidSequenceArgumentException;
}
