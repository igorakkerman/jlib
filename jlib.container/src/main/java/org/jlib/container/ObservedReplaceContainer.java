package org.jlib.container;

import org.jlib.core.traverser.ObservedReplaceTraverser;

import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceContainer} traversed by an {@link ObservedReplaceContainer}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceContainer<Item>
extends ReplaceContainer<Item> {

    /**
     * {@inheritDoc}
     * 
     * @return {@link ObservedReplaceTraverser} traversing the Items of this
     *         {@link ObservedReplaceContainer}
     */
    @Override
    public ObservedReplaceTraverser<Item> createTraverser();
}
