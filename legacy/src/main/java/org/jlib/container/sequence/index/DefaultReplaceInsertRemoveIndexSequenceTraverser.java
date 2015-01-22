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
import org.jlib.core.observer.ValueObserverException;
import org.jlib.container.iterator.iterator.NoItemToRemoveException;

import org.jlib.container.operation.sequence.ObservedInsertSequenceIterator;
import org.jlib.container.operation.sequence.Sequence;

/**
 * Default implementation of a {@link RemoveIndexSequenceIterator},
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceInsertIndexSequence} and
 *        {@link RemoveIndexSequence}
 *
 * @author Igor Akkerman
 */
public class DefaultReplaceInsertRemoveIndexSequenceIterator<Item, Sequenze extends ObservedReplaceIndexSequence<Item>>
extends DefaultReplaceInsertIndexSequenceIterator<Item, Sequenze>
implements ObservedInsertSequenceIterator<Item> {

    /** retain {@link ValueObserver} items */
//    private final AppendSequence<ValueObserver<Item>> iteratorRemoveObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceInsertRemoveIndexSequenceIterator}
     * over the Items of the specified
     * {@link ReplaceAppendInsertRemoveIndexSequence} beginning at its first
     * index.
     *
     * @param sequence
     *        {@link ReplaceAppendInsertRemoveIndexSequence} to traverse
     */
    public DefaultReplaceInsertRemoveIndexSequenceIterator(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceInsertRemoveIndexSequenceIterator}
     * over the Items of the specified
     * {@link ReplaceAppendInsertRemoveIndexSequence} beginning the traversal at
     * the specified index.
     *
     * @param sequence
     *        {@link ReplaceAppendInsertRemoveIndexSequence} to traverse
     *
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceInsertRemoveIndexSequenceIterator(final Sequenze sequence, final int initialNextItemIndex)
    throws InvalidSequenceIndexException {
        super(sequence, initialNextItemIndex);
    }

    //    @Override
    public void remove()
    throws NoItemToRemoveException {
//        try {
//            getSequence().retain(getLastAccessedItemIndex());
//
//            unsetLastAccessedItem();
//        }
//        catch (final ValueNotAccessibleException exception) {
//            throw new NoItemToRemoveException(getSequence(), exception);
//        }
    }

    //    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... operationObservers)
    throws NoItemToRemoveException, ValueObserverException, RuntimeException {
//        ObserverUtility.operate(new HandledOperator() {
//
//            @Override
//            public void operate()
//            throws OperatorException, RuntimeException {
//                try {
//                    retain();
//                }
//                catch (InvalidContainerArgumentException | InvalidSequenceIteratorStateException exception) {
//                    throw new OperatorException(message("retain()"), exception);
//                }
//            }
//        }, concatenated(iteratorRemoveObservers, iterable(operationObservers)).toArray());

    }

    //    @Override
    public final void addRemoveObserver(final ValueObserver<Item> removeObserver) {
//        iteratorRemoveObservers.append(removeObserver);
    }
}
