package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.InsertSequenceIteratorState;
import org.jlib.container.sequence.Sequence;

/**
 * {@link MiddleOfIndexSequenceIteratorState} of a
 * {@link ReplaceIndexSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfInsertReplaceIndexSequenceIteratorState<Element>
extends MiddleOfReplaceIndexSequenceIteratorState<Element>
implements InsertSequenceIteratorState<Element> {

    /**
     * Creates a new {@link MiddleOfInsertReplaceIndexSequenceIteratorState}.
     */
    public MiddleOfInsertReplaceIndexSequenceIteratorState() {
        super();
    }

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getReplacedState() {
        return this;
    }

    public <Sequenze extends ReplaceIndexSequence<Element> & InsertSequence<Element>> Sequenze getSequence() {
        return null;
    }
}
