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

package org.jlib.container.matrix;

import org.jlib.container.sequence.index.AbstractIndexSequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexException;
import org.jlib.core.traverser.Traverser;

/**
 * Skeletal implementation of an {@link IndexMatrix}.
 *
 * @param <Entry>
 *        type of the entries of the {@link IndexMatrix}
 *
 * @author Igor Akkerman
 */
public abstract class AbstractIndexMatrix<Entry>
extends AbstractMatrix<Entry>
implements IndexMatrix<Entry> {

    /** first column index */
    private final int firstColumnIndex;

    /** last column index */
    private final int lastColumnIndex;

    /** first row index */
    private final int firstRowIndex;

    /** last row index */
    private final int lastRowIndex;

    /**
     * {@link MatrixTraversalOrder} used by each {@link Traverser} returned by
     * {@link #iterator()}.
     */
    private MatrixTraversalOrder defaultIterationOrder;

    /**
     * Creates a new {@link AbstractIndexMatrix}.
     *
     * @param firstColumnIndex
     *        integer specifying the index of the first column
     *
     * @param firstRowIndex
     *        integer specifying the index of the first row
     *
     * @param lastColumnIndex
     *        integer specifying the index of the last column
     *
     * @param lastRowIndex
     *        integer specifying the index of the last row
     */
    protected AbstractIndexMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                                  final int lastRowIndex) {
        super();

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.firstRowIndex = firstRowIndex;
        this.lastRowIndex = lastRowIndex;
    }

    /**
     * Returns the index of the first column of this {@link AbstractIndexMatrix}
     * .
     *
     * @return integer specifying the index of the first column
     */
    @Override
    public int getFirstColumnIndex() {
        return firstColumnIndex;
    }

    /**
     * Returns the index of the last column of this {@link AbstractIndexMatrix}.
     *
     * @return integer specifying the index of the last column
     */
    @Override
    public int getLastColumnIndex() {
        return lastColumnIndex;
    }

    /**
     * Returns the firstRowIndex of this {@link AbstractIndexMatrix}.
     *
     * @return int specifying the firstRowIndex
     */
    @Override
    public int getFirstRowIndex() {
        return firstRowIndex;
    }

    /**
     * Returns the lastRowIndex of this {@link AbstractIndexMatrix}.
     *
     * @return int specifying the lastRowIndex
     */
    @Override
    public int getLastRowIndex() {
        return lastRowIndex;
    }

    /**
     * Returns the Item stored at the specified column and row in this
     * AbstractIndexMatrix.
     *
     * @param columnIndex
     *        integer specifying the column index of the stored Item
     *
     * @param rowIndex
     *        integer specifying the row index of the stored Item
     *
     * @return Item stored at the specified position in this AbstractIndexMatrix
     *
     * @throws InvalidSequenceIndexException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    @Override
    public final Entry get(final int columnIndex, final int rowIndex)
    throws MatrixIndexOutOfBoundsException {
        ensureIndicesValid(columnIndex, rowIndex);

        return getStoredEntry(columnIndex, rowIndex);
    }

    /**
     * Returns the Item stored at the specified column and row in this
     * AbstractIndexMatrix, assuming that the specified column and row indices
     * are valid.
     *
     * @param columnIndex
     *        integer specifying the valid column index of the stored Item
     *
     * @param rowIndex
     *        integer specifying the valid row index of the stored Item
     *
     * @return Item stored at the specified position in this AbstractIndexMatrix
     */
    protected abstract Entry getStoredEntry(int columnIndex, int rowIndex);

    /**
     * Returns the Sequence of the MatrixColumns of this ArrayMatrix.
     *
     * @return {@link IndexSequence} of the {@link IndexMatrixColumn
     *         MatrixColumns} of this {@link ArrayMatrix}
     */
    @Override
    public IndexSequence<? extends IndexMatrixColumn<Entry>> getColumns() {
        return new AbstractIndexSequence<IndexMatrixColumn<Entry>>(firstColumnIndex, lastColumnIndex) {

            @Override
            public IndexMatrixColumn<Entry> getStoredItem(final int columnIndex) {
                return getColumn(columnIndex);
            }
        };
    }

    /**
     * Returns an {@link IndexSequence} of the {@link IndexMatrixRow
     * IndexMatrixRows} of this {@link ArrayMatrix}.
     *
     * @return {@link IndexSequence} of the {@link IndexMatrixRow
     *         IndexMatrixRows} of this {@link ArrayMatrix}
     */
    @Override
    public IndexSequence<? extends IndexMatrixRow<Entry>> getRows() {
        return new AbstractIndexSequence<IndexMatrixRow<Entry>>(firstRowIndex, lastRowIndex) {

            @Override
            public IndexMatrixRow<Entry> getStoredItem(final int rowIndex) {
                return getRow(rowIndex);
            }
        };
    }

    /**
     * Ensures that the specified column and row indices are within the index
     * bounds of this {@link IndexMatrix}.
     *
     * @param columnIndex
     *        integer specifying the column index
     *
     * @param rowIndex
     *        integer specifying the row index
     *
     * @throws MatrixIndexOutOfBoundsException
     *         if
     *         {@code columnIndex < getFirstColumnIndex() || columnIndex > getLastColumnIndex() || rowIndex < getFirstRowIndex() || rowIndex > getLastRowIndex()}
     */
    protected void ensureIndicesValid(final int columnIndex, final int rowIndex)
    throws MatrixIndexOutOfBoundsException {

        if (columnIndex < firstColumnIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "columnIndex == " + columnIndex +
                                                                                   " < " + firstColumnIndex +
                                                                                   " firstColumnIndex");

        if (columnIndex > lastColumnIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "columnIndex == " + columnIndex +
                                                                                   " > " + lastColumnIndex +
                                                                                   " lastColumnIndex");

        if (rowIndex < firstRowIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "rowIndex == " + rowIndex + " < " +
                                                                                   firstRowIndex + " firstRowIndex");

        if (rowIndex > lastRowIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "rowIndex == " + rowIndex + " > " +
                                                                                   lastRowIndex + " lastRowIndex");
    }

    /**
     * Creates a {@link MatrixTraverser} traversing the Items of this
     * {@link AbstractIndexMatrix}. The order in which the Items are traversed
     * is specified using
     * {@link #setDefaultTraversalOrder(MatrixTraversalOrder)}.
     *
     * @return new {@link MatrixTraverser} for this AbstractIndexMatrix
     *
     * @see #setDefaultTraversalOrder(MatrixTraversalOrder)
     * @see MatrixTraversalOrder
     */
    @Override
    public MatrixTraverser<Entry> createTraverser() {
        return defaultIterationOrder.createTraverser(this);
    }

    @Override
    public MatrixTraversible<Entry> traversedInOrder(final MatrixTraversalOrder iterationOrder) {
        return new MatrixTraversible<Entry>() {

            @Override
            public MatrixTraverser<Entry> createTraverser() {
                return iterationOrder.createTraverser(AbstractIndexMatrix.this);
            }
        };
    }

    /**
     * Registers the {@link MatrixTraversalOrder} used by each {@link Traverser}
     * returned by {@link #iterator()}.
     *
     * @param defaultIterationOrder
     *        {@link MatrixTraversalOrder} used by default {@link Traverser
     *        Traversers}
     */
    @Override
    public void setDefaultTraversalOrder(final MatrixTraversalOrder defaultIterationOrder) {
        this.defaultIterationOrder = defaultIterationOrder;
    }

    /**
     * Returns an {@link IndexMatrixColumn} representing the specified column of
     * this {@link AbstractIndexMatrix}.
     *
     * @param columnIndex
     *        integer specifying the index of the column
     *
     * @return MatrixColumn representing the column with {@code nextColumnIndex}
     */
    @Override
    public IndexMatrixColumn<Entry> getColumn(final int columnIndex) {
        return new IndexMatrixColumn<Entry>(this, columnIndex);
    }

    /**
     * Returns an {@link IndexMatrixColumn} representing the specified portion
     * of the specified column of this {@link AbstractIndexMatrix}.
     *
     * @param columnIndex
     *        integer specifying the index of the column
     *
     * @param firstPartRowIndex
     *        integer specifying the first row index of the portion of the
     *        column
     *
     * @param lastPartRowIndex
     *        integer specifying the last row index of the portion of the column
     *
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code columnIndex}
     */
    @Override
    public IndexMatrixColumn<Entry> getColumn(final int columnIndex, final int firstPartRowIndex, final int lastPartRowIndex) {
        return new IndexMatrixColumn<Entry>(this, columnIndex, firstPartRowIndex, lastPartRowIndex);
    }

    /**
     * Returns a {@link IndexMatrixRow} representing the specified row of this
     * {@link AbstractIndexMatrix}.
     *
     * @param rowIndex
     *        integer specifying the index of the row
     *
     * @return {@link IndexMatrixRow} representing the row with {@code rowIndex}
     */
    @Override
    public IndexMatrixRow<Entry> getRow(final int rowIndex) {
        return new IndexMatrixRow<Entry>(this, rowIndex);
    }

    /**
     * Returns a {@link IndexMatrixRow} representing the specified portion of
     * the specified row of this {@link AbstractIndexMatrix}.
     *
     * @param rowIndex
     *        integer specifying the index of the row
     *
     * @param firstPartColumnIndex
     *        integer specifying the first column index of the portion of the
     *        row
     *
     * @param lastPartColumnIndex
     *        integer specifying the last column index of the portion of the row
     *
     * @return {@link IndexMatrixRow} representing the specified portion of the
     *         row with {@code rowIndex}
     */
    @Override
    public IndexMatrixRow<Entry> getRow(final int rowIndex, final int firstPartColumnIndex, final int lastPartColumnIndex) {
        return new IndexMatrixRow<Entry>(this, rowIndex, firstPartColumnIndex, lastPartColumnIndex);
    }

    @Override
    public int getWidth() {
        return lastColumnIndex - firstColumnIndex + 1;
    }

    @Override
    public int getHeight() {
        return lastRowIndex - firstColumnIndex + 1;
    }

    @Override
    public String toString() {
        return getColumns().toString();
    }
}
