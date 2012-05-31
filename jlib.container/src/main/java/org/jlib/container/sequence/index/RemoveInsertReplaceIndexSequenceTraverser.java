package org.jlib.container.sequence.index;

import org.jlib.container.sequence.RemoveSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link InsertReplaceIndexSequenceTraverser} referencing a
 * {@link RemoveSequence} .
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveInsertReplaceIndexSequenceTraverser<Item>
extends InsertReplaceIndexSequenceTraverser<Item>, RemoveIndexSequenceTraverser<Item> {
    // unifying interface
}
