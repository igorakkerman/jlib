package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;

import org.jlib.container.AbstractContainer;

/**
 * Skeletal implementation of a {@link Sequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequence<Element>
extends AbstractContainer<Element>
implements Sequence<Element> {

    /**
     * Creates a new {@link AbstractSequence}.
     */
    public AbstractSequence() {
        super();
    }

    @Override
    public List<Element> toCollection() {
        return toList();
    }

    @Override
    public List<Element> toList() {
        final List<Element> sequence = new ArrayList<Element>(getSize());
        for (final Element element : this)
            sequence.add(element);
        return sequence;
    }
}
