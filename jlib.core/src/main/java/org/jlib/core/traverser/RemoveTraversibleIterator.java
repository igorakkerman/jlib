package org.jlib.core.traverser;

import java.util.Iterator;

/**
 * {@link Iterator} over the Items of a {@link RemoveTraversible}.
 * 
 * @param <Item>
 *        type of Items of the {@link RemoveTraversible}
 * 
 * @param <Travble>
 *        type of the traversed {@link RemoveTraversible}
 * 
 * @author Igor Akkerman
 */
public class RemoveTraversibleIterator<Item, Travble extends RemoveTraversible<Item>>
extends TraversibleIterator<Item, Travble> {

    /** delegate {@link RemoveTraverser} */
    private RemoveTraverser<Item> delegateTraverser;

    /**
     * Creates a new {@link RemoveTraversibleIterator}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    public RemoveTraversibleIterator(final Travble traversible) {
        super(traversible);
    }

    /**
     * <p>
     * Registers the specified {@link RemoveTraverser} as delegate for this
     * {@link RemoveTraversibleIterator}.
     * </p>
     * <p>
     * Subclasses must re-implement (not override!) this method registering the
     * concrete {@link RemoveTraverser} in a property of the concrete type AND
     * calling THIS method using {@code super.setTraverser(delegateTraverser)}.
     * </p>
     * 
     * @param delegateTraverser
     *        delegate {@link Traverser}
     */
    protected void setTraverser(final RemoveTraverser<Item> delegateTraverser) {
        super.setTraverser(delegateTraverser);

        this.delegateTraverser = delegateTraverser;
    }

    @Override
    protected void createTraverser(final Travble traversible) {
        setTraverser(traversible.createTraverser());
    }

    @Override
    public void remove() {
        delegateTraverser.remove();
    }
}
