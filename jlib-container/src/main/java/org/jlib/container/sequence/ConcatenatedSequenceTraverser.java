package org.jlib.container.sequence;

import org.jlib.core.array.ArrayUtility;
import org.jlib.core.traverser.TwoWayTraverser;
import org.jlib.core.traverser.TwoWayTraversible;

/**
 * {@link TwoWayTraverser} over the Items of a
 * {@link ConcatenatedSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence} instances
 * 
 * @param <Sequenze>
 *        concrete type of the {@link ConcatenatedSequence}
 * 
 * @author Igor Akkerman
 */
public class ConcatenatedSequenceTraverser<Item, Sequenze extends ConcatenatedSequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze> {

    /**
     * {@link TwoWayTraverser} of the concatenated
     * {@link TwoWayTraversible} instances
     */
    private final TwoWayTraverser<TwoWayTraversible<Item>> traversiblesTraverser;

    /**
     * {@link TwoWayTraverser} over the current
     * {@link TwoWayTraversible}
     */
    private TwoWayTraverser<Item> currentTraversibleTraverser;

    /**
     * Creates a new {@link ConcatenatedSequenceTraverser}.
     * 
     * @param concatenatedSequence
     *        {@link Sequence} of concatenated {@link Sequence} instances;
     *        {@code concatenatedSequence} may be empty
     */
    public ConcatenatedSequenceTraverser(final Sequenze concatenatedSequence) {
        super(concatenatedSequence);

        traversiblesTraverser = ArrayUtility.createTraverser(concatenatedSequence.getTraversibles());

        currentTraversibleTraverser = traversiblesTraverser.isNextItemAccessible()
            ? traversiblesTraverser.getNextItem().createTraverser()
            : EmptySequenceTraverser.<Item> getInstance();
    }

    @Override
    public boolean isPreviousItemAccessible() {
        while (!currentTraversibleTraverser.isPreviousItemAccessible()) {
            if (!traversiblesTraverser.isPreviousItemAccessible())
                return false;

            currentTraversibleTraverser = traversiblesTraverser.getPreviousItem().createTraverser();

            // navigate to the tail of the previous Sequence
            while (currentTraversibleTraverser.isNextItemAccessible())
                currentTraversibleTraverser.getNextItem();
        }

        return true;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        if (!isPreviousItemAccessible())
            throw new NoPreviousSequenceItemException(getSequence());

        return currentTraversibleTraverser.getPreviousItem();
    }

    @Override
    public boolean isNextItemAccessible() {
        while (!currentTraversibleTraverser.isNextItemAccessible()) {
            if (!traversiblesTraverser.isNextItemAccessible())
                return false;

            currentTraversibleTraverser = traversiblesTraverser.getNextItem().createTraverser();
        }

        return true;
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        if (!isNextItemAccessible())
            throw new NoPreviousSequenceItemException(getSequence());

        return currentTraversibleTraverser.getPreviousItem();
    }

}
