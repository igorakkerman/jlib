package org.jlib.container.sequence;

/**
 * {@link AbstractDelegatingReplaceIndexSequence} implementation holding an instance of the
 * delegate {@link ReplaceIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DelegatingReplaceIndexSequence<Element>
extends AbstractDelegatingReplaceIndexSequence<Element>
implements Sequence<Element> {

    /**
     * {@link ReplaceIndexSequence} containing the elements of this
     * {@link DelegatingReplaceIndexSequence}.
     */
    private ReplaceIndexSequence<Element> delegateSequence;

    /**
     * Creates a new {@link DelegatingReplaceIndexSequence} for the specified initial
     * delegate {@link ReplaceIndexSequence}.
     * 
     * @param delegateSequence
     *        initial delegate {@link ReplaceIndexSequence} of this
     *        {@link DelegatingReplaceIndexSequence}
     */
    public DelegatingReplaceIndexSequence(final ReplaceIndexSequence<Element> delegateSequence) {
        super();

        this.delegateSequence = delegateSequence;
    }


    @Override
    public ReplaceIndexSequence<Element> getDelegateSequence() {
        return delegateSequence;
    }

    /**
     * Registers the delegate {@link ReplaceIndexSequence}.
     *
     * @param delegateSequence delegate {@link ReplaceIndexSequence}
     */
    public void setDelegateSequence(ReplaceIndexSequence<Element> delegateSequence) {
        this.delegateSequence = delegateSequence;
    }
}
