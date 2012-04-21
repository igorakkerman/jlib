package org.jlib.container.sequence;

/**
 * Empty {@link ReplaceIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EmptyReplaceIndexSequence<Element>
extends EmptyIndexSequence<Element>
implements ReplaceIndexSequence<Element> {

    /** sole instance of this class */
    private static final EmptyReplaceIndexSequence<?> INSTANCE = new EmptyReplaceIndexSequence<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link EmptyReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Element> EmptyReplaceIndexSequence<Element> getInstance() {
        return (EmptyReplaceIndexSequence<Element>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyReplaceIndexSequence}.
     */
    private EmptyReplaceIndexSequence() {
        super();
    }


    @Override
    public void replace(final int index, final Element element)
    throws SequenceIndexOutOfBoundsException {
        throw new SequenceIndexOutOfBoundsException(this, index);
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator() {
        return EmptyReplaceIndexSequenceIterator.getInstance();
    }
}
