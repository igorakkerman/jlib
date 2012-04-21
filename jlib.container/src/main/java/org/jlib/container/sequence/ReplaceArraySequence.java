package org.jlib.container.sequence;

/**
 * {@link ArraySequence} allowing its Elements to be replaced.
 * 
 * 
 * @param <Element>
 *        type of the elements of the {@link Sequence}
 *        
 * @author Igor Akkerman
 */
public class ReplaceArraySequence<Element>
extends ArraySequence<Element>
implements ReplaceIndexSequence<Element> {

    
    
    // @see org.jlib.container.sequence.ReplaceIndexSequence#set(int, java.lang.Object)
    @Override
    public void replace(final int index, final Element element)
    throws SequenceIndexOutOfBoundsException {
        if (index < firstIndex || index > lastIndex)
            throw new SequenceIndexOutOfBoundsException(this, index);

        delegateList.set(index - firstIndex, element);
    }
}
