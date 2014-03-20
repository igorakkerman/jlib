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

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.iterator.ObservedReplaceIterator;
import org.jlib.core.iterator.ReplaceIterator;

import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;
import org.jlib.container.operation.sequence.InsertSequenceIterator;
import org.jlib.container.operation.sequence.ObservedInsertSequenceIterator;
import org.jlib.container.operation.sequence.Sequence;

/**
 * Default implementation of a {@link ReplaceIndexSequenceIterator}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 *
 * @author Igor Akkerman
 */
public class DefaultReplaceInsertIndexSequenceIterator<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends DefaultReplaceIndexSequenceIterator<Item, Sequenze>
implements ObservedInsertSequenceIterator<Item>,
           IndexSequenceIterator<Item>,
           InsertSequenceIterator<Item>,
           ObservedReplaceIterator<Item>,
           ReplaceIterator<Item> {

    /** insert {@link ValueObserver} items */
//    private final AppendSequence<ValueObserver<Item>> iteratorInsertObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceInsertIndexSequenceIterator} over the
     * Items of the specified {@link ObservedReplaceIndexSequence} and
     * {@link InsertIndexSequence} beginning at its first index.
     *
     * @param sequence
     *        {@link ObservedReplaceIndexSequence} and
     *        {@link InsertIndexSequence} to traverse
     */
    public DefaultReplaceInsertIndexSequenceIterator(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceInsertIndexSequenceIterator} over the
     * Items of the specified {@link ObservedReplaceIndexSequence} and
     * {@link InsertIndexSequence} beginning at the specified index.
     *
     * @param sequence
     *        {@link ObservedReplaceIndexSequence} and
     *        {@link InsertIndexSequence} to traverse
     *
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceInsertIndexSequenceIterator(final Sequenze sequence, final int initialNextItemIndex)
    throws InvalidSequenceIndexException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void insert(final Item item) {
//        getSequence().insert(getPotentialNextItemIndex(), item);
    }

    @Override
    @SafeVarargs
    @SuppressWarnings("ProhibitedExceptionDeclared")
    public final void insert(final Item item, final ValueObserver<Item>... operationObservers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
//        ObserverUtility.operate(new HandledOperator() {
//
//            @Override
//            @SuppressWarnings("ProhibitedExceptionDeclared")
//            public void operate()
//            throws OperatorException, RuntimeException {
//                try {
//                    insert(item);
//                }
//                catch (InvalidContainerArgumentException | InvalidSequenceIteratorStateException exception) {
//                    throw new OperatorException(message("insert: {0}", item), exception);
//                }
//            }
//        }, item, concatenated(iteratorInsertObservers, iterable(operationObservers)).toArray());
    }

    @Override
    public final void addInsertObserver(final ValueObserver<Item> insertObserver) {
//        iteratorInsertObservers.append(insertObserver);

    }
}
