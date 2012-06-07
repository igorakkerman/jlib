package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedReplaceSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} and {@link ObservedReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceIndexSequenceTraverser<Item>
extends IndexSequenceTraverser<Item>, ObservedReplaceSequenceTraverser<Item> {
    // unifying interface
}
