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

import org.jlib.container.sequence.Sequence;

/**
 * Creator of instances of a specific subtype of {@link Sequence}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @param <Sequenze>
 *        type of the created {@link IndexSequence} instances
 *
 * @author Igor Akkerman
 */
public interface IndexSequenceCreator<Item, Sequenze extends AbstractInitializeableIndexSequence<Item>> {

    /**
     * Creates a new {@link IndexSequence} with the specified first and last
     * indices.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param lastIndex
     *        integer specifying the last index
     *
     * @return newly created {@link IndexSequence}
     *
     * @throws InvalidSequenceIndexException
     *         if {@code lastIndex < firstIndex}
     */
    public Sequenze createSequence(int firstIndex, int lastIndex)
    throws InvalidSequenceIndexException;
}
