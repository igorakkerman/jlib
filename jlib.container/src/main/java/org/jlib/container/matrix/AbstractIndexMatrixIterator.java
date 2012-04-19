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

// TODO: convert to AbstractMatrixIterator using matrix.getRows() and matrix.getColumns();

/**
 * Iterator over a {@link IndexMatrix}.
 * 
 * @param <Entry>
 *        type of entries stored in the IndexMatrix
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexMatrixIterator<Entry>
extends AbstractMatrixIterator<Entry> {

    /** matrix containing the elements */
    protected IndexMatrix<Entry> matrix;

    /** first column index */
    protected Integer firstColumnIndex;

    /** last column index */
    protected Integer lastColumnIndex;

    /** first row index */
    protected Integer firstRowIndex;

    /** last row index */
    protected Integer lastRowIndex;

    /** column index of the next Element */
    protected Integer nextElementColumnIndex;

    /** row index of the next Element */
    protected Integer nextElementRowIndex;

    /**
     * Creates a new AbstractIndexMatrixIterator for the specified
     * IndexMatrix.
     * 
     * @param matrix
     *        IndexMatrix to traverse
     */
    protected AbstractIndexMatrixIterator(final IndexMatrix<Entry> matrix) {
        this(matrix, matrix.getFirstColumnIndex(), matrix.getLastColumnIndex(), matrix.getFirstRowIndex(),
             matrix.getLastRowIndex());
    }

    /**
     * Creates a new AbstractIndexMatrixIterator for the specified portion of
     * the specified IndexMatrix.
     * 
     * @param matrix
     *        IndexMatrix to traverse
     * @param firstColumnIndex
     *        integer specifying the first column index of the
     *        IndexMatrix portion
     * @param lastColumnIndex
     *        integer specifying the last column index of the
     *        IndexMatrix portion
     * @param firstRowIndex
     *        integer specifying the first row index of the IndexMatrix
     *        portion
     * @param lastRowIndex
     *        integer specifying the last row index of the IndexMatrix
     *        portion
     */
    protected AbstractIndexMatrixIterator(final IndexMatrix<Entry> matrix, final int firstColumnIndex,
                                          final int lastColumnIndex, int firstRowIndex, int lastRowIndex) {
        super();

        this.matrix = matrix;

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.firstRowIndex = firstRowIndex;
        this.lastRowIndex = lastRowIndex;

        nextElementColumnIndex = firstColumnIndex;
        nextElementRowIndex = lastColumnIndex;
    }

    @Override
    public boolean hasNext() {
        return firstColumnIndex <= nextElementColumnIndex && nextElementColumnIndex <= lastColumnIndex &&
               firstRowIndex <= nextElementRowIndex && nextElementRowIndex <= lastRowIndex;
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
     * cnanot be removed from a IndexMatrix.
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
