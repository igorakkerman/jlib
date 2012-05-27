package org.jlib.container;

import org.jlib.container.sequence.AddSequence;
import org.jlib.container.sequence.Sequence;

/**
 * <p>
 * Container that allows its Items to be modified using an
 * {@link ReplaceContainerTraverser}.
 * </p>
 * <p>
 * It does not necessarily allow modification of the {@link Container}, that is,
 * this interface does not provide methods for adding and removing Items. See
 * {@link AddSequence} for this functionality.
 * </p>
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceContainer<Item>
extends Container<Item> {

    /**
     * Creates a new {@link ReplaceContainerTraverser} over this {@link ReplaceContainer}.
     * 
     * @return newly created {@link ReplaceContainerTraverser}
     */
    @Override
    public ReplaceContainerTraverser<Item> createTraverser();
}
