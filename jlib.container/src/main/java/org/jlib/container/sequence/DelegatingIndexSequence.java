package org.jlib.container.sequence;

/**
 * {@link AbstractDelegatingIndexSequence} implementation holding an instance of the
 * delegate {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DelegatingIndexSequence<Element>
extends AbstractDelegatingIndexSequence<Element>
implements Sequence<Element> {

    /**
     * {@link IndexSequence} containing the elements of this
     * {@link DelegatingIndexSequence}.
     */
    private IndexSequence<Element> delegateSequence;

    /**
     * Creates a new {@link DelegatingIndexSequence} for the specified initial
     * delegate {@link IndexSequence}.
     * 
     * @param delegateSequence
     *        initial delegate {@link IndexSequence} of this
     *        {@link DelegatingIndexSequence}
     */
    public DelegatingIndexSequence(final IndexSequence<Element> delegateSequence) {
        super();

        this.delegateSequence = delegateSequence;
    }


    @Override
    public IndexSequence<Element> getDelegateSequence() {
        return delegateSequence;
    }

    /**
     * Registers the delegate {@link IndexSequence}.
     *
     * @param delegateSequence delegate {@link IndexSequence}
     */
    public void setDelegateSequence(IndexSequence<Element> delegateSequence) {
        this.delegateSequence = delegateSequence;
    }
}
