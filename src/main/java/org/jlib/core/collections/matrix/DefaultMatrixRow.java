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

package org.jlib.core.collections.matrix;

import org.jlib.core.collections.list.AbstractEditableIndexList;
import org.jlib.core.collections.list.ListIndexOutOfBoundsException;

/**
 * Default implementation of the MatrixRow interface.
 *
 * @author Igor Akkerman
 * @param <Element>
 *        type of the elements held in the Matrix
 */
class DefaultMatrixRow<Element>
extends AbstractEditableIndexList<Element>
implements MatrixRow<Element> {

    /** Matrix of which this MatrixRow represents the range of a row */
    private Matrix<Element> matrix;

    /** integer specifying the index of the row in the Matrix that this MatrixRow represents */
    private int rowIndex;

    /** integer specifying the minimum column index of the range of the row */
    private int minColumnIndex;

    /** integer specifying the maximum column index of the range of the row */
    private int maxColumnIndex;

    /**
     * Creates a new MatrixRow representing the specified row of the specified Matrix.
     *
     * @param matrix
     *        Matrix of which this MatrixRow represents a row
     * @param rowIndex
     *        integer specifying the index of the row in the Matrix that this MatrixRow represents
     * @throws ListIndexOutOfBoundsException
     *         if {@code rowIndex} is not a valid row index of {@code matrix}
     */
    protected DefaultMatrixRow(Matrix<Element> matrix, int rowIndex)
    throws ListIndexOutOfBoundsException {
        this(matrix, rowIndex, matrix.minColumnIndex(), matrix.maxColumnIndex());
    }

    /**
     * Creates a new MatrixRow representing the specified range of the specified row of the
     * specified Matrix.
     *
     * @param matrix
     *        Matrix of which this MatrixRow represents the range of a row
     * @param rowIndex
     *        integer specifying the index of the row in the Matrix that this MatrixRow represents
     * @param minColumnIndex
     *        integer specifying the minimum column index of the range of the row
     * @param maxColumnIndex
     *        integer specifying the maximum column index of the range of the row
     * @throws IllegalArgumentException
     *         if {@code minColumnIndex > maxColumnIndex}
     * @throws ListIndexOutOfBoundsException
     *         if {@code nextElementRowIndex} is not a valid row index of {@code matrix} or either
     *         {@code minColumnIndex} or {@code maxColumnIndex} is not a valid column index of
     *         {@code matrix}
     */
    protected DefaultMatrixRow(Matrix<Element> matrix, int rowIndex, int minColumnIndex, int maxColumnIndex)
    throws IllegalArgumentException, ListIndexOutOfBoundsException {
        super(minColumnIndex, maxColumnIndex);
        this.matrix = matrix;
        this.rowIndex = rowIndex;
        this.minColumnIndex = minColumnIndex;
        this.maxColumnIndex = maxColumnIndex;

        if (minColumnIndex > maxColumnIndex)
            throw new IllegalArgumentException();

        if (rowIndex < matrix.minRowIndex() || rowIndex > matrix.maxRowIndex())
            throw new ListIndexOutOfBoundsException(rowIndex);

        if (minColumnIndex < matrix.minColumnIndex())
            throw new ListIndexOutOfBoundsException(minColumnIndex);

        if (maxColumnIndex > matrix.maxColumnIndex())
            throw new ListIndexOutOfBoundsException(maxColumnIndex);
    }

    // @see org.jlib.core.collections.list.IndexList#get(int)
    @Override
    public Element get(int index) {
        return matrix.get(index, rowIndex);
    }

    // @see org.jlib.core.collections.list.EditableIndexList#set(int, java.lang.Object)
    @Override
    public Element set(int index, Element element)
    throws ListIndexOutOfBoundsException {
        Element oldElement = get(index);
        matrix.set(index, rowIndex, element);
        return oldElement;
    }

    // @see org.jlib.core.collections.matrix.MatrixRow#getMatrix()
    @Override
    public final Matrix<Element> getMatrix() {
        return matrix;
    }

    // @see org.jlib.core.collections.matrix.MatrixRow#getRowIndex()
    @Override
    public final int getRowIndex() {
        return rowIndex;
    }

    // @see org.jlib.core.collections.matrix.MatrixRow#getMinColumnIndex()
    @Override
    public final int getMinColumnIndex() {
        return minColumnIndex;
    }

    // @see org.jlib.core.collections.matrix.MatrixRow#getMaxColumnIndex()
    @Override
    public final int getMaxColumnIndex() {
        return maxColumnIndex;
    }
}
