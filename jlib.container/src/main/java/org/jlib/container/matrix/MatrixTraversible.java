package org.jlib.container.matrix;

/**
 * {@link Iterable} providing a {@link MatrixTraverser} traversing the Items
 * of a {@link Matrix}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Matrix}.
 * 
 * @author Igor Akkerman
 */
public interface MatrixTraversible<Item>
extends Iterable<Item> {

    /**
     * Returns a new {@link MatrixTraverser} traversing the Entries of this
     * {@link MatrixTraversible}.
     * 
     * @return {@link MatrixTraverser} over this {@link MatrixTraversible}
     */
    public MatrixTraverser<Item> createTraverser();
}
