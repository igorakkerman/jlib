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

/**
 * Column of an {@link IndexMatrix}.
 * 
 * @param <Entry>
 *        type of the elements in the IndexMatrix
 * 
 * @author Igor Akkerman
 */
class IndexMatrixColumn<Entry>
extends IndexMatrixEntity<Entry> {

    /**
     * Creates a new {@link IndexMatrixColumn} representation of the specified
     * row of the specified {@link IndexMatrix}.
     * 
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixColumn}
     * 
     * @param columnIndex
     *        integer specifying the index of this {@link IndexMatrixColumn}
     */
    protected IndexMatrixColumn(final IndexMatrix<Entry> matrix, final int columnIndex) {
        super(matrix, columnIndex);
    }

    /**
     * Returns the Entry stored at the specified row index in this
     * {@link IndexMatrixColumn}.
     * 
     * @return Entry stored at {@code rowIndex}
     */
    @Override
    protected Entry getStoredElement(final int rowIndex) {
        return getMatrixEntry(rowIndex, getEntityIndex());
    }
}
