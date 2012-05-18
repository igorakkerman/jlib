package org.jlib.container.sequence.array;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InitializeableIndexSequenceCreator;

/**
 * {@link InitializeableIndexSequenceCreator} for {@link ReplaceArraySequence}
 * instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */

public class ReplaceArraySequenceCreator<Element>
extends InitializeableIndexSequenceCreator<Element, ReplaceArraySequence<Element>> {

    /** sole {@link ReplaceArraySequenceCreator} instance */
    private static final ReplaceArraySequenceCreator<?> INSTANCE = new ReplaceArraySequenceCreator<>();

    /**
     * Returns the sole {@link ReplaceArraySequenceCreator} instance.
     * 
     * @return sole {@link ReplaceArraySequenceCreator} instance
     */
    @SuppressWarnings("unchecked")
    public static <Element> ReplaceArraySequenceCreator<Element> getInstance() {
        return (ReplaceArraySequenceCreator<Element>) INSTANCE;
    }

    /**
     * Creates a new {@link ReplaceArraySequenceCreator}.
     */
    protected ReplaceArraySequenceCreator() {
        super();
    }

    @Override
    public ReplaceArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new ReplaceArraySequence<Element>(firstIndex, lastIndex);
    }
}
