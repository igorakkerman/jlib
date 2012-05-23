package org.jlib.container.sequence.insert;

import org.jlib.container.Container;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;
import org.jlib.container.sequence.index.array.AddReplaceArraySequence;

import static org.jlib.container.sequence.SequenceUtility.singleton;

/**
 * {@link AddReplaceArraySequence} into which Elements can be inserted.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class InsertAddReplaceArraySequence<Element>
extends AddReplaceArraySequence<Element>
implements InsertIndexSequence<Element> {

    /**
     * Creates a new {@link InsertAddReplaceArraySequence} with the specified
     * first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @throws IllegalArgumentException
     *         if {@code lastIndex > firstIndex}
     */
    protected InsertAddReplaceArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void insert(final int index, final Element element) {
        insert(index, singleton(element));
    }

    @Override
    public void insert(final int index, final Container<? extends Element> elements) {
        final int insertedElementsCount = elements.getSize();

        final int newSize = getSize() + insertedElementsCount;
        final int delegateArrayInsertIndex = getDelegateArrayIndex(index);

        assertCapacityWithHole(newSize, delegateArrayInsertIndex, insertedElementsCount);

        int delegateArrayIndex = delegateArrayInsertIndex;
        for (final Element element : elements)
            replaceDelegateArrayElement(delegateArrayIndex ++, element);

        setLastIndex(getLastIndex() + insertedElementsCount);
    }

    @Override
    public InsertReplaceIndexSequenceIterator<Element> createIterator() {
        return createIterator(getFirstIndex());
    }

    @Override
    public InsertReplaceIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultInsertReplaceIndexSequenceIterator<Element>(this, startIndex);
    }
}
