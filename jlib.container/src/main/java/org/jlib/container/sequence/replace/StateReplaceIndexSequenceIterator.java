package org.jlib.container.sequence.replace;

import org.jlib.container.sequence.index.StateIndexSequenceIterator;

/**
 * 
 * 
 * @author Igor Akkerman
 */
public class StateReplaceIndexSequenceIterator<Element>
extends StateIndexSequenceIterator<Element>
implements ReplaceIndexSequenceIterator<Element> {

    private ReplaceIndexSequence<Element> sequence;

    /**
     * Creates a new {@link StateReplaceIndexSequenceIterator}.
     */
    public StateReplaceIndexSequenceIterator(final ReplaceIndexSequence<Element> sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    /**
     * Creates a new {@link StateReplaceIndexSequenceIterator}.
     */
    public StateReplaceIndexSequenceIterator(final ReplaceIndexSequence<Element> sequence, final int startIndex) {
        super(sequence, startIndex);
    }

    @Override
    public void replace(final Element element)
    throws IllegalStateException {
        currentState.replace(element);
    }

    ReplaceIndexSequence<Element> getSequence() {
        return sequence;
    }
}
