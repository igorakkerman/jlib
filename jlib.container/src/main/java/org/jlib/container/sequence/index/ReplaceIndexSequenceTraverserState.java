package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequenceTraverserState;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceTraverserState} of a {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
// @formatter:off
public abstract class ReplaceIndexSequenceTraverserState<Item>
extends IndexSequenceTraverserState<Item>, ReplaceSequenceTraverserState<Item>,
        ReplaceIndexSequenceTraverser<Item> {
// @formatter:on

    @Override
    public abstract ReplaceIndexSequenceTraverserState<Item> getNextState();

    @Override
    public abstract ReplaceIndexSequenceTraverserState<Item> getPreviousState();

    @Override
    public abstract ReplaceIndexSequenceTraverserState<Item> getReplacedState();
}
