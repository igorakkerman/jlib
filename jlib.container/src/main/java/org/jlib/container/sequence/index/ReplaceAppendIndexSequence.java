package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceIndexSequence} and {@link AppendSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceAppendIndexSequence<Item>
extends ReplaceIndexSequence<Item>, AppendSequence<Item> {
    // unifying interface
}
