package org.jlib.container.sequence.index;

import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.InsertSequenceIteratorState;
import org.jlib.container.sequence.ReplaceSequence;
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
public abstract class MiddleOfInsertReplaceIndexSequenceIteratorState<Element, Sequenze extends InsertSequence<Element> & ReplaceSequence<Element> & IndexSequence<Element>>
extends MiddleOfReplaceIndexSequenceIteratorState<Element, Sequenze>
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
}
