package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedInsertSequenceTraverser;
import org.jlib.container.sequence.ObservedReplaceSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} and {@link ObservedReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertIndexSequenceTraverser<Item>
extends ObservedReplaceIndexSequenceTraverser<Item>, ReplaceInsertIndexSequenceTraverser<Item>,
ObservedInsertSequenceTraverser<Item> {
    // unifying interface
}
