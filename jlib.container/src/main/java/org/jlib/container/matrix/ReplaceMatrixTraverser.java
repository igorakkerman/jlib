package org.jlib.container.matrix;

import org.jlib.core.traverser.ReplaceTraverser;

/**
 * Traverser over the Entries of a {@link ReplaceMatrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link ReplaceMatrix}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceMatrixTraverser<Entry>
extends MatrixTraverser<Entry>, ReplaceTraverser<Entry> {
    // unifying interface
}
