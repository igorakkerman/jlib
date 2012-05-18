package org.jlib.container.sequence.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequenceCreator;
import org.jlib.container.sequence.index.InitializeableIndexSequenceCreator;

/**
 * {@link InitializeableIndexSequenceCreator} for {@link ArraySequence}
 * instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */

class ArraySequenceCreator
implements IndexSequenceCreator<ArraySequence<?>> {

    /**
     * Creates a new {@link ArraySequenceCreator}.
     */
    ArraySequenceCreator() {
        super();
    }
}
