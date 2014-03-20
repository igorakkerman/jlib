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

package org.jlib.container.operation.sequence.index;

import org.jlib.container.operation.sequence.NoNextSequenceItemException;
import org.jlib.container.operation.sequence.NoPreviousSequenceItemException;
import org.jlib.container.operation.sequence.Sequence;
import org.jlib.container.operation.sequence.SequenceTraverser;

/**
 * {@link SequenceTraverser} over an {@link IndexSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface IndexSequenceTraverser<Item>
extends SequenceTraverser<Item> {

    /**
     * Returns the previous Item of this Traverser.
     *
     * @return the previous Item of this Traverser
     *
     * @throws NoPreviousSequenceItemException
     *         sif there is no previous Item
     */
    public int getPreviousItemIndex()
    throws NoPreviousSequenceItemException;

    /**
     * Returns the next Item of this Traverser.
     *
     * @return the next Item of this Traverser; returns
     *         {@code getLastIndex() + 1} if there is no next Item
     *
     * @throws NoNextSequenceItemException
     *         sif there is no next Item
     */
    public int getNextItemIndex()
    throws NoNextSequenceItemException;
}
