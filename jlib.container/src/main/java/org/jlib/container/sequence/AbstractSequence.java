package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;

import org.jlib.container.AbstractContainer;
import org.jlib.core.traverser.BidirectionalTraverser;

/**
 * Skeletal implementation of a {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequence<Item>
extends AbstractContainer<Item>
implements Sequence<Item> {

    /**
     * Creates a new {@link AbstractSequence}.
     */
    public AbstractSequence() {
        super();
    }

    @Override
    public List<Item> toList() {
        final List<Item> sequence = new ArrayList<Item>(getItemsCount());
        for (final Item item : this)
            sequence.add(item);
        return sequence;
    }

    @Override
    public BidirectionalTraverser<Item> createBidirectionalTraverser() {
        return createSequenceTraverser();
    }
}
