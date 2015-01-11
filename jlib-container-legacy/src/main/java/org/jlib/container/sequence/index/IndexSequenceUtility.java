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

import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;

import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;

import static org.jlib.core.language.ParametrizedMessageUtility.message;

/**
 * {@link IndexSequence} utility.
 *
 * @author Igor Akkerman
 */
public final class IndexSequenceUtility {

    /** no visible constructor */
    private IndexSequenceUtility() {
    }

    /**
     * Ensures that the specified index is inside the valid bounds of the
     * specified {@link IndexSequence}.
     *
     * @param sequence
     *        verified {@link IndexSequence}
     *
     * @param index
     *        integer specifying the index to verify
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code index < sequence.getFirstIndex() || index > sequence.getLastIndex()}
     */
    public static void ensureIndexValid(final IndexSequence<?> sequence, final int index)
    throws InvalidSequenceIndexException {

        if (index < sequence.getFirstIndex())
            throw new InvalidSequenceIndexException(sequence, message("index = {0} < {1} = firstIndex", index,
                                                                      sequence.getFirstIndex()));

        if (index > sequence.getLastIndex()) {
            throw new InvalidSequenceIndexException(sequence, message("index = {0} > {1} = lastIndex", index,
                                                                      sequence.getLastIndex()));
        }
    }

    /**
     * Ensures that the specified <em>from</em> and <em>to</em> indices are
     * valid, that is,
     * {@code sequence.getFirstIndex() <= fromIndex <= toIndex <= sequence.getLastIndex()}
     * .
     *
     * @param sequence
     *        verified {@link IndexSequence}
     *
     * @param fromIndex
     *        integer specifying the from index
     *
     * @param toIndex
     *        integer specifying the to index
     *
     * @throws InvalidSequenceIndexException
     *         if {@code fromIndex < getFirstIndex() || toIndex > getLastIndex() || toIndex < fromIndex}
     */
    public static void ensureSubIndexRangeValid(final IndexSequence<?> sequence, final int fromIndex, final int toIndex)
    throws InvalidSequenceIndexException {

        if (fromIndex < sequence.getFirstIndex())
            throw new InvalidSequenceIndexException(sequence, message("fromIndex = {0} < {1} = firstIndex", fromIndex,
                                                                      sequence.getFirstIndex()));

        if (toIndex > sequence.getLastIndex())
            throw new InvalidSequenceIndexException(sequence, message("toIndex = {0} > {1} = lastIndex", toIndex,
                                                                      sequence.getLastIndex()));

        if (toIndex < fromIndex) {
            throw new InvalidSequenceIndexException(sequence,
                                                    message("toIndex = {0} < {1} = fromIndex", toIndex, fromIndex));
        }
    }

    /**
     * Removes the specified Item from the specified {@link RemoveIndexSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param sequence
     *        {@link ObservedRetainItemsByIterable} containing the Item
     *
     * @param itemIndex
     *        index of the Item to retain
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code itemIndex}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public static <Item> void remove(final RemoveIndexSequence<Item> sequence, final int itemIndex,
                                     final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {

        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    sequence.remove(itemIndex);
                }
                catch (InvalidContainerArgumentException | InvalidContainerStateException exception) {
                    throw new OperatorException(message("retain: {0}", itemIndex).with("sequence", sequence),
                                                exception);
                }
            }
        },

                                sequence.get(itemIndex), observers);
    }
}