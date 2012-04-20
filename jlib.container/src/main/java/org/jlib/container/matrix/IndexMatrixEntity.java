package org.jlib.container.matrix;

import org.jlib.container.sequence.AbstractNonEmptyIndexSequence;

/**
 * Entity of an {@link IndexMatrix} like a column or row.
 * 
 * @param <Entry>
 *        type of the entries of the {@link IndexMatrix}
 *        
 * @author Igor Akkerman
 */
abstract class IndexMatrixEntity<Entry>
extends AbstractNonEmptyIndexSequence<Entry> {

    /** {@link IndexMatrix} owning this {@link IndexMatrixEntity} */
    private final IndexMatrix<Entry> matrix;

    /** index of this {@link IndexMatrixEntity} */
    private final int entityIndex;

    /**
     * Creates a new {@link IndexMatrixEntity} representation of the specified entity
     * of the specified {@link IndexMatrix}.
     * 
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixEntity}
     * 
     * @param entityIndex
     *        integer specifying the index of this {@link IndexMatrixEntity}
     */
    protected IndexMatrixEntity(final IndexMatrix<Entry> matrix, final int entityIndex) {
        super(matrix.getFirstRowIndex(), matrix.getLastRowIndex());

        this.matrix = matrix;
        this.entityIndex = entityIndex;
    }
    
    /**
     * Returns the {@link IndexMatrix} owning this {@link IndexMatrixEntity}.
     *
     * @return {@link IndexMatrix} owning this {@link IndexMatrixEntity}
     */
    protected IndexMatrix<Entry> getMatrix() {
        return matrix;
    }
    
    /**
     * Returns the index of this {@link IndexMatrixEntity}.
     *
     * @return integer specifying the index of this {@link IndexMatrixEntity}
     */
    protected int getEntityIndex() {
        return entityIndex;
    }
}
