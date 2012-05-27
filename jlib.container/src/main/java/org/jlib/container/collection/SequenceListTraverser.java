package org.jlib.container.collection;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;
import org.jlib.container.sequence.index.InsertIndexSequenceTraverser;

/**
 * {@link SequenceTraverser} that can be used as {@link ListTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceListTraverser<Item>
extends ReplaceIndexSequenceTraverser<Item>, InsertIndexSequenceTraverser<Item>, ListTraverser<Item> {
    // unifying interface
}
