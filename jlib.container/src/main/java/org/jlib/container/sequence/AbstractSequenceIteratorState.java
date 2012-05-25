package org.jlib.container.sequence;

/**
 * Skeletal implementation of a {@link SequenceIteratorState}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceIteratorState<Element, Sequenze extends Sequence<Element>>
extends AbstractSequenceIterator<Element, Sequenze>
implements SequenceIteratorState<Element> {

    // unifying class

    /**
     * Creates a new {@link AbstractSequenceIteratorState}.
     */
    public AbstractSequenceIteratorState() {
        super();
    }
}
