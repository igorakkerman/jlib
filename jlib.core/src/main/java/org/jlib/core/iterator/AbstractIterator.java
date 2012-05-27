package org.jlib.core.iterator;

import java.util.Traverser;

/**
 * Skeletal implementation of an {@link Traverser}.
 * 
 * @param <Item>
 *        type of the items traversed by the {@link AbstractTraverser}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractTraverser<Item>
implements Traverser<Item> {

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
