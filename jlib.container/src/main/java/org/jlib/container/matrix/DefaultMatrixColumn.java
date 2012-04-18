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

package org.jlib.container.matrix;

import org.jlib.container.sequence.AbstractNonEmptyReplaceIndexSequence;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;

/**
 * Default implementation of the MatrixColumn interface.
 * 
 * @param <Element>
 *        type of the elements held in the ArraySequenceMatrix
 * 
 * @author Igor Akkerman
 */
class DefaultMatrixColumn<Element>
extends AbstractNonEmptyReplaceIndexSequence<Element>
implements MatrixColumn<Element> {

    /** ArraySequenceMatrix of which this MatrixColumn represents the range of a column */
    private ArraySequenceMatrix<Element> matrix;

    /**
     * integer specifying the index of the column in the ArraySequenceMatrix that this
     * MatrixColumn represents
     */
    private int columnIndex;

    /** integer specifying the first row index of the range of the column */
    private RowIndex firstRowIndex;

    /** integer specifying the last row index of the range of the column */
    private int lastRowindex;

    /**
     * Creates a new MatrixColumn representing the specified column of the
     * specified ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix of which this MatrixColumn represents a column
     * @param columnIndex
     *        integer specifying the index of the column in the ArraySequenceMatrix that this
     *        MatrixColumn represents
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code columnIndex} is not a valid column index of
     *         {@code matrix}
     */
    protected DefaultMatrixColumn(ArraySequenceMatrix<Element> matrix, int columnIndex)
    throws SequenceIndexOutOfBoundsException {
        this(matrix, columnIndex, matrix.getFirstRowIndex(), matrix.getLastRowIndex());
    }

    /**
     * Creates a new MatrixColumn representing the specified range of the
     * specified column of the specified ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix of which this MatrixColumn represents the range of a column
     * 
     * @param columnIndex
     *        integer specifying the index of the column in the ArraySequenceMatrix that this
     *        MatrixColumn represents
     * 
     * @param firstRowIndex
     *        integer specifying the first row index of the range of the
     *        column
     * 
     * @param lastRowindex
     *        integer specifying the last row index of the range of the
     *        column
     * 
     * @throws IllegalArgumentException
     *         if {@code firstRowIndex > lastRowindex}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code columnIndex} is not a valid column index of
     *         {@code matrix} or either {@code firstRowIndex} or
     *         {@code lastRowindex} is not a valid row index of
     *         {@code matrix}
     */
    public DefaultMatrixColumn(ArraySequenceMatrix<Element> matrix, RowIndex columnIndex, int firstRowIndex, int lastRowindex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {

        super(firstRowIndex, lastRowindex);

        this.matrix = matrix;
        this.columnIndex = columnIndex;
        this.firstRowIndex = firstRowIndex;
        this.lastRowIndex = maximumRowindex;

        if (columnIndex < matrix.getFirstColumnIndex() || columnIndex > matrix.getLastColumnIndex())
            throw new SequenceIndexOutOfBoundsException(this, columnIndex);

        if (firstRowIndex < matrix.getFirstRowIndex())
            throw new SequenceIndexOutOfBoundsException(this, firstRowIndex);

        if (lastRowIndex > matrix.getLastRowindex())
            throw new SequenceIndexOutOfBoundsException(this, lastRowindex);
    }

    @Override
    public Element get(int index) {
        return matrix.get(columnIndex, index);
    }

    @Override
    public void replace(int index, Element element)
    throws SequenceIndexOutOfBoundsException {
        matrix.set(columnIndex, index, element);
    }

    @Override
    public final ArraySequenceMatrix<Element> getMatrix() {
        return matrix;
    }

    @Override
    public final RowIndex getFirstRowIndex() {
        return firstRowIndex;
    }

    @Override
    public final RowIndex getMaximumRowIndex() {
        return lastRowindex;
    }

    @Override
    public final ColumnIndex getColumnIndex() {
        return columnIndex;
    }
}
