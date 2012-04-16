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
     * Moves the cursor in front of the first Element of the next entity (like a
     * row or column), skipping the remaining elements of the current entity.
     * 
     * @throws IllegalStateException
     *         if the cursor is located behind the last Element of the
     *         {@link Matrix}
     */
    public void nextEntity()
    throws IllegalStateException;
}
