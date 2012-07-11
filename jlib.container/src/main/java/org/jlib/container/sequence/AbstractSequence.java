package org.jlib.container.sequence;

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
}
