package org.jlib.container;

import java.util.Iterator;

/**
 * {@link Traverser} over the Items of a {@link Traversible}.
 * 
 * @param <Item>
 *        type of items of the {@link Traversible}
 * 
 * @param <Travble>
 *        type of the traversed {@link Traversible}
 * 
 * @author Igor Akkerman
 */
public class TraversibleIterator<Item, Travble extends Traversible<Item>>
implements Iterator<Item> {

    /** delegate {@link Traverser} */
    private final Traverser<Item> delegateTraverser;

    /**
     * Creates a new {@link TraversibleIterator}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    public TraversibleIterator(final Travble traversible) {
        super();

        delegateTraverser = traversible.createTraverser();
    }

    @Override
    public boolean hasNext() {
        return delegateTraverser.hasNext();
    }

    @Override
    public Item next() {
        return delegateTraverser.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
