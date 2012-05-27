package org.jlib.container.matrix;

import org.jlib.container.ReplaceContainerTraverser;

/**
 * Traverser over the Entries of a {@link ReplaceMatrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link ReplaceMatrix}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceMatrixTraverser<Entry>
extends MatrixTraverser<Entry>, ReplaceContainerTraverser<Entry> {
    // unifying interface
}
