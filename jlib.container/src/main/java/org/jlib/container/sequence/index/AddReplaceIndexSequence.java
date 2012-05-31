package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AddSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceIndexSequence} and {@link AddSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface AddReplaceIndexSequence<Item>
extends ReplaceIndexSequence<Item>, AddSequence<Item> {

}
