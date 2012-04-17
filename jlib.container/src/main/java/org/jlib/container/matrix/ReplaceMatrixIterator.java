package org.jlib.container.matrix;

import org.jlib.container.ReplaceContainerIterator;

/**
 * Iterator over the Entries of a {@link ReplaceMatrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link ReplaceMatrix}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceMatrixIterator<Entry>
extends MatrixIterator<Entry>, ReplaceContainerIterator<Entry> {
    // unifying interface
}
