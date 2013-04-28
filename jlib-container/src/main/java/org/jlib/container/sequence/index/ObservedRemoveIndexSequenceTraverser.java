package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedRemoveSequenceTraverser;

/**
 * {@link ObservedRemoveSequenceTraverser} and
 * {@link RemoveIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveIndexSequenceTraverser<Item>
extends ObservedRemoveSequenceTraverser<Item>, RemoveIndexSequenceTraverser<Item> {
    // unifying interface
}
