package org.jlib.container.sequence.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InitializeableIndexSequenceCreator;

/**
 * {@link InitializeableIndexSequenceCreator} for {@link ReplaceArraySequence}
 * instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */

class ReplaceArraySequenceCreator<Element>
extends InitializeableIndexSequenceCreator<Element, ReplaceArraySequence<Element>> {

    /**
     * Creates a new {@link ReplaceArraySequenceCreator}.
     */
    protected ReplaceArraySequenceCreator() {
        super();
    }

    @Override
    public ReplaceArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new ReplaceArraySequence<Element>(firstIndex, lastIndex);
    }
}
