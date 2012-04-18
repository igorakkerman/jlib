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
 * Iterator over a ArraySequenceMatrix.
 * 
 * @param <Element>
 *        type of elements stored in the ArraySequenceMatrix
 * @author Igor Akkerman
 */
public abstract class AbstractMatrixIterator<Element>
implements Iterator<Element>, MatrixIterator<Element> {

    /** matrix containing the elements */
    protected ArraySequenceMatrix<Element> matrix;

    /** minimum column index */
    protected int firstColumnIndex;

    /** maximum column index */
    protected int lastColumnIndex;

    /** minimum row index */
    protected int minimumRowIndex;

    /** maximum row index */
    protected int maximumRowIndex;

    /** column index of the next Element */
    protected int nextElementColumnIndex;

    /** row index of the next Element */
    protected int nextElementRowIndex;

    /**
     * Creates a new AbstractMatrixIterator for the specified ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix to traverse
     */
    protected AbstractMatrixIterator(ArraySequenceMatrix<Element> matrix) {
        this(matrix, matrix.firstColumnIndex(), matrix.lastColumnIndex(), matrix.minimumRowIndex(), matrix.maximumRowIndex());
    }

    /**
     * Creates a new AbstractMatrixIterator for the specified portion of the specified
     * ArraySequenceMatrix.
     * 
     * @param matrix
     *        ArraySequenceMatrix to traverse
     * @param firstColumnIndex
     *        integer specifying the minimum column index of the ArraySequenceMatrix portion
     * @param lastColumnIndex
     *        integer specifying the maximum column index of the ArraySequenceMatrix portion
     * @param minimumRowIndex
     *        integer specifying the minimum row index of the ArraySequenceMatrix portion
     * @param maximumRowIndex
     *        integer specifying the maximum row index of the ArraySequenceMatrix portion
     */
    protected AbstractMatrixIterator(ArraySequenceMatrix<Element> matrix, int firstColumnIndex, int lastColumnIndex, int minimumRowIndex,
                             int maximumRowIndex) {
        super();

        this.matrix = matrix;

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.minimumRowIndex = minimumRowIndex;
        this.maximumRowIndex = maximumRowIndex;

        nextElementColumnIndex = firstColumnIndex;
        nextElementRowIndex = lastColumnIndex;
    }

    @Override
    public boolean hasNext() {
        return firstColumnIndex <= nextElementColumnIndex && nextElementColumnIndex <= lastColumnIndex &&
               minimumRowIndex <= nextElementRowIndex && nextElementRowIndex <= maximumRowIndex;
    }

    @Override
    public Element next() {
        if (!hasNext())
            throw new NoSuchElementException();

        Element element = matrix.get(nextElementColumnIndex, nextElementRowIndex);

        updateNextElementIndices();

        return element;
    }

    /**
     * Sets the column and row of this AbstractMatrixIterator to the column and row of
     * the next Element to be traversed.
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
     * Sets the column and row of this AbstractMatrixIterator to the column and row of
     * the next entity to be traversed.
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
