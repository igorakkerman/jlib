package org.jlib.container.sequence;

/**
 * Skeletal implementation of an {@link IndexSequence} that can be initialized.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class InitializeableIndexSequence<Element>
extends AbstractIndexSequence<Element> {

    /**
     * Creates a new {@link InitializeableIndexSequence}.
     * 
     * @param firstIndex
     *        integer specifying the initial minimum index of this IIS
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this ArraySequence
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code  lastIndex < firstIndex}
     */
    public InitializeableIndexSequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Replaces the Element stored at the specified index in this
     * {@link InitializeableIndexSequence} by the specified Element.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param element
     *        Element to store
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    protected void replace(final int index, final Element element)
    throws SequenceIndexOutOfBoundsException {
        assertIndexValid(index);

        replaceStoredElement(index, element);
    }

    /**
     * Replaces the Element stored at the specified index in this
     * {@link InitializeableIndexSequence} by the specified Element expecting
     * the index to be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @param element
     *        Element to store
     */
    protected abstract void replaceStoredElement(final int index, final Element element);

}
