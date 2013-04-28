package org.jlib.container.sequence.index;


/**
 * {@link ReplaceInsertIndexSequenceTraverser},
 * {@link ObservedReplaceIndexSequenceTraverser} and
 * {@link ObservedInsertIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertIndexSequenceTraverser<Item>
extends ReplaceInsertIndexSequenceTraverser<Item>, ObservedReplaceIndexSequenceTraverser<Item>,
ObservedInsertIndexSequenceTraverser<Item> {
    // unifying interface
}
