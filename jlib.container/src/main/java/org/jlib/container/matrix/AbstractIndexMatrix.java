package org.jlib.container.matrix;

import org.jlib.container.sequence.AbstractIndexSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;

/**
 * Skeletal implementation of an {@link IndexMatrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link IndexMatrix}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexMatrix<Entry>
extends AbstractMatrix<Entry>
implements IndexMatrix<Entry> {

    @Override
    public Sequence<? extends IndexMatrixColumn<Entry>> getColumns() {
        return new AbstractIndexSequence<IndexMatrixColumn<Entry>>() {

            @Override
            public IndexMatrixColumn<Entry> get(final int columnIndex)
            throws SequenceIndexOutOfBoundsException {
                return getColumn(columnIndex);
            }

            @Override
            public int getFirstIndex() {
                return getFirstColumnIndex();
            }

            @Override
            public int getLastIndex() {
                return getLastColumnIndex();
            }
        };
    }

    @Override
    public Sequence<? extends IndexMatrixRow<Entry>> getRows() {
        return new AbstractIndexSequence<IndexMatrixRow<Entry>>() {

            @Override
            public IndexMatrixRow<Entry> get(final int rowIndex)
            throws SequenceIndexOutOfBoundsException {
                return getRow(rowIndex);
            }

            @Override
            public int getFirstIndex() {
                return getFirstRowIndex();
            }

            @Override
            public int getLastIndex() {
                return getLastRowIndex();
            }
        };
    }

}
