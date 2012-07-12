package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.RemoveHeadSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SoleItemNotRemoveableException;

/**
 * {@link ReplaceAppendArraySequence} from which Items can be removed at its
 * ends, that is, its head and tail.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendRemoveFirstLastArraySequence<Item>
extends ReplaceAppendRemoveLastArraySequence<Item>
implements RemoveHeadSequence<Item> {

    /**
     * Creates a new {@link ReplaceAppendRemoveFirstLastArraySequence} with the
     * specified first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @throws IllegalArgumentException
     *         if {@code lastIndex > firstIndex}
     */
    protected ReplaceAppendRemoveFirstLastArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void removeFirstItem() {
        final int firstIndex = getFirstIndex();

        if (firstIndex == getLastIndex())
            throw new SoleItemNotRemoveableException(this);

        setFirstIndex(firstIndex + 1);
    }
}
