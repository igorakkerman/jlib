/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.matrix;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

import org.jlib.container.sequence.index.AbstractIndexSequence;

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
    protected IndexMatrixEntity(final IndexMatrix<Entry> matrix, final int entityIndex, final int firstEntityEntryIndex, final int lastEntityEntryIndex) {
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

    public boolean contains(final Entry entry)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    public boolean contains(final TraversableContainer<? extends Entry> entries)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    public boolean contains(final Collection<? extends Entry> entries)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    @SafeVarargs
    public final boolean contains(final Entry... entries)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return false;
    }

    @Override
    public boolean containsEqualItems(final TraversableContainer<Entry> otherContainer) {
        return false;
    }

    @Override
    public Iterator<Entry> iterator() {
        return null;
    }
}
