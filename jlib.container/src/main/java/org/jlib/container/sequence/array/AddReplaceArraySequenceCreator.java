package org.jlib.container.sequence.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InitializeableIndexSequenceCreator;

/**
 * {@link InitializeableIndexSequenceCreator} for
 * {@link AddReplaceArraySequence} instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
class AddReplaceArraySequenceCreator<Element>
extends InitializeableIndexSequenceCreator<Element, AddReplaceArraySequence<Element>> {

    /**
     * Creates a new {@link AddReplaceArraySequenceCreator}.
     */
    protected AddReplaceArraySequenceCreator() {
        super();
    }

    @Override
    public AddReplaceArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new AddReplaceArraySequence<Element>(firstIndex, lastIndex);
    }
}
