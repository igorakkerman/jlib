package org.jlib.container;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * <p>
 * Container that allows its Items to be modified using an
 * {@link ReplaceTraverser}.
 * </p>
 * <p>
 * It does not necessarily allow modification of the {@link Container}, that is,
 * this interface does not provide methods for adding and removing Items. See
 * {@link AppendSequence} for this functionality.
 * </p>
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceContainer<Item>
extends Container<Item> {

    /**
     * Creates a new {@link ReplaceTraverser} over the Items of this {@link ReplaceContainer}
     * .
     * 
     * @return newly createTraverser}
     */
    public ReplaceTraverser<Item> createTraverser();
}
