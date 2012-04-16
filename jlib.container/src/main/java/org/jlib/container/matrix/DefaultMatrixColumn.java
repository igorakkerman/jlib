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

    /** integer specifying the minimum row index of the range of the column */
    private int minimumRowIndex;

    /** integer specifying the maximum row index of the range of the column */
    private int maximumRowIndex;

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
        this(matrix, columnIndex, matrix.minimumRowIndex(), matrix.maximumRowIndex());
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
     * @param minimumRowIndex
     *        integer specifying the minimum row index of the range of the
     *        column
     * 
     * @param maximumRowIndex
     *        integer specifying the maximum row index of the range of the
     *        column
     * 
     * @throws IllegalArgumentException
     *         if {@code minimumRowIndex > maximumRowIndex}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code columnIndex} is not a valid column index of
     *         {@code matrix} or either {@code minimumRowIndex} or
     *         {@code maximumRowIndex} is not a valid row index of
     *         {@code matrix}
     */
    public DefaultMatrixColumn(ArraySequenceMatrix<Element> matrix, int columnIndex, int minimumRowIndex, int maximumRowIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {

        super(minimumRowIndex, maximumRowIndex);

        this.matrix = matrix;
        this.columnIndex = columnIndex;
        this.minimumRowIndex = minimumRowIndex;
        this.maximumRowIndex = maximumRowIndex;

        if (columnIndex < matrix.minimumColumnIndex() || columnIndex > matrix.maximumColumnIndex())
            throw new SequenceIndexOutOfBoundsException(this, columnIndex);

        if (minimumRowIndex < matrix.minimumRowIndex())
            throw new SequenceIndexOutOfBoundsException(this, minimumRowIndex);

        if (maximumRowIndex > matrix.maximumRowIndex())
            throw new SequenceIndexOutOfBoundsException(this, maximumRowIndex);
    }

    @Override
    public Element get(int index) {
        return matrix.get(columnIndex, index);
    }

    @Override
    public void set(int index, Element element)
    throws SequenceIndexOutOfBoundsException {
        matrix.set(columnIndex, index, element);
    }

    @Override
    public final ArraySequenceMatrix<Element> getMatrix() {
        return matrix;
    }

    @Override
    public final int getMinimumRowIndex() {
        return minimumRowIndex;
    }

    @Override
    public final int getMaximumRowIndex() {
        return maximumRowIndex;
    }

    @Override
    public final int getColumnIndex() {
        return columnIndex;
    }
}
