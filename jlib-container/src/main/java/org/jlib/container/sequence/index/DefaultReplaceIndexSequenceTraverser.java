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

import static org.jlib.core.array.ArrayUtility.traversible;
import static org.jlib.core.language.ExceptionMessageUtility.message;

import static org.jlib.container.sequence.SequenceUtility.concatenated;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.InvalidSequenceTraverserStateException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.array.FillupArraySequence;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.InvalidTraversibleStateException;
import org.jlib.core.traverser.NoItemToReplaceException;
import org.jlib.core.traverser.ObservedReplaceTraverser;
import org.jlib.core.traverser.ReplaceTraverser;
import org.jlib.core.value.ValueNotAccessibleException;

/**
 * Default implementation of a {@link IndexSequenceTraverser}
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 *
 * @author Igor Akkerman
 */
public class DefaultReplaceIndexSequenceTraverser<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends DefaultIndexSequenceTraverser<Item, Sequenze>
implements ObservedReplaceTraverser<Item>,
           ReplaceTraverser<Item>,
           IndexSequenceTraverser<Item> {

    /** replace {@link ValueObserver} items */
    private final AppendSequence<ValueObserver<Item>> traverserReplaceObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ObservedReplaceIndexSequence} beginning at its
     * first index.
     *
     * @param sequence
     *        {@link ReplaceIndexSequence} to traverse
     */
    public DefaultReplaceIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ReplaceIndexSequence} beginning the traversal at
     * the specified index.
     *
     * @param sequence
     *        {@link ReplaceIndexSequence} to traverse
     *
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     *
     * @throws InvalidSequenceIndexException
     *         if {@code startIndex < sequence.getFirstIndex() ||
     *                   startIndex > sequence.getLastIndex()}
     *
     * @throws InvalidTraversibleArgumentException
     *         if some property of {@code newItem} prevents the operation from
     *         being performed
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs performing the operation
     */
    public DefaultReplaceIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws InvalidSequenceIndexException, InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public final void addReplaceObserver(final ValueObserver<Item> replaceObserver) {
        traverserReplaceObservers.append(replaceObserver);
    }

    @Override
    public final void replace(final Item newItem)
    throws NoItemToReplaceException, InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        try {
            getSequence().replace(getLastAccessedItemIndex(), newItem);
        }
        catch (final ValueNotAccessibleException exception) {
            throw new NoItemToReplaceException(getSequence(), exception);
        }
    }

    @Override
    @SafeVarargs
    public final void replace(final Item newItem, final ValueObserver<Item>... operationObservers)
    throws NoItemToReplaceException, InvalidTraversibleArgumentException, InvalidTraversibleStateException, RuntimeException {
        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    replace(newItem);
                }
                catch (InvalidTraversibleArgumentException | InvalidSequenceTraverserStateException exception) {
                    throw new OperatorException(message("replace: {0}", newItem), exception);
                }
            }
        }, /*
     */ newItem, concatenated(traverserReplaceObservers, traversible(operationObservers)).toArray());
    }
}
