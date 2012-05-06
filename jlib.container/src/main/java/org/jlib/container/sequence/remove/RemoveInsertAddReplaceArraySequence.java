package org.jlib.container.sequence.remove;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.add.AddReplaceArraySequence;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;
import org.jlib.container.sequence.insert.InsertAddReplaceArraySequence;

/**
 * {@link AddReplaceArraySequence} into which Elements can be inserted.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class RemoveInsertAddReplaceArraySequence<Element>
extends InsertAddReplaceArraySequence<Element>
implements RemoveIndexSequence<Element> {

    /**
     * Creates a new {@link RemoveInsertAddReplaceArraySequence} with the
     * specified first and last indices.
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
    protected RemoveInsertAddReplaceArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public RemoveInsertReplaceIndexSequenceIterator<Element> createIterator() {
        return createIterator(getFirstIndex());
    }

    @Override
    public RemoveInsertReplaceIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultRemoveInsertReplaceIndexSequenceIterator<Element>(this, startIndex);
    }

    @Override
    public void remove(final Element element)
    throws IllegalArgumentException {}

    @Override
    public void removeAll() {}

    @Override
    public void removeAll(final Container<? extends Element> elements) {}

    @Override
    public void removeAll(final Collection<? extends Element> elements) {}

    @Override
    public void removeAll(final Iterable<? extends Element> elements) {}

    @Override
    public void removeAll(final Element... elements) {}

    @Override
    public void retainAll(final Container<? extends Element> elements) {}

    @Override
    public void retainAll(final Collection<? extends Element> elements) {}

    @Override
    public void retainAll(final Element... elements) {}

    @Override
    public void remove(final int index) {}
}
