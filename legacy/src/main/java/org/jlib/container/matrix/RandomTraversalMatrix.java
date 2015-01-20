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

package org.jlib.container.operation.matrix;

import java.util.Iterator;
import java.util.RandomAccess;

import org.jlib.core.iterator.Iterator;

import org.jlib.container.operation.sequence.Sequence;

/**
 * {@link Matrix} iterable in various orders. A {@link Sequence} of all
 * columns or rows can be retrieved and the {@link Matrix} can be traversed by a
 * custom {@link MatrixIterator}. The default {@link MatrixIterator} returned
 * by {@link #iterator()} and the default {@link Iterator} returned by
 * {@link #iterator()} can be customized using
 * {@link #setDefaultTraversalOrder(MatrixTraversalOrder)}. A
 * {@link RandomTraversalMatrix} is not necessarily a {@link RandomAccess}
 * {@link Matrix}.
 *
 * @param <Entry>
 *        type of the entries of the Matrix
 *
 * @see MatrixTraversalOrder
 *
 * @author Igor Akkerman
 */
public interface RandomTraversalMatrix<Entry>
extends Matrix<Entry> {

    /**
     * Returns the {@link Sequence} of the rows of this {@link Matrix}, each
     * provided as a {@link Sequence}.
     *
     * @return IndexSequence of the MatrixRows of this ArrayMatrix
     */
    public Sequence<? extends Sequence<Entry>> getColumns();

    /**
     * Returns the {@link Sequence} of the rows of this {@link Matrix}, each
     * provided as a {@link Sequence}.
     *
     * @return IndexSequence of the MatrixRows of this ArrayMatrix
     */
    public Sequence<? extends Sequence<Entry>> getRows();

    /**
     * <p>
     * Returns a {@link MatrixIterable} providing a {@link MatrixIterator}
     * traversing the Items of this {@link Matrix} using the specified
     * {@link MatrixTraversalOrder}.
     * </p>
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * for (Integer matrixEntry : matrix.iteratedInOrder(VERTICAL)
     *     System.out.print(matrixEntry + " ");
     * </pre>
     *
     * @param iterationOrder
     *        {@link MatrixTraversalOrder} used by the returned {@link Iterable}
     *
     * @return {@link MatrixIterable} providing a {@link MatrixIterator}
     *         traversing the Items of this {@link Matrix} using the specified
     *         {@link MatrixTraversalOrder}.
     */
    public MatrixIterable<Entry> traversedInOrder(MatrixTraversalOrder iterationOrder);

    /**
     * Registers the {@link MatrixTraversalOrder} used by each {@link Iterator}
     * returned by {@link #iterator()}.
     *
     * @param defaultIterationOrder
     *        {@link MatrixTraversalOrder} used by default {@link Iterator
     *        Iterators}
     */
    public void setDefaultTraversalOrder(MatrixTraversalOrder defaultIterationOrder);
}
