package org.jlib.container.matrix;

import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;

/**
 * {@link IndexMatrix} allowing the replacement of entries.
 * 
 * @param <Entry>
 *        type of the entries of the {@link ReplaceIndexMatrix}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceIndexMatrix<Entry>
extends IndexMatrix<Entry> {

    /**
     * Registers the Element to store at the specified column and row in this
     * ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the Element to store
     * 
     * @param rowIndex
     *        integer specifying the row of the Element to store
     * 
     * @param entry
     *        Element to store.
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextint < getMinint() ||
     *         nextint > getMaxint() || nextint <
     *         getMinint || nextint > getMaxint()}
     */
    public void replace(final int columnIndex, final int rowIndex, final Entry entry);
}
