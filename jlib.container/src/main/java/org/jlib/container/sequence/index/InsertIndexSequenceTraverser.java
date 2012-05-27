package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;

/**
 * {@link SequenceTraverser} over the items of an {@link InsertIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertIndexSequenceTraverser<Item>
extends InsertSequenceTraverser<Item>, IndexSequenceTraverser<Item> {
    // unifying interface to satisfy the Eclipse compiler
}
