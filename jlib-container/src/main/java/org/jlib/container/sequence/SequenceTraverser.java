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

import org.jlib.core.traverser.TwoWayTraverser;

/**
 * {@link TwoWayTraverser} over the Items of a {@link Sequence}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface SequenceTraverser<Item>
extends TwoWayTraverser<Item> {

    /**
     * Returns the previous Item of this {@link SequenceTraverser}.
     *
     * @return the previous Item
     *
     * @throws NoPreviousSequenceItemException
     *         if there is no previous Item
     */
    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException;

    /**
     * Returns the next Item of this {@link SequenceTraverser}.
     *
     * @return the next Item
     *
     * @throws NoNextSequenceItemException
     *         if there is no next Item
     */
    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException;
}
