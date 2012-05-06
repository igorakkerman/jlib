package org.jlib.container.sequence.replace;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * State of a {@link ReplaceSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceSequenceIteratorState<Element>
extends SequenceIteratorState<Element>, ReplaceSequenceIterator<Element> {

    /**
     * Returns the {@link SequenceIteratorState} switched to after
     * {@link #replace(Object)}.
     * 
     * @return {@link ReplaceSequenceIteratorState} after {@link #next()}
     */
    public ReplaceSequenceIteratorState<Element> getReplaceState();
}
