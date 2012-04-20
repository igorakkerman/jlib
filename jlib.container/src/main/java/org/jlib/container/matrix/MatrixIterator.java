package org.jlib.container.matrix;

import java.util.Iterator;

/**
 * {@link Iterator} over a {@link Matrix}.
 * 
 * @param <Element>
 *        type of Elements held in the matrix
 * 
 * @author Igor Akkerman
 */
public interface MatrixIterator<Element>
extends Iterator<Element> {

    /**
     * Verifies whether the iteration has a next entity (like a row or column).
     * 
     * @return {@code true} if the iteration has a next entity; {@code false}
     *         otherwise
     */
    public boolean hasNextEntity();

    /**
     * Moves the cursor in front of the first Element of the next entity (like a
     * row or column), skipping the remaining elements of the current entity.
     * 
     * @throws IllegalStateException
     *         if the cursor is located behind the last iterated Element of the
     *         {@link Matrix}
     */
    public void gotoNextEntity()
    throws IllegalStateException;
}
