package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.ReplaceSequenceTraverser;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceTraverser} referencing a {@link ReplaceSequence} .
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequenceTraverser<Item>
extends IndexSequenceTraverser<Item>, ReplaceSequenceTraverser<Item> {
    // unifying interface
}
