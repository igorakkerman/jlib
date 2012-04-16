package org.jlib.container.matrix;

/**
 * {@link Iterable} providing a {@link MatrixIterator} traversing the Elements
 * of a {@link Matrix}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Matrix}.
 * 
 * @author Igor Akkerman
 */
public interface MatrixIterable<Element>
extends Iterable<Element> {

    @Override
    public MatrixIterator<Element> iterator();
}
