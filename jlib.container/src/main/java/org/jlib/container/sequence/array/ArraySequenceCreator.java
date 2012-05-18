package org.jlib.container.sequence.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InitializeableIndexSequenceCreator;

/**
 * {@link InitializeableIndexSequenceCreator} for {@link ArraySequence}
 * instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */

public class ArraySequenceCreator<Element>
extends InitializeableIndexSequenceCreator<Element, ArraySequence<Element>> {

    /** sole {@link ArraySequenceCreator} instance */
    private static final ArraySequenceCreator<?> INSTANCE = new ArraySequenceCreator<>();

    /**
     * Returns the sole {@link ArraySequenceCreator} instance.
     * 
     * @return sole {@link ArraySequenceCreator} instance
     */
    @SuppressWarnings("unchecked")
    public static <Element> ArraySequenceCreator<Element> getInstance() {
        return (ArraySequenceCreator<Element>) INSTANCE;
    }

    /**
     * Creates a new {@link ArraySequenceCreator}.
     */
    protected ArraySequenceCreator() {
        super();
    }

    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new ArraySequence<Element>(firstIndex, lastIndex);
    }
}
