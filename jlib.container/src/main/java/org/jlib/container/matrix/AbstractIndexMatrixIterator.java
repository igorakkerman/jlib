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
 * @param <int>
 *        type of column indices
 * 
 * @param <int>
 *        type of row indices
 * 
 * @param <Entry>
 *        type of entries stored in the ArraySequenceMatrix
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexMatrixIterator<Entry, int, int>
implements Iterator<Entry>, MatrixIterator<Entry> {

    /** matrix containing the elements */
    protected ArraySequenceMatrix<Entry> matrix;

    /** first column index */
    protected int firstint;

    /** last column index */
    protected int lastint;

    /** first row index */
    protected int firstint;

    /** last row index */
    protected int lastRowindex;

    /** column index of the next Element */
    protected int nextElementint;

    /** row index of the next Element */
    protected int nextElementint;

    /**
     * Creates a new AbstractIndexMatrixIterator for the specified
     * ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix to traverse
     */
    protected AbstractIndexMatrixIterator(final ArraySequenceMatrix<Entry> matrix) {
        this(matrix, matrix.getFirstint(), matrix.getLastint(), matrix.getFirstint(),
             matrix.getLastint());
    }

    /**
     * Creates a new AbstractIndexMatrixIterator for the specified portion of
     * the specified ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix to traverse
     * @param firstint
     *        integer specifying the first column index of the
     *        ArraySequenceMatrix portion
     * @param lastint
     *        integer specifying the last column index of the
     *        ArraySequenceMatrix portion
     * @param firstint
     *        integer specifying the first row index of the ArraySequenceMatrix
     *        portion
     * @param lastRowindex
     *        integer specifying the last row index of the ArraySequenceMatrix
     *        portion
     */
    protected AbstractIndexMatrixIterator(final ArraySequenceMatrix<Entry> matrix, final int firstint,
                                          final int lastint, int firstint, int lastRowindex) {
        super();

        this.matrix = matrix;

        this.firstint = firstint;
        this.lastint = lastint;
        this.firstint = firstint;
        this.lastint = maximumRowindex;

        nextElementint = firstint;
        nextElementint = lastint;
    }

    @Override
    public boolean hasNext() {
        return firstint <= nextElementint && nextElementint <= lastint &&
               firstint <= nextElementint && nextElementint <= lastRowindex;
    }

    @Override
    public Entry next() {
        if (! hasNext())
            throw new NoSuchElementException();

        Entry element = matrix.get(nextElementint, nextElementint);

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
