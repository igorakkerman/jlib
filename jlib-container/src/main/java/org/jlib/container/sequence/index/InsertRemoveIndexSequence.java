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

import org.jlib.container.sequence.InsertRemoveSequence;

/**
 * {@link InsertRemoveSequence}, {@link InsertIndexSequence} and
 * {@link RemoveIndexSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link InsertRemoveIndexSequence}
 *
 * @author Igor Akkerman
 */
public interface InsertRemoveIndexSequence<Item>
extends InsertRemoveSequence<Item>, InsertIndexSequence<Item>, RemoveIndexSequence<Item> {

    @Override
    public InsertRemoveIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * @return {@link InsertRemoveIndexSequenceTraverser} over the Items of this
     *         {@link InsertRemoveIndexSequence}
     */
    @Override
    public InsertRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * @return {@link InsertRemoveIndexSequenceTraverser} over the Items of this
     *         {@link InsertRemoveIndexSequence}
     */
    @Override
    public InsertRemoveIndexSequenceTraverser<Item> createTraverser(int startIndex);
}
