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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator over a Matrix.
 *
 * @param <Element>
 *        type of elements stored in the Matrix
 * @author Igor Akkerman
 */
abstract class MatrixIterator<Element>
implements Iterator<Element> {

    /** matrix containing the elements */
    protected Matrix<Element> matrix;

    /** minimum column index */
    protected int minColumnIndex;

    /** maximum column index */
    protected int maxColumnIndex;

    /** minimum row index */
    protected int minRowIndex;

    /** maximum row index */
    protected int maxRowIndex;

    /** column index of the next Element */
    protected int nextElementColumnIndex;

    /** row index of the next Element */
    protected int nextElementRowIndex;

    /**
     * Creates a new MatrixIterator for the specified Matrix.
     *
     * @param matrix
     *        Matrix to traverse
     */
    protected MatrixIterator(Matrix<Element> matrix) {
        this(matrix, matrix.minColumnIndex(), matrix.maxColumnIndex(), matrix.minRowIndex(), matrix.maxRowIndex());
    }

    /**
     * Creates a new MatrixIterator for the specified portion of the specified Matrix.
     *
     * @param matrix
     *        Matrix to traverse
     * @param minColumnIndex
     *        integer specifying the minimum column index of the Matrix portion
     * @param maxColumnIndex
     *        integer specifying the maximum column index of the Matrix portion
     * @param minRowIndex
     *        integer specifying the minimum row index of the Matrix portion
     * @param maxRowIndex
     *        integer specifying the maximum row index of the Matrix portion
     */
    protected MatrixIterator(Matrix<Element> matrix, int minColumnIndex, int maxColumnIndex, int minRowIndex,
                             int maxRowIndex) {
        super();

        this.matrix = matrix;

        this.minColumnIndex = minColumnIndex;
        this.maxColumnIndex = maxColumnIndex;
        this.minRowIndex = minRowIndex;
        this.maxRowIndex = maxRowIndex;

        nextElementColumnIndex = minColumnIndex;
        nextElementRowIndex = maxColumnIndex;
    }

    // @see java.util.Iterator#hasNext()
    public boolean hasNext() {
        return minColumnIndex <= nextElementColumnIndex && nextElementColumnIndex <= maxColumnIndex
               && minRowIndex <= nextElementRowIndex && nextElementRowIndex <= maxRowIndex;
    }

    // @see java.util.Iterator#next()
    public Element next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Element element = matrix.get(nextElementColumnIndex, nextElementRowIndex);

        updateNextElementIndices();

        return element;
    }

    /**
     * Sets the column and row of this MatrixIterator to the column and row of the next
     * Element to be traversed.
     */
    protected abstract void updateNextElementIndices();

    /**
     * Always throws a {@code UnsupportedOperationException} since Elements in a Matrix
     * cannot be removed.
     *
     * @throws UnsupportedOperationException
     *         always
     */
    public void remove()
    throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
