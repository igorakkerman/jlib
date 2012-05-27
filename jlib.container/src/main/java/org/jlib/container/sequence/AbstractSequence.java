package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;

import org.jlib.container.AbstractContainer;

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
    public List<Item> toCollection() {
        return toList();
    }

    @Override
    public List<Item> toList() {
        final List<Item> sequence = new ArrayList<Item>(getSize());
        for (final Item item : this)
            sequence.add(item);
        return sequence;
    }
}
