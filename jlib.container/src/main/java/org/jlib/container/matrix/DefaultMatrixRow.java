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
 * Default implementation of the IndexMatrixRow interface.
 *
 * @author Igor Akkerman
 * @param <Element>
 *        type of the elements held in the ArraySequenceMatrix
 */
class DefaultMatrixRow<Element>
extends AbstractNonEmptyReplaceIndexSequence<Element>
implements IndexMatrixRow<Element> {

    /** ArraySequenceMatrix of which this IndexMatrixRow represents the range of a row */
    private ArraySequenceMatrix<Element> matrix;

    /** integer specifying the index of the row in the ArraySequenceMatrix that this IndexMatrixRow represents */
    private int rowIndex;

    /** integer specifying the first column index of the range of the row */
    private ColumnIndex firstColumnIndex;

    /** integer specifying the last column index of the range of the row */
    private ColumnIndex lastColumnIndex;

    /**
     * Creates a new IndexMatrixRow representing the specified row of the specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix of which this IndexMatrixRow represents a row
     * @param rowIndex
     *        integer specifying the index of the row in the ArraySequenceMatrix that this IndexMatrixRow represents
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code rowIndex} is not a valid row index of {@code matrix}
     */
    protected DefaultMatrixRow(ArraySequenceMatrix<Element> matrix, int rowIndex)
    throws SequenceIndexOutOfBoundsException {
        this(matrix, rowIndex, matrix.getFirstColumnIndex(), matrix.getLastColumnIndex());
    }

    /**
     * Creates a new IndexMatrixRow representing the specified range of the specified row of the
     * specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix of which this IndexMatrixRow represents the range of a row
     * @param rowIndex
     *        integer specifying the index of the row in the ArraySequenceMatrix that this IndexMatrixRow represents
     * @param firstColumnIndex
     *        integer specifying the first column index of the range of the row
     * @param lastColumnIndex
     *        integer specifying the last column index of the range of the row
     * @throws IllegalArgumentException
     *         if {@code firstColumnIndex > lastColumnIndex}
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextElementRowIndex} is not a valid row index of {@code matrix} or either
     *         {@code firstColumnIndex} or {@code lastColumnIndex} is not a valid column index of
     *         {@code matrix}
     */
    protected DefaultMatrixRow(ArraySequenceMatrix<Element> matrix, ColumnIndex rowIndex, int firstColumnIndex, int lastColumnIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        super(firstColumnIndex, lastColumnIndex);
        this.matrix = matrix;
        this.rowIndex = rowIndex;
        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;

        if (firstColumnIndex > lastColumnIndex)
            throw new IllegalArgumentException();

        if (rowIndex < matrix.getFirstRowIndex() || rowIndex > matrix.getLastRowIndex())
            throw new SequenceIndexOutOfBoundsException(this, rowIndex);

        if (firstColumnIndex < matrix.getFirstColumnIndex())
            throw new SequenceIndexOutOfBoundsException(this, firstColumnIndex);

        if (lastColumnIndex > matrix.getLastColumnIndex())
            throw new SequenceIndexOutOfBoundsException(this, lastColumnIndex);
    }

    @Override
    public Element get(int index) {
        return matrix.get(index, rowIndex);
    }

    @Override
    public void replace(int index, Element element)
    throws SequenceIndexOutOfBoundsException {
        matrix.set(index, rowIndex, element);
    }

    @Override
    public final ArraySequenceMatrix<Element> getMatrix() {
        return matrix;
    }

    @Override
    public final RowIndex getRowIndex() {
        return rowIndex;
    }

    @Override
    public final ColumnIndex getFirstColumnIndex() {
        return firstColumnIndex;
    }

    @Override
    public final ColumnIndex getLastColumnIndex() {
        return lastColumnIndex;
    }
}
