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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator over a {@link IndexMatrix}.
 * 
 * @param <ColumnIndex>
 *        type of column indices
 * 
 * @param <RowIndex>
 *        type of row indices
 * 
 * @param <Entry>
 *        type of entries stored in the ArraySequenceMatrix
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexMatrixIterator<Entry, ColumnIndex, RowIndex>
implements Iterator<Entry>, MatrixIterator<Entry> {

    /** matrix containing the elements */
    protected ArraySequenceMatrix<Entry> matrix;

    /** first column index */
    protected ColumnIndex firstColumnIndex;

    /** last column index */
    protected ColumnIndex lastColumnIndex;

    /** first row index */
    protected RowIndex firstRowIndex;

    /** last row index */
    protected int lastRowindex;

    /** column index of the next Element */
    protected ColumnIndex nextElementColumnIndex;

    /** row index of the next Element */
    protected RowIndex nextElementRowIndex;

    /**
     * Creates a new AbstractIndexMatrixIterator for the specified
     * ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix to traverse
     */
    protected AbstractIndexMatrixIterator(final ArraySequenceMatrix<Entry> matrix) {
        this(matrix, matrix.getFirstColumnIndex(), matrix.getLastColumnIndex(), matrix.getFirstRowIndex(),
             matrix.getLastRowIndex());
    }

    /**
     * Creates a new AbstractIndexMatrixIterator for the specified portion of
     * the specified ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix to traverse
     * @param firstColumnIndex
     *        integer specifying the first column index of the
     *        ArraySequenceMatrix portion
     * @param lastColumnIndex
     *        integer specifying the last column index of the
     *        ArraySequenceMatrix portion
     * @param firstRowIndex
     *        integer specifying the first row index of the ArraySequenceMatrix
     *        portion
     * @param lastRowindex
     *        integer specifying the last row index of the ArraySequenceMatrix
     *        portion
     */
    protected AbstractIndexMatrixIterator(final ArraySequenceMatrix<Entry> matrix, final ColumnIndex firstColumnIndex,
                                          final ColumnIndex lastColumnIndex, RowIndex firstRowIndex, int lastRowindex) {
        super();

        this.matrix = matrix;

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.firstRowIndex = firstRowIndex;
        this.lastRowIndex = maximumRowindex;

        nextElementColumnIndex = firstColumnIndex;
        nextElementRowIndex = lastColumnIndex;
    }

    @Override
    public boolean hasNext() {
        return firstColumnIndex <= nextElementColumnIndex && nextElementColumnIndex <= lastColumnIndex &&
               firstRowIndex <= nextElementRowIndex && nextElementRowIndex <= lastRowindex;
    }

    @Override
    public Entry next() {
        if (! hasNext())
            throw new NoSuchElementException();

        Entry element = matrix.get(nextElementColumnIndex, nextElementRowIndex);

        updateNextElementIndices();

        return element;
    }

    /**
     * Sets the column and row of this AbstractIndexMatrixIterator to the column
     * and row of the next Element to be traversed.
     */
    protected abstract void updateNextElementIndices();

    @Override
    public void nextEntity()
    throws IllegalStateException {
        if (! hasNext())
            throw new IllegalStateException();

        updateNextEntityIndices();
    }

    /**
     * Sets the column and row of this AbstractIndexMatrixIterator to the column
     * and row of the next entity to be traversed.
     */
    protected abstract void updateNextEntityIndices();

    /**
     * Always throws a {@code UnsupportedOperationException} since Elements
     * cnanot be removed from a ArraySequenceMatrix.
     * 
     * @throws UnsupportedOperationException
     *         always
     */
    @Override
    public void remove()
    throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
