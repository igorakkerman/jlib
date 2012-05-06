package org.jlib.container.sequence.insert;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * State of an {@link InsertSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertSequenceIteratorState<Element>
extends SequenceIteratorState<Element>, InsertSequenceIterator<Element> {

    /**
     * Returns the {@link SequenceIteratorState} switched to after
     * {@link #insert(Object)}.
     * 
     * @return {@link InsertSequenceIteratorState} after {@link #insert(Object)}
     */
    public InsertSequenceIteratorState<Element> getInsertState();
}
