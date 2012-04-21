package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Non-empty {@link ReplaceIndexSequence} backed by an {@link ArrayList}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
class NonEmptyArraySequence<Element>
extends AbstractNonEmptyIndexSequence<Element>
implements Cloneable {

    /** delegate {@link List} of this {@link ArraySequence} */
    private final List<Element> delegateList;

    /**
     * Creates a new {@link NonEmptyArraySequence} with the specified
     * minimum and maximum indices initialized with {@code null} values.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this
     *        {@link NonEmptyArraySequence}
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this
     *        {@link NonEmptyArraySequence}
     */
    @SuppressWarnings("javadoc")
    public NonEmptyArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);

        delegateList = new ArrayList<Element>(getSize());
        for (int index = firstIndex; index <= lastIndex; index ++)
            delegateList.add(null);
    }

    /**
     * Creates a new NonEmptyArraySequence.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this
     *        NonEmptyArraySequence
     * 
     * @param elements
     *        Elements added to this NonEmptyArraySequence
     */
    private NonEmptyArraySequence(final int firstIndex, final List<Element> elements) {
        super(firstIndex, firstIndex + elements.size() - 1);

        delegateList = new ArrayList<Element>(elements);
    }

    // @see org.jlib.container.sequence.IndexSequence#get(int)
    @Override
    public Element get(final int index)
    throws SequenceIndexOutOfBoundsException {
        if (index < firstIndex || index > lastIndex)
            throw new SequenceIndexOutOfBoundsException(this, index);

        return delegateList.get(index - firstIndex);
    }

    @Override
    // overridden for efficiency
    public boolean contains(final Element element) {
        return delegateList.contains(element);
    }

    // @see org.jlib.container.AbstractContainer#containsAll(Container)
    // overridden for efficiency
    @Override
    public boolean containsAll(final Collection<? extends Element> collection) {
        return delegateList.containsAll(collection);
    }

    // @see java.lang.Object#clone()
    @Override
    public NonEmptyArraySequence<Element> clone() {
        return new NonEmptyArraySequence<Element>(firstIndex, delegateList);
    }

    // @see org.jlib.container.sequence.IndexSequence#equals(java.lang.Object)
    @Override
    public boolean equals(final Object otherObject) {
        if (!(otherObject instanceof ArraySequence.NonEmptyArraySequence<?>))
            return false;
        
        final ArraySequence.NonEmptyArraySequence<?> otherArray = (ArraySequence.NonEmptyArraySequence<?>) otherObject;
        return firstIndex == otherArray.firstIndex && lastIndex == otherArray.lastIndex &&
               delegateList.equals(otherArray.delegateList);
    }

    // @see org.jlib.container.AbstractContainer#hashCode()
    @Override
    public int hashCode() {
        return 3 * firstIndex + 5 * lastIndex + delegateList.hashCode();
    }
}