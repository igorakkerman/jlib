package org.jlib.container.sequence;

/**
 * {@link AbstractDelegatingSequence} implementation holding an instance of the
 * delegate {@link Sequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DelegatingSequence<Element>
extends AbstractDelegatingSequence<Element>
implements Sequence<Element> {

    /**
     * {@link Sequence} containing the elements of this
     * {@link DelegatingSequence}.
     */
    private Sequence<Element> delegateSequence;

    /**
     * Creates a new {@link DelegatingSequence} for the specified initial
     * delegate {@link Sequence}.
     * 
     * @param delegateSequence
     *        initial delegate {@link Sequence} of this
     *        {@link DelegatingSequence}
     */
    public DelegatingSequence(final Sequence<Element> delegateSequence) {
        super();

        this.delegateSequence = delegateSequence;
    }


    @Override
    public Sequence<Element> getDelegateSequence() {
        return delegateSequence;
    }

    /**
     * Registers the delegate {@link Sequence}.
     *
     * @param delegateSequence delegate {@link Sequence}
     */
    public void setDelegateSequence(final Sequence<Element> delegateSequence) {
        this.delegateSequence = delegateSequence;
    }
}
