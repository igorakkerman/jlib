package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.ObservedRemoveTailSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SoleItemNotRemoveableException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.OperatorException;
import org.jlib.core.observer.ValueObserver;

/**
 * {@link ReplaceAppendArraySequence} into which Items can be inserted.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendRemoveTailArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements ObservedRemoveTailSequence<Item> {

    /**
     * Creates a new {@link ReplaceAppendRemoveTailArraySequence} with the
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
    protected ReplaceAppendRemoveTailArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void removeLastItem()
    throws SoleItemNotRemoveableException {
        final int lastIndex = getLastIndex();

        if (lastIndex == getFirstIndex())
            throw new SoleItemNotRemoveableException(this);

        setLastIndex(lastIndex - 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeLastItem(final ValueObserver<Item>... observers) {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate()
            throws OperatorException {
                try {
                    removeLastItem();
                }
                catch (final SoleItemNotRemoveableException exception) {
                    throw new OperatorException("removeLastItem {0}", exception);
                }
            }
        },

        getStoredItem(getLastIndex()), observers);
    }
}
