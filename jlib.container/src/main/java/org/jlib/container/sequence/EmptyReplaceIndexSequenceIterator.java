package org.jlib.container.sequence;

/**
 * {@link ReplaceIndexSequenceIterator} of an {@link EmptyReplaceIndexSequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EmptyReplaceIndexSequenceIterator<Element>
extends EmptyIndexSequenceIterator<Element>
implements ReplaceIndexSequenceIterator<Element> {

    /** sole instance of this class */
    private static final EmptyReplaceIndexSequenceIterator<?> INSTANCE = new EmptyReplaceIndexSequenceIterator<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link EmptyReplaceIndexSequenceIterator}
     */
    @SuppressWarnings("unchecked")
    public static <Element> EmptyReplaceIndexSequenceIterator<Element> getInstance() {
        return (EmptyReplaceIndexSequenceIterator<Element>) INSTANCE;
    }

    /**
     * Creates a new EmptyReplaceIndexSequenceIterator.
     */
    private EmptyReplaceIndexSequenceIterator() {}


    @Override
    public void replace(Element element)
    throws IllegalStateException {
        throw new IllegalStateException();
    }
}
