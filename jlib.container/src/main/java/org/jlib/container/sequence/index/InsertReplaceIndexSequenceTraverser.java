package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AddSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceIndexSequenceTraverser} referencing an {@link AddSequence} .
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertReplaceIndexSequenceTraverser<Item>
extends ReplaceIndexSequenceTraverser<Item>, InsertIndexSequenceTraverser<Item> {
    // unifying interface
}
