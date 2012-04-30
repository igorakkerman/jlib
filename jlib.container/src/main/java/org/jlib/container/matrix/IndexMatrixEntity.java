package org.jlib.container.matrix;

import org.jlib.container.sequence.AbstractIndexSequence;

/**
 * Entity of an {@link IndexMatrix} like a column or row.
 * 
 * @param <Entry>
 *        type of the entries of the {@link IndexMatrix}
 * 
 * @author Igor Akkerman
 */
abstract class IndexMatrixEntity<Entry>
extends AbstractIndexSequence<Entry> {

    /** {@link IndexMatrix} owning this {@link IndexMatrixEntity} */
    private final IndexMatrix<Entry> matrix;

    /** index of this {@link IndexMatrixEntity} */
    private final int entityIndex;

    /**
     * Creates a new {@link IndexMatrixEntity} representation of the specified
     * entity of the specified {@link IndexMatrix}.
     * 
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixEntity}
     * 
     * @param entityIndex
     *        integer specifying the index of this {@link IndexMatrixEntity}
     */
    protected IndexMatrixEntity(final IndexMatrix<Entry> matrix, final int entityIndex) {
        this(matrix, entityIndex, matrix.getFirstRowIndex(), matrix.getLastRowIndex());
    }

    /**
     * Creates a new {@link IndexMatrixEntity} representation of the specified
     * part of the specified entity of the specified {@link IndexMatrix}.
     * 
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixEntity}
     * 
     * @param entityIndex
     *        integer specifying the index of this {@link IndexMatrixEntity}
     * 
     * @param firstEntityEntryIndex
     *        integer specifying the first index of the entity part
     * 
     * @param lastEntityEntryIndex
     *        integer specifying the last index of the entity part
     */
    protected IndexMatrixEntity(final IndexMatrix<Entry> matrix, final int entityIndex,
                                final int firstEntityEntryIndex, final int lastEntityEntryIndex) {
        super(firstEntityEntryIndex, lastEntityEntryIndex);

        this.matrix = matrix;
        this.entityIndex = entityIndex;
    }

    /**
     * Returns the specified Entry of the {@link IndexMatrix} owning this
     * {@link IndexMatrixEntity}.
     * 
     * @param columnIndex
     *        integer specifying the column index
     * 
     * @param rowIndex
     *        integer specifying the row index
     * 
     * @return Entry stored at the specified {@code columnIndex} and
     *         {@code rowIndex}
     */
    protected Entry getMatrixEntry(final int columnIndex, final int rowIndex) {
        return matrix.get(columnIndex, rowIndex);
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
