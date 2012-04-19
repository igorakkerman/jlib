package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Skeletal implementation of an {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequence<Element>
extends AbstractSequence<Element>
implements IndexSequence<Element> {

    /**
     * Creates a new {@link AbstractIndexSequence}.
     */
    public AbstractIndexSequence() {
        super();
    }

    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return new DefaultIndexSequenceIterator<>(this);
    }

    @Override
    public IndexSequenceIterator<Element> createIterator(int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultIndexSequenceIterator<>(this, startIndex);
    }

    @Override
    public int getFirstIndexOf(final Element element) throws NoSuchElementException {
        int lastIndex = getLastIndex();
        
        for (int index = getFirstIndex(); index <= lastIndex; index ++)
            if (get(index).equals(element))
                return index;
        
        throw new NoSuchElementException(element.toString());
    }

    @Override
    public int getLastIndexOf(final Element element) throws NoSuchElementException {
        int firstIndex = getFirstIndex();
        
        for (int index = getLastIndex(); index >= firstIndex; index --)
            if (get(index).equals(element))
                return index;
        
        throw new NoSuchElementException(element.toString());
    }
    
    @Override
    public IndexSequence<Element> createSubSequence(int fromIndex, int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        final ReplaceIndexSequence<Element> subSequence = new ArraySequence<>(toIndex - fromIndex + 1);
        
        for (int index = fromIndex; index <= toIndex; index ++)
            subSequence.replace(index, get(index));
        
        return subSequence;
    }
    
    @Override
    public List<Element> createSubList(int fromIndex, int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        final List<Element> subList = new ArrayList<Element>(toIndex - fromIndex + 1);
        
        for (int index = fromIndex; index <= toIndex; index ++)
            subList.add(get(index));
        
        return subList;
    }
    
    @Override
    public int getSize() {
        return getLastIndex() - getFirstIndex() + 1;
    }
}
