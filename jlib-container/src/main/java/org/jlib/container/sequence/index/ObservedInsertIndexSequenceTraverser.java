package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedInsertSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} and {@link ObservedInsertSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ObservedInsertIndexSequenceTraverser<Item>
extends ObservedInsertSequenceTraverser<Item>, InsertIndexSequenceTraverser<Item> {
    // unifying interface
}
