package org.jlib.container.matrix;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.Container;
import org.jlib.container.sequence.IndexSequence;

/**
 * Empty {@link Matrix}.
 *
 * @author Igor Akkerman
 * 
 * @param <Entry> type of entries of the {@link Matrix}
 */
public class EmptyMatrix<Entry> implements Matrix<Entry> {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(final Entry element) {
        return false;
    }

    @Override
    public boolean containsAll(final Container<? extends Entry> elements) {
        return false;
    }

    @Override
    public boolean containsAll(final Collection<? extends Entry> elements) {
        return false;
    }

    @Override
    public boolean containsAll(final Entry... elements) {
        return false;
    }

    @Override
    public Collection<Entry> toCollection() {
        return null;
    }

    @Override
    public Entry[] toArray() {
        return null;
    }

    @Override
    public Iterator<Entry> iterator() {
        return null;
    }

    @Override
    public IndexSequence<MatrixRow<Entry>> getRows() {
        return null;
    }

    @Override
    public IndexSequence<MatrixColumn<Entry>> getColumns() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public MatrixIterator<Entry> createIterator() {
        return null;
    }

    @Override
    public MatrixIterable<Entry> iteratedInOrder(final MatrixIterationOrder iterationOrder) {
        // the iteration order is void in an EmptyMatrix
        return this;
    }

    @Override
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder) {
        // the iteration order is void in an EmptyMatrix
    }

}
