package org.jlib.container.matrix;

import java.util.Traverser;

/**
 * {@link Traverser} over a {@link Matrix}.
 * 
 * @param <Item>
 *        type of Items held in the matrix
 * 
 * @author Igor Akkerman
 */
public interface MatrixTraverser<Item>
extends Traverser<Item> {

    /**
     * Verifies whether the iteration has a next entity (like a row or column).
     * 
     * @return {@code true} if the iteration has a next entity; {@code false}
     *         otherwise
     */
    public boolean hasNextEntity();

    /**
     * Moves the cursor in front of the first Item of the next entity (like a
     * row or column), skipping the remaining items of the current entity.
     * 
     * @throws IllegalStateException
     *         if the cursor is located behind the last iterated Item of the
     *         {@link Matrix}
     */
    public void gotoNextEntity()
    throws IllegalStateException;
}
