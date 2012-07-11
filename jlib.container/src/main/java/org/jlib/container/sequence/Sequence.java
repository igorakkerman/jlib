/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence;

import org.jlib.container.Container;
import org.jlib.core.traverser.TwoWayTraversible;

/**
 * Ordered sequence of Items.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface Sequence<Item>
extends Container<Item>, TwoWayTraversible<Item> {

    /**
     * Returns a {@link SequenceTraverser} traversing the Items of this Sequence
     * in the correct order.
     * 
     * @return {@link SequenceTraverser} over this Sequence
     */
    @Override
    public SequenceTraverser<Item> createTraverser();
}
