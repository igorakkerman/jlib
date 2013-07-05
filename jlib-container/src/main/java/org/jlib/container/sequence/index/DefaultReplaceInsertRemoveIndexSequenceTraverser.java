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

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.InvalidSequenceArgumentException;
import org.jlib.container.sequence.InvalidSequenceTraverserStateException;
import org.jlib.container.sequence.NoSequenceItemToRemoveException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.array.FillupArraySequence;
import org.jlib.core.language.ValueNotAccessibleException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;

import static org.jlib.container.sequence.SequenceUtility.concatenated;
import static org.jlib.core.array.ArrayUtility.traversible;

/**
 * Default implementation of a {@link RemoveIndexSequenceTraverser},
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
public class DefaultReplaceInsertRemoveIndexSequenceTraverser<Item, Sequenze extends ObservedReplaceInsertRemoveIndexSequence<Item>>
extends DefaultReplaceInsertIndexSequenceTraverser<Item, Sequenze>
implements org.jlib.container.sequence.ObservedInsertSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,
           org.jlib.core.traverser.ObservedRemoveTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>, org.jlib.container.sequence.InsertSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,
           org.jlib.container.sequence.ObservedInsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>, ObservedRemoveSequenceTraverser<Item>, org.jlib.container.sequence.ObservedInsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>, org.jlib.core.traverser.ObservedReplaceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>, org.jlib.core.traverser.ObservedRemoveTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,
           org.jlib.core.traverser.ObservedReplaceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>, org.jlib.core.traverser.ObservedReplaceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>, org.jlib.container.sequence.InsertSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.InsertSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.RemoveSequenceTraverser<Item>,IndexSequenceTraverser<Item>,
           org.jlib.container.sequence.ReplaceSequenceTraverser<Item> {

    /** remove {@link ValueObserver} items */
    private final AppendSequence<ValueObserver<Item>> traverserRemoveObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceInsertRemoveIndexSequenceTraverser}
     * over the Items of the specified
     * {@link ReplaceAppendInsertRemoveIndexSequence} beginning at its first
     * index.
     *
     * @param sequence
     *        {@link ReplaceAppendInsertRemoveIndexSequence} to traverse
     */
    public DefaultReplaceInsertRemoveIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceInsertRemoveIndexSequenceTraverser}
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
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceInsertRemoveIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void remove()
    throws NoSequenceItemToRemoveException {
        try {
            getSequence().remove(getLastAccessedItemIndex());

            unsetLastAccessedItem();
        }
        catch (final ValueNotAccessibleException exception) {
            throw new NoSequenceItemToRemoveException(getSequence(), exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... operationObservers)
    throws NoSequenceItemToRemoveException, ValueObserverException, RuntimeException {
        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    remove();
                }
                catch (InvalidSequenceArgumentException | InvalidSequenceTraverserStateException exception) {
                    throw new OperatorException("remove: {0}", exception);
                }
            }
        },

                                concatenated(traverserRemoveObservers, traversible(operationObservers)).toArray());
    }

    @Override
    public final void addRemoveObserver(final ValueObserver<Item> removeObserver) {
        traverserRemoveObservers.append(removeObserver);
    }
}
