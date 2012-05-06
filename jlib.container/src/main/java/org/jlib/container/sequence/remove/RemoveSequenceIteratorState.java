package org.jlib.container.sequence.remove;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * State of a {@link RemoveSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveSequenceIteratorState<Element>
extends SequenceIteratorState<Element>, RemoveSequenceIterator<Element> {

    /**
     * Returns the {@link SequenceIteratorState} switched to after
     * {@link #remove()}.
     * 
     * @return {@link RemoveSequenceIteratorState} after {@link #remove()}
     */
    public RemoveSequenceIteratorState<Element> getRemoveState();
}
