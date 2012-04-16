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
 * Default implementation of the MatrixRow interface.
 *
 * @author Igor Akkerman
 * @param <Element>
 *        type of the elements held in the ArraySequenceMatrix
 */
class DefaultMatrixRow<Element>
extends AbstractNonEmptyReplaceIndexSequence<Element>
implements MatrixRow<Element> {

    /** ArraySequenceMatrix of which this MatrixRow represents the range of a row */
    private ArraySequenceMatrix<Element> matrix;

    /** integer specifying the index of the row in the ArraySequenceMatrix that this MatrixRow represents */
    private int rowIndex;

    /** integer specifying the minimum column index of the range of the row */
    private int minimumColumnIndex;

    /** integer specifying the maximum column index of the range of the row */
    private int maximumColumnIndex;

    /**
     * Creates a new MatrixRow representing the specified row of the specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix of which this MatrixRow represents a row
     * @param rowIndex
     *        integer specifying the index of the row in the ArraySequenceMatrix that this MatrixRow represents
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code rowIndex} is not a valid row index of {@code matrix}
     */
    protected DefaultMatrixRow(ArraySequenceMatrix<Element> matrix, int rowIndex)
    throws SequenceIndexOutOfBoundsException {
        this(matrix, rowIndex, matrix.minimumColumnIndex(), matrix.maximumColumnIndex());
    }

    /**
     * Creates a new MatrixRow representing the specified range of the specified row of the
     * specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix of which this MatrixRow represents the range of a row
     * @param rowIndex
     *        integer specifying the index of the row in the ArraySequenceMatrix that this MatrixRow represents
     * @param minimumColumnIndex
     *        integer specifying the minimum column index of the range of the row
     * @param maximumColumnIndex
     *        integer specifying the maximum column index of the range of the row
     * @throws IllegalArgumentException
     *         if {@code minimumColumnIndex > maximumColumnIndex}
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextElementRowIndex} is not a valid row index of {@code matrix} or either
     *         {@code minimumColumnIndex} or {@code maximumColumnIndex} is not a valid column index of
     *         {@code matrix}
     */
    protected DefaultMatrixRow(ArraySequenceMatrix<Element> matrix, int rowIndex, int minimumColumnIndex, int maximumColumnIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        super(minimumColumnIndex, maximumColumnIndex);
        this.matrix = matrix;
        this.rowIndex = rowIndex;
        this.minimumColumnIndex = minimumColumnIndex;
        this.maximumColumnIndex = maximumColumnIndex;

        if (minimumColumnIndex > maximumColumnIndex)
            throw new IllegalArgumentException();

        if (rowIndex < matrix.minimumRowIndex() || rowIndex > matrix.maximumRowIndex())
            throw new SequenceIndexOutOfBoundsException(this, rowIndex);

        if (minimumColumnIndex < matrix.minimumColumnIndex())
            throw new SequenceIndexOutOfBoundsException(this, minimumColumnIndex);

        if (maximumColumnIndex > matrix.maximumColumnIndex())
            throw new SequenceIndexOutOfBoundsException(this, maximumColumnIndex);
    }

    @Override
    public Element get(int index) {
        return matrix.get(index, rowIndex);
    }

    @Override
    public void set(int index, Element element)
    throws SequenceIndexOutOfBoundsException {
        matrix.set(index, rowIndex, element);
    }

    @Override
    public final ArraySequenceMatrix<Element> getMatrix() {
        return matrix;
    }

    @Override
    public final int getRowIndex() {
        return rowIndex;
    }

    @Override
    public final int getMinColumnIndex() {
        return minimumColumnIndex;
    }

    @Override
    public final int getMaxColumnIndex() {
        return maximumColumnIndex;
    }
}
