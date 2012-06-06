package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedReplaceSequence;
import org.jlib.container.sequence.ObservedReplaceSequenceTraverser;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceTraverser} referencing an {@link ObservedReplaceSequence}
 * .
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceIndexSequenceTraverser<Item>
extends IndexSequenceTraverser<Item>, ObservedReplaceSequenceTraverser<Item> {
    // unifying interface
}
