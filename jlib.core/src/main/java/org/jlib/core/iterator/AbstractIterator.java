package org.jlib.core.iterator;

import java.util.Iterator;

/**
 * Skeletal implementation of an {@link Iterator}.
 * 
 * @param <Item>
 *        type of the items traversed by the {@link AbstractIterator}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIterator<Item>
implements Iterator<Item> {

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
