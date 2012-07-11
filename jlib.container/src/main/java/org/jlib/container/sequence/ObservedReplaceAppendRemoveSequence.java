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

/**
 * {@link ReplaceSequence} and {@link AppendSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link ObservedReplaceAppendRemoveSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceAppendRemoveSequence<Item>
extends ObservedReplaceSequence<Item>, ObservedAppendSequence<Item>, ObservedRemoveSequence<Item> {

    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser();

    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser(ValueObserver<Item>... observers);
}
