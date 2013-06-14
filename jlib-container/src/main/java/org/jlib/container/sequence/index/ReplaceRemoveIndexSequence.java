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

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceRemoveSequence;

/**
 * {@link ReplaceRemoveSequence}, {@link ReplaceIndexSequence} and
 * {@link RemoveIndexSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link ReplaceRemoveIndexSequence}
 *
 * @author Igor Akkerman
 */
public interface ReplaceRemoveIndexSequence<Item>
extends ReplaceRemoveSequence<Item>, ReplaceIndexSequence<Item>, RemoveIndexSequence<Item> {

    @Override
    public ReplaceRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * @return {@link ReplaceRemoveIndexSequenceTraverser} over the Items of
     *         this {@link ReplaceRemoveIndexSequence}
     */
    @Override
    public ReplaceRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * @return {@link ReplaceRemoveIndexSequenceTraverser} over the Items of
     *         this {@link ReplaceRemoveIndexSequence}
     */
    @Override
    public ReplaceRemoveIndexSequenceTraverser<Item> createTraverser(int startIndex);
}
