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

import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link ReplaceTraverser} and {@link SequenceTraverser}.
 *
 * @param <Item>
 *        type of items held in the {@link ReplaceSequence}
 *
 * @author Igor Akkerman
 */
public interface ReplaceSequenceTraverser<Item>
extends ReplaceTraverser<Item>, SequenceTraverser<Item> {

    /**
     * Replaces the last Item returned by {@code previous()} or {@code next()}
     * with the specified value.
     *
     * @param newItem
     *        Item by which the former Item is replaced
     *
     * @throws NoSequenceItemToReplaceException
     *         if no Item has been returned by this
     *         {@link ReplaceSequenceTraverser}
     *
     * @throws InvalidSequenceArgumentException
     *         if some property of {@code newItem} prevents it from replacing
     *         the former Item
     */
    @Override
    public void replace(final Item newItem)
    throws NoSequenceItemToReplaceException, InvalidSequenceArgumentException;
}
