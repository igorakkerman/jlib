/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

// TODO: transform into interface, create ArraySequencesMatrix
// TODO: MatrixIndexOutOfBoundsException
// TODO: separate empty matrices from ArrayMatrix class or use delegates

package org.jlib.container.matrix;

import java.util.Iterator;

import org.jlib.container.AbstractContainer;
import org.jlib.container.sequence.IndexSequence;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;

/**
 * {@link IndexMatrix} backed by an {@link ArraySequence}.
 * 
 * @param <Entry>
 *        type of the entries held in the {@link ArrayMatrix}
 * 
 * @author Igor Akkerman
 */
public class ArrayMatrix<Entry>
extends AbstractContainer<Entry>
implements IndexMatrix<Entry> {

    /** matrix data */
    private Entry[][] matrixData;

    /**
     * {@link MatrixIterationOrder} used by each {@link Iterator} returned by
     * {@link #iterator()}.
     */
    private MatrixIterationOrder defaultIterationOrder;

    /**
     * Creates a new ArrayMatrix of the specified width and height.
     * 
     * @param width
     *        integer specifying the number of columns of this matrix
     * 
     * @param height
     *        integer specifying the number of rows of this matrix
     * 
     * @throws IllegalArgumentException
     *         if {@code width < 0 || height < 0}
     */
    @SuppressWarnings("unchecked")
    public ArrayMatrix(final int width, final int height)
    throws IllegalArgumentException {
        super();
    }

    /**
     * Creates a new ArrayMatrix with the specified minimum and maximum column
     * and row indices.
     * 
     * @param firstColumnIndex
     *        first column index
     * @param lastColumnIndex
     *        last column index
     * @param firstRowIndex
     *        first row index
     * @param lastRowIndex
     *        last row index
     * @throws IllegalArgumentException
     *         if
     *         {@code firstColumnIndex < 0 || lastColumnIndex < firstColumnIndex
     *         || firstRowIndex < 0 || lastRowIndex < firstRowIndex}
     */
    public ArrayMatrix(final int firstColumnIndex, final int lastColumnIndex, final int firstRowIndex,
                       final int lastRowIndex) {
        super();
        construct(firstColumnIndex, lastColumnIndex, firstRowIndex, lastRowIndex);
    }

    /**
     * Constructs this ArrayMatrix.
     * 
     * @param firstColumnIndex
     *        first column index
     * @param lastColumnIndex
     *        last column index
     * @param firstRowIndex
     *        first row index
     * @param lastRowIndex
     *        last row index
     * @throws IllegalArgumentException
     *         if
     *         {@code firstColumnIndex < 0 || lastColumnIndex < firstColumnIndex
     *         || firstRowIndex < 0 || lastRowIndex < firstRowIndex}
     */

    private void construct(@SuppressWarnings("hiding") final int firstColumnIndex,
                           @SuppressWarnings("hiding") final int lastColumnIndex,
                           @SuppressWarnings("hiding") final int firstRowIndex,
                           @SuppressWarnings("hiding") final int lastRowIndex) {
        if (firstColumnIndex < 0 || firstColumnIndex > lastColumnIndex || firstRowIndex < 0 ||
            firstRowIndex > lastRowIndex)
            throw new IllegalArgumentException();

        matrixData = new ArraySequence<ArraySequence<Entry>>(firstRowIndex, lastRowIndex);
        for (int rowIndex = firstRowIndex; rowIndex <= lastRowIndex; rowIndex ++)
            matrixData.replace(rowIndex, new ArraySequence<Entry>(firstColumnIndex, lastColumnIndex));

        defaultIterationOrder = MatrixUtility.HORIZONTAL;
    }

    /**
     * Returns the Element stored at the specified column and row in this
     * ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * @return Element stored at the specified position in this ArrayMatrix
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    @Override
    public Entry get(final int columnIndex, final int rowIndex)
    throws SequenceIndexOutOfBoundsException {
        return matrixData.get(rowIndex).get(columnIndex);
    }

    /**
     * Registers the Element to store at the specified column and row in this
     * ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the Element to store
     * @param rowIndex
     *        integer specifying the row of the Element to store
     * @param element
     *        Element to store. {@code null} is a valid Element.
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public void set(final int columnIndex, final int rowIndex, final Entry element) {
        matrixData.get(rowIndex).replace(columnIndex, element);
    }

    /**
     * Returns a MatrixColumn representing the specified column of this
     * ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @return MatrixColumn representing the column with {@code nextColumnIndex}
     */
    @Override
    public IndexSequence<Entry> getColumn(final int columnIndex) {
        return new DefaultMatrixColumn<Entry>(this, columnIndex);
    }

    /**
     * Returns a MatrixColumn representing the specified portion of the
     * specified column of this ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @param firstRowIndex
     *        integer specifying the first row index of the portion of the
     *        column
     * @param lastRowIndex
     *        integer specifying the last row index of the portion of the column
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    @Override
    public IndexSequence<Entry> getColumn(final int columnIndex, @SuppressWarnings("hiding") final int firstRowIndex,
                                          @SuppressWarnings("hiding") final int lastRowIndex) {
        return new DefaultMatrixColumn<Entry>(this, columnIndex, firstRowIndex, lastRowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified row of this ArrayMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @return MatrixRow representing the row with {@code nextRowIndex}
     */
    @Override
    public MatrixRow<Entry> getRow(final int rowIndex) {
        return new DefaultMatrixRow<Entry>(this, rowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified portion of the specified
     * row of this ArrayMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @param firstColumnIndex
     *        integer specifying the first column index of the portion of the
     *        row
     * @param lastColumnIndex
     *        integer specifying the last column index of the portion of the row
     * @return MatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    // TODO: maybe it would be more appropriate to name these kinds of parameters using start/end or first/last
    @Override
    public MatrixRow<Entry> getRow(final int rowIndex, @SuppressWarnings("hiding") final int firstColumnIndex,
                                   @SuppressWarnings("hiding") final int lastColumnIndex) {
        return new DefaultMatrixRow<Entry>(this, rowIndex, firstColumnIndex, lastColumnIndex);
    }

    /**
     * Returns the Sequence of the MatrixRows of this ArrayMatrix.
     * 
     * @return IndexSequence of the MatrixRows of this ArrayMatrix
     */
    @Override
    public IndexSequence<MatrixRow<Entry>> getRows() {
        return new IndexMatrixRow<Entry>(this);
    }

    /**
     * Returns the Sequence of the MatrixColumns of this ArrayMatrix.
     * 
     * @return {@link IndexSequence} of the {@link MatrixColumn MatrixColumns}
     *         of this {@link ArrayMatrix}
     */
    @Override
    public IndexSequence<MatrixColumn<Entry>> getColumns() {
        return new MatrixColumnsSequence<Entry>(this);
    }

    /**
     * Returns the first column index of this ArrayMatrix.
     * 
     * @return {@link Integer} specifying the minimum column of this ArrayMatrix
     */
    @Override
    public Integer getFirstColumnIndex() {
        return firstColumnIndex;
    }

    /**
     * Returns the last column index of this ArrayMatrix.
     * 
     * @return {@link Integer} specifying the maximum column of this ArrayMatrix
     */
    @Override
    public int getLastColumnIndex() {
        return lastColumnIndex;
    }

    /**
     * Returns the first row index of this ArrayMatrix.
     * 
     * @return {@link Integer} specifying the minimum row of this ArrayMatrix
     */
    @Override
    public int getFirstRowIndex() {
        return firstRowIndex;
    }

    /**
     * Returns the last row index of this ArrayMatrix.
     * 
     * @return integer specifying the maximum row of this ArrayMatrix
     */
    @Override
    public int getLastRowIndex() {
        return lastRowIndex;
    }

    /**
     * Returns the width of this ArrayMatrix.
     * 
     * @return integer specifying the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this ArrayMatrix.
     * 
     * @return integer specifying the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Creates a {@link AbstractIndexMatrixIterator} traversing the Elements of
     * this {@link ArrayMatrix}. The order in which the Elements are traversed
     * is specified using
     * {@link #setDefaultIterationOrder(MatrixIterationOrder)}.
     * 
     * @return a new {@link AbstractIndexMatrixIterator} for this ArrayMatrix
     * 
     * @see #setDefaultIterationOrder(MatrixIterationOrder)
     * @see MatrixIterationOrder
     */
    @Override
    public MatrixIterator<Entry> createIterator() {
        return defaultIterationOrder.createIterator(this);
    }

    /**
     * Registers the {@link MatrixIterationOrder} used by each {@link Iterator}
     * returned by {@link #iterator()}.
     * 
     * @param defaultIterationOrder
     *        {@link MatrixIterationOrder} used by default {@link Iterator
     *        Iterators}
     */
    @Override
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder) {
        this.defaultIterationOrder = defaultIterationOrder;
    }

    @Override
    public String toString() {
        return matrixData.toString();
    }
}