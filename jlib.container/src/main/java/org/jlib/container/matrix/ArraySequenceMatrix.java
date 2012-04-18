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
// TODO: separate empty matrices from ArraySequenceMatrix class or use delegates

package org.jlib.container.matrix;

import java.util.Iterator;

import org.jlib.container.AbstractContainer;
import org.jlib.container.sequence.ArraySequence;
import org.jlib.container.sequence.IndexSequence;
import org.jlib.container.sequence.ReplaceIndexSequenceIterator;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;
import org.jlib.container.sequence.SequenceIterator;

/**
 * {@link IndexMatrix} backed by an {@link ArraySequence}.
 * 
 * @param <Entry>
 *        type of the entries held in the {@link ArraySequenceMatrix}
 *        
 * @author Igor Akkerman
 */
public class ArraySequenceMatrix<Entry>
extends AbstractContainer<Entry> implements IndexMatrix<Integer, Integer, Entry> {

    /** number of columns */
    private int width;

    /** number of rows */
    private int height;

    /** first column index */
    private ColumnIndex firstColumnIndex;

    /** last column index */
    private ColumnIndex lastColumnIndex;

    /** first row index */
    private RowIndex firstRowIndex;

    /** last row index */
    private int lastRowindex;

    /** ArraySequenceMatrix data */
    private ArraySequence<ArraySequence<Entry>> matrixData;

    /**
     * {@link MatrixIterationOrder} used by each {@link Iterator} returned by
     * {@link #iterator()}.
     */
    private MatrixIterationOrder defaultIterationOrder;

    /**
     * Creates a new empty ArraySequenceMatrix.
     */
    public ArraySequenceMatrix() {
        this(0, 0);
    }

    /**
     * Creates a new ArraySequenceMatrix of the specified width and height.
     * 
     * @param width
     *        integer specifying the number of columns of this matrix
     * @param height
     *        integer specifying the number of rows of this matrix
     * @throws IllegalArgumentException
     *         if {@code width < 0 || height < 0}
     */
    public ArraySequenceMatrix(int width, int height)
    throws IllegalArgumentException {
        super();
        if (width != 0 && height != 0) {
            construct(0, width - 1, 0, height - 1);
        }
        else {
            firstRowIndex = -1;
            lastRowindex = -1;
            firstColumnIndex = -1;
            lastColumnIndex = -1;
            this.width = width;
            this.height = height;
            matrixData = new ArraySequence<ArraySequence<Entry>>();

            defaultIterationOrder = MatrixUtility.HORIZONTAL;
        }
    }

    /**
     * Creates a new ArraySequenceMatrix with the specified minimum and maximum
     * column and row indices.
     * 
     * @param firstColumnIndex
     *        first column index
     * @param lastColumnIndex
     *        last column index
     * @param firstRowIndex
     *        first row index
     * @param lastRowindex
     *        last row index
     * @throws IllegalArgumentException
     *         if
     *         {@code firstColumnIndex < 0 || lastColumnIndex < firstColumnIndex
     *         || firstRowIndex < 0 || lastRowIndex < firstRowindex}
     */
    public ArraySequenceMatrix(ColumnIndex firstColumnIndex, RowIndex lastColumnIndex, int firstRowIndex, int lastRowindex) {
        super();
        construct(firstColumnIndex, lastColumnIndex, firstRowIndex, lastRowindex);
    }

    /**
     * Constructs this ArraySequenceMatrix.
     * 
     * @param firstColumnIndex
     *        first column index
     * @param lastColumnIndex
     *        last column index
     * @param firstRowIndex
     *        first row index
     * @param lastRowindex
     *        last row index
     * @throws IllegalArgumentException
     *         if
     *         {@code firstColumnIndex < 0 || lastColumnIndex < firstColumnIndex
     *         || firstRowIndex < 0 || lastRowIndex < firstRowindex}
     */

    private void construct(@SuppressWarnings("hiding") ColumnIndex firstColumnIndex,
                           @SuppressWarnings("hiding") ColumnIndex lastColumnIndex,
                           @SuppressWarnings("hiding") RowIndex firstRowIndex,
                           @SuppressWarnings("hiding") int lastRowindex) {
        if (firstColumnIndex < 0 || firstColumnIndex > lastColumnIndex || firstRowIndex < 0 ||
            firstRowIndex > lastRowindex)
            throw new IllegalArgumentException();

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.firstRowIndex = firstRowIndex;
        this.lastRowIndex = maximumRowindex;
        this.width = lastColumnIndex - firstColumnIndex + 1;
        this.height = lastRowIndex - firstRowindex + 1;

        matrixData = new ArraySequence<ArraySequence<Entry>>(firstRowIndex, lastRowindex);
        for (RowIndex rowIndex = firstRowIndex; rowIndex <= lastRowIndex; rowindex ++)
            matrixData.replace(rowIndex, new ArraySequence<Entry>(firstColumnIndex, lastColumnIndex));

        defaultIterationOrder = MatrixUtility.HORIZONTAL;
    }

    /**
     * Returns the Element stored at the specified column and row in this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * @return Element stored at the specified position in this
     *         ArraySequenceMatrix
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public Entry get(int columnIndex, int rowIndex)
    throws SequenceIndexOutOfBoundsException {
        return matrixData.get(rowIndex).get(columnIndex);
    }

    /**
     * Registers the Element to store at the specified column and row in this
     * ArraySequenceMatrix.
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
    public void set(int columnIndex, int rowIndex, Entry element) {
        matrixData.get(rowIndex).replace(columnIndex, element);
    }

    /**
     * Returns a MatrixColumn representing the specified column of this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @return MatrixColumn representing the column with {@code nextColumnIndex}
     */
    public MatrixColumn<Entry> column(int columnIndex) {
        return new DefaultMatrixColumn<Entry>(this, columnIndex);
    }

    /**
     * Returns a MatrixColumn representing the specified portion of the
     * specified column of this ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @param firstRowIndex
     *        integer specifying the first row index of the portion of the
     *        column
     * @param lastRowindex
     *        integer specifying the last row index of the portion of the
     *        column
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    public MatrixColumn<Entry> column(RowIndex columnIndex, @SuppressWarnings("hiding") int firstRowIndex,
                                        @SuppressWarnings("hiding") int lastRowindex) {
        return new DefaultMatrixColumn<Entry>(this, columnIndex, firstRowIndex, lastRowindex);
    }

    /**
     * Returns a MatrixRow representing the specified row of this
     * ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @return MatrixRow representing the row with {@code nextRowIndex}
     */
    public MatrixRow<Entry> row(int rowIndex) {
        return new DefaultMatrixRow<Entry>(this, rowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified portion of the specified
     * row of this ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @param firstColumnIndex
     *        integer specifying the first column index of the portion of the
     *        row
     * @param lastColumnIndex
     *        integer specifying the last column index of the portion of the
     *        row
     * @return MatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    // TODO: maybe it would be more appropriate to name these kinds of parameters using start/end or first/last
    public MatrixRow<Entry> row(ColumnIndex rowIndex, @SuppressWarnings("hiding") int firstColumnIndex,
                                  @SuppressWarnings("hiding") ColumnIndex lastColumnIndex) {
        return new DefaultMatrixRow<Entry>(this, rowIndex, firstColumnIndex, lastColumnIndex);
    }

    /**
     * Returns the Sequence of the MatrixRows of this ArraySequenceMatrix.
     * 
     * @return IndexSequence of the MatrixRows of this ArraySequenceMatrix
     */
    public IndexSequence<MatrixRow<Entry>> rowsSequence() {
        return new MatrixRowsSequence<Entry>(this);
    }

    /**
     * Returns the Sequence of the MatrixColumns of this ArraySequenceMatrix.
     * 
     * @return {@link IndexSequence} of the {@link MatrixColumn MatrixColumns} of this {@link ArraySequenceMatrix}
     */
    public IndexSequence<MatrixColumn<Entry>> columnsSequence() {
        return new MatrixColumnsSequence<Entry>(this);
    }

    /**
     * Returns the first column index of this ArraySequenceMatrix.
     * 
     * @return {@link Integer} specifying the minimum column of this ArraySequenceMatrix
     */
    @Override
    public Integer getFirstColumnIndex() {
        return firstColumnIndex;
    }

    /**
     * Returns the last column index of this ArraySequenceMatrix.
     * 
     * @return {@link Integer} specifying the maximum column of this ArraySequenceMatrix
     */
    @Override
    public Integer getLastColumnIndex() {
        return lastColumnIndex;
    }

    /**
     * Returns the first row index of this ArraySequenceMatrix.
     * 
     * @return {@link Integer} specifying the minimum row of this ArraySequenceMatrix
     */
    @Override
    public Integer getFirstRowIndex() {
        return firstRowIndex;
    }

    /**
     * Returns the last row index of this ArraySequenceMatrix.
     * 
     * @return {@link Integer} specifying the maximum row of this ArraySequenceMatrix
     */
    @Override
    public Integer getLastRowIndex() {
        return lastRowindex;
    }

    /**
     * Returns the width of this ArraySequenceMatrix.
     * 
     * @return integer specifying the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this ArraySequenceMatrix.
     * 
     * @return integer specifying the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Returns the number of cells in this ArraySequenceMatrix. The size is
     * equal to {@code getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of cells
     */
    @Override
    public int getSize() {
        return width * height;
    }

    /**
     * Creates a {@link AbstractIndexMatrixIterator} traversing the Elements of this
     * {@link ArraySequenceMatrix}. The order in which the Elements are
     * traversed is specified using
     * {@link #setDefaultIterationOrder(MatrixIterationOrder)}.
     * 
     * @return a new {@link AbstractIndexMatrixIterator} for this ArraySequenceMatrix
     * 
     * @see #setDefaultIterationOrder(MatrixIterationOrder)
     * @see MatrixIterationOrder
     */
    @Override
    public MatrixIterator<Entry>createIterator() {
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
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder) {
        this.defaultIterationOrder = defaultIterationOrder;
    }

    /**
     * Returns an {@link ReplaceIndexSequenceIterator} over a
     * single column of this ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column to traverse
     * @return a new column {@link SequenceIterator} for this ArraySequenceMatrix
     */
    public ReplaceIndexSequenceIterator<Entry> createColumnIterator(int columnIndex) {
        return column(columnIndex).createIterator();
    }

    /**
     * Returns an {@link ReplaceIndexSequenceIterator} over a
     * single row of this ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row to traverse
     * @return a new row {@link SequenceIterator} for this ArraySequenceMatrix
     */
    public ReplaceIndexSequenceIterator<Entry> createRowIterator(int rowIndex) {
        return row(rowIndex).createIterator();
    }

    @Override
    public String toString() {
        return matrixData.toString();
    }
}