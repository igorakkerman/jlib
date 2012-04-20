package org.jlib.container.matrix;

import org.jlib.container.ReplaceContainer;

/**
 * {@link Matrix} that allows replacement of its Entries.
 * 
 * @param <Entry>
 *        type of the Entries of the {@link ReplaceMatrix}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceMatrix<Entry>
extends Matrix<Entry>, ReplaceContainer<Entry> {

    @Override
    public ReplaceMatrixIterator<Entry> createIterator();
}
