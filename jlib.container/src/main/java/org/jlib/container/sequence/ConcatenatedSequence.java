package org.jlib.container.sequence;

import org.jlib.container.IllegalContainerStateException;
import org.jlib.core.traverser.TraverserUtility;
import org.jlib.core.traverser.Traversible;
import org.jlib.core.traverser.TwoWayTraversible;
import org.jlib.core.valueholder.AccessibleValueHolder;
import org.jlib.core.valueholder.InitializedValueHolder;

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

    /** array of concatenated {@link TwoWayTraversible} items */
    private final TwoWayTraversible<Item>[] traversibles;

    /** total number of {@link Sequence} Items */
    private AccessibleValueHolder<Integer> itemsCountHolder = new AccessibleValueHolder<Integer>() {

        @Override
        public Integer get() {
            final int itemsCount = TraverserUtility.getItemsCount(traversibles);

            itemsCountHolder = new InitializedValueHolder<Integer>(itemsCount);

            return itemsCount;
        }
    };

    /**
     * Creates a new {@link ConcatenatedSequence}.
     * 
     * @param traversibles
     *        comma separated sequence of concatenated {@link TwoWayTraversible}
     *        items
     */
    @SafeVarargs
    public ConcatenatedSequence(final TwoWayTraversible<Item>... traversibles) {
        super();

        this.traversibles = traversibles;
    }

    @Override
    public final int getItemsCount()
    throws IllegalContainerStateException {
        return itemsCountHolder.get();
    }

    @Override
    public SequenceTraverser<Item> createTraverser() {
        return new ConcatenatedSequenceTraverser<>(this);
    }

    /**
     * Returns the {@link Traversible} items.
     * 
     * @return array of {@link TwoWayTraversible} instances
     */
    public TwoWayTraversible<Item>[] getTraversibles() {
        return traversibles;
    }
}
