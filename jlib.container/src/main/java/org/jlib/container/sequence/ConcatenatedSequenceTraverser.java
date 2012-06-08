package org.jlib.container.sequence;

import org.jlib.core.array.ArrayTraverser;
import org.jlib.core.traverser.BidirectionalTraverser;

/**
 * {@link BidirectionalTraverser} over the Items of a
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
     * {@link BidirectionalTraverser} of the concatenated {@link Sequence}
     * instances
     */
    private final BidirectionalTraverser<Sequence<Item>> sequencesTraverser;

    /** {@link SequenceTraverser} of current {@link Sequence} */
    private SequenceTraverser<Item> currentSequenceTraverser;

    /**
     * Creates a new {@link ConcatenatedSequenceTraverser}.
     * 
     * @param concatenatedSequence
     *        {@link Sequence} of concatenated {@link Sequence} instances;
     *        {@code concatenatedSequence} may be empty
     */
    public ConcatenatedSequenceTraverser(final Sequenze concatenatedSequence) {
        super(concatenatedSequence);

        sequencesTraverser = new ArrayTraverser<>(concatenatedSequence.getSequences());

        currentSequenceTraverser = sequencesTraverser.isNextItemAccessible()
            ? sequencesTraverser.getNextItem().createSequenceTraverser()
            : EmptySequenceTraverser.<Item> getInstance();
    }

    @Override
    public boolean isPreviousItemAccessible() {
        while (!currentSequenceTraverser.isPreviousItemAccessible()) {
            if (!sequencesTraverser.isPreviousItemAccessible())
                return false;

            currentSequenceTraverser = sequencesTraverser.getPreviousItem().createSequenceTraverser();

            // navigate to the tail of the previous Sequence
            while (currentSequenceTraverser.isNextItemAccessible())
                currentSequenceTraverser.getNextItem();
        }

        return true;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        if (!isPreviousItemAccessible())
            throw new NoPreviousSequenceItemException(getSequence());

        return currentSequenceTraverser.getPreviousItem();
    }

    @Override
    public boolean isNextItemAccessible() {
        while (!currentSequenceTraverser.isNextItemAccessible()) {
            if (!sequencesTraverser.isNextItemAccessible())
                return false;

            currentSequenceTraverser = sequencesTraverser.getNextItem().createSequenceTraverser();
        }

        return true;
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        if (!isNextItemAccessible())
            throw new NoPreviousSequenceItemException(getSequence());

        return currentSequenceTraverser.getPreviousItem();
    }

}
