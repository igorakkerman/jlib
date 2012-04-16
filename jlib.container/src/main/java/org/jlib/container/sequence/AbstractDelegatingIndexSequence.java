package org.jlib.container.sequence;

import java.util.List;

/**
 * {@link Sequence} delegating all calls to its methods to the equivalent
 * methods of a delegate {@link IndexSequence}. The delegate {@link Sequence}
 * may be modified at any time allowing to dynamically switch to the contents
 * and the behaviour of another {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractDelegatingIndexSequence<Element>
extends AbstractDelegatingSequence<Element>
implements IndexSequence<Element> {

    /**
     * Creates a new {@link AbstractDelegatingIndexSequence}.
     */
    protected AbstractDelegatingIndexSequence() {
        super();
    }

    /**
     * Returns the {@link IndexSequence} containing the {@code Elements} of this
     * {@link AbstractDelegatingIndexSequence}.
     * 
     * @return the delegate {@link IndexSequence}
     */
    @Override
    protected abstract IndexSequence<Element> getDelegateSequence();


    @Override
    public Element get(int index)
    throws SequenceIndexOutOfBoundsException {
        return getDelegateSequence().get(index);
    }


    @Override
    public int getMinimumIndex() {
        return getDelegateSequence().getMinimumIndex();
    }


    @Override
    public int getMaximumIndex() {
        return getDelegateSequence().getMaximumIndex();
    }


    @Override
    public int indexOf(final Element element) {
        return getDelegateSequence().indexOf(element);
    }


    @Override
    public int lastIndexOf(final Element element) {
        return getDelegateSequence().lastIndexOf(element);
    }


    @Override
    public List<Element> subList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        return getDelegateSequence().subList(fromIndex, toIndex);
    }


    @Override
    public IndexSequence<Element> subSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        return getDelegateSequence().subSequence(fromIndex, toIndex);
    }

    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return getDelegateSequence().createIterator();
    }

    @Override
    public IndexSequenceIterator<Element> createIterator(int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return getDelegateSequence().createIterator(startIndex);
    }
}
