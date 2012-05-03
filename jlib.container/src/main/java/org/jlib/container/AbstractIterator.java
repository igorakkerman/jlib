package org.jlib.container;

import java.util.Iterator;

/**
 * Skeletal implementation of an {@link Iterator} over the Elements of a
 * {@link Container}.
 * 
 * @param <Element>
 *        type of the elements of the {@link Container}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIterator<Element>
implements Iterator<Element> {

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
