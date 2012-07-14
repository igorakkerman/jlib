package org.jlib.core.traverser;

import java.util.Iterator;

/**
 * {@link RemoveTraverser} over an {@link Iterable}.
 * 
 * @param <Item>
 *        type of the items of the {@link Iterable}
 * 
 * @author Igor Akkerman
 */
public class RemoveIterableTraverser<Item>
extends IterableTraverser<Item>
implements RemoveTraverser<Item> {

    /** referenced {@link Traversible} in case of an error */
    private final Traversible<Item> traversible = new ConstantTraverserTraversible<>(this);

    /**
     * Creates a new {@link RemoveIterableTraverser} for the specified delegate
     * {@link Iterator}.
     * 
     * @param iterable
     *        {@link Iterable} to traverse
     */
    public RemoveIterableTraverser(final Iterable<Item> iterable) {
        super(iterable);
    }

    @Override
    public void remove()
    throws NoItemToRemoveException, IllegalTraversibleStateException {
        try {
            getDelegateIterator().remove();
        }
        catch (final IllegalStateException exception) {
            throw new NoItemToRemoveException(traversible, exception);
        }
        catch (final UnsupportedOperationException exception) {
            throw new IllegalTraversibleStateException(traversible, exception);
        }
    }

}
