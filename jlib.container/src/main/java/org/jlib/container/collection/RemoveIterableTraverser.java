package org.jlib.container.collection;

import java.util.Iterator;

import org.jlib.container.RemoveTraverser;
import org.jlib.container.Traverser;

/**
 * {@link Traverser} over an {@link Iterable}.
 * 
 * @param <Item>
 *        type of the items of the {@link Iterable}
 * 
 * @author Igor Akkerman
 */
public class RemoveIterableTraverser<Item>
extends IterableTraverser<Item>
implements RemoveTraverser<Item> {

    /**
     * Creates a new {@link RemoveIterableTraverser} over the Items of the
     * specified {@link Iterable}.
     * 
     * @param iterable
     *        traversed {@link Iterable}
     */
    public RemoveIterableTraverser(final Iterable<Item> iterable) {
        super(iterable);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws UnsupportedOperationException
     *         if the {@link Iterator} provided by the specified
     *         {@link Iterable} throws an {@link UnsupportedOperationException}
     */
    @Override
    public void remove()
    throws UnsupportedOperationException {
        getDelegateIterator().remove();
    }
}
