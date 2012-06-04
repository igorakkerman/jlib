package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceIndexSequenceTraverser} referencing an {@link AppendSequence} .
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertIndexSequenceTraverser<Item>
extends ReplaceIndexSequenceTraverser<Item>, InsertIndexSequenceTraverser<Item> {
    // unifying interface
}
