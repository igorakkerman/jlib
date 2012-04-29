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
 * Row of an {@link IndexMatrix}.
 * 
 * @param <Entry>
 *        type of the elements in the IndexMatrix
 * 
 * @author Igor Akkerman
 */
class IndexMatrixRow<Entry>
extends IndexMatrixEntity<Entry> {

    /**
     * Creates a new {@link IndexMatrixRow} representation of the specified row
     * of the specified {@link IndexMatrix}.
     * 
     * @param indexMatrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixRow}
     * 
     * @param rowIndex
     *        integer specifying the index of this {@link IndexMatrixRow}
     */
    IndexMatrixRow(final IndexMatrix<Entry> indexMatrix, final int rowIndex) {
        super(indexMatrix, rowIndex);
    }

    /**
     * Returns the Entry stored at the specified column index in this
     * {@link IndexMatrixRow}.
     * 
     * @return Entry stored at {@code columnIndex}
     */
    @Override
    protected Entry getStoredElement(final int columnIndex)
    throws IndexOutOfBoundsException {
        return getMatrixEntry(columnIndex, getEntityIndex());
    }
}
