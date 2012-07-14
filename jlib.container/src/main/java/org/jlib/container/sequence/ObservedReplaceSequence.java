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

import org.jlib.core.observer.ValueObserver;

import org.jlib.container.ObservedReplaceContainer;

/**
 * {@link ReplaceSequence} allowing its replace operations to be attended by
 * {@link ValueObserver} instances.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceSequence<Item>
extends ReplaceSequence<Item>, ObservedReplaceContainer<Item> {

    /**
     * {@inheritDoc}
     * 
     * @return {@link ObservedReplaceSequenceTraverser} traversing the Items of
     *         this {@link ObservedReplaceSequence}
     */
    @Override
    public ObservedReplaceSequenceTraverser<Item> createTraverser();
}
