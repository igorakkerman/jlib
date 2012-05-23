package org.jlib.container.sequence;

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
     * Returns the {@link SequenceIteratorState} switched to after a call to
     * {@link #replace(Object)}.
     * 
     * @return {@link ReplaceSequenceIteratorState} after a call to
     *         {@link #replace(Object)}
     */
    public ReplaceSequenceIteratorState<Element> getReplaceState();
}
