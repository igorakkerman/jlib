package org.jlib.container.sequence;

import org.jlib.container.ContainerUtility;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.core.traverser.Traverser;

/**
 * {@link Sequence} representing the concatenation of other {@link Sequence}
 * instances.
 * 
 * @param <Item>
 *        type of items held in the {@link ConcatenatedSequence}
 * 
 * @author Igor Akkerman
 */
public class ConcatenatedSequence<Item>
extends AbstractSequence<Item> {

    /** array of concatenated {@link Sequence} items */
    private final Sequence<Item>[] sequences;

    /** total number of {@link Sequence} Items */
    private final int itemsCount;

    /**
     * Creates a new {@link ConcatenatedSequence}.
     * 
     * @param sequences
     *        comma separated sequence of concatenated {@link Sequence} items
     */
    @SafeVarargs
    public ConcatenatedSequence(final Sequence<Item>... sequences) {
        super();

        this.sequences = sequences;

        itemsCount = ContainerUtility.getItemsCount(sequences);
    }

    @Override
    public final int getSize()
    throws IllegalContainerStateException {
        return itemsCount;
    }

    @Override
    public Traverser<Item> createTraverser() {
        return createSequenceTraverser();
    }

    @Override
    public SequenceTraverser<Item> createSequenceTraverser() {
        return new ConcatenatedSequenceTraverser<>(this);
    }

    /**
     * Returns the concatenated {@link Sequence} instances.
     * 
     * @return array of the concatenated {@link Sequence} items
     */
    public Sequence<Item>[] getSequences() {
        return sequences;
    }
}
