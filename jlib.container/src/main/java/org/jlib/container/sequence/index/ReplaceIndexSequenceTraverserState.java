package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.ReplaceSequenceTraverserState;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceTraverserState} referencing a {@link ReplaceSequence} .
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequenceTraverserState<Item>
extends IndexSequenceTraverserState<Item>, ReplaceSequenceTraverserState<Item> {
    // unifying interface
}
